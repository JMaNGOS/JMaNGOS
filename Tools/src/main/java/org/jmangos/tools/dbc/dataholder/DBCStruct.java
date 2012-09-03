/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package org.jmangos.tools.dbc.dataholder;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

public abstract class DBCStruct<T extends DBCStruct<T>> extends DBCBaseStruct implements Iterable<T>, Iterator<T>, Cloneable {
    
    private int      count;
    private int      skiplenght   = 0;
    private int      currposition = 0;
    private Object[] FiledsName;
    private boolean  mode;
    
    @SuppressWarnings("unchecked")
    @Override
    protected <M extends Member> M[] array(final M[] param) {
    
        if (param.length > 0) {
            if (INTERNALSTRING.isInstance(param)) {
                for (int i = 0; i < param.length;) {
                    param[i++] = (M) new InternalString();
                }
                return param;
            } else {
                return super.array(param);
            }
        } else {
            return null;
        }
    }
    
    @SuppressWarnings("unchecked")
    public T LookupEntry(final int i) {
    
        setCurrposition(i);
        setByteBufferPosition(HEADER_SIZE + ((size() + this.skiplenght) * i));
        return (T) this;
    }
    
    public final void setStringBufferPosition(final int stringBufPos) {
    
        this.stringBufPos = stringBufPos;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T clone() {
    
        T re = null;
        try {
            re = (T) this.getClass().newInstance();
        } catch (final InstantiationException e) {
            e.printStackTrace();
        } catch (final IllegalAccessException e1) {
            e1.printStackTrace();
        }
        re.setByteBuffer(getByteBuffer(), getByteBufferPosition());
        re.setStringBufferPosition(this.stringBufPos);
        return re;
    }
    
    public int getCount() {
    
        return this.count;
    }
    
    public void setCount(final int count) {
    
        this.count = count;
    }
    
    public int getSkiplenght() {
    
        return this.skiplenght;
    }
    
    public void setSkipLenght(final int skiplenght) {
    
        this.skiplenght = skiplenght;
    }
    
    @Override
    public boolean hasNext() {
    
        return (this.currposition + 1) < getCount();
    }
    
    @Override
    public T next() {
    
        if (hasNext()) {
            return LookupEntry(this.currposition + 1);
        }
        return null;
    }
    
    @Override
    public void remove() {
    
    }
    
    public void saveToXML(final String path, final boolean full) throws IOException {
    
        this.mode = full;
        final Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + this.getClass().getSimpleName() + ".xml"), "UTF-8"));
        try {
            final String header = this.getClass().getSimpleName() + "List";
            cacheFields(full);
            out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n");
            out.write("<" + header + ">\n");
            toXML(out);
            out.write("</" + header + ">");
            out.flush();
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
    
    public void cacheFields(final boolean mode) {
    
        final Field[] f = this.getClass().getFields();
        final List<String> TFiledsName = new ArrayList<String>();
        for (int i = 0; i < f.length; i++) {
            if (Modifier.isStatic(f[i].getModifiers()) || !f[i].isAnnotationPresent(XmlAttribute.class)) {
                continue;
            }
            final XmlAttribute property = f[i].getAnnotation(XmlAttribute.class);
            if ((property.name() != null) & (property.required() | mode)) {
                try {
                    if (f[i].getType().isArray()) {
                        final Object sd = f[i].get(this);
                        for (int j = 0; j < Array.getLength(sd); j++) {
                            TFiledsName.add(property.name() + (j + 1));
                        }
                    } else if ((f[i].getType() == InternalString.class) || (f[i].getType() == MultiInternalString.class)) {
                        if (mode) {
                            TFiledsName.add(property.name());
                        }
                    } else {
                        TFiledsName.add(property.name());
                    }
                } catch (final IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (final IllegalAccessException e) {
                    e.printStackTrace();
                }
                
            }
        };
        this.FiledsName = TFiledsName.toArray();
    }
    
    public void toXML(final Writer out) throws IOException {
    
        final Field[] f = this.getClass().getFields();
        int counter = 0;
        do {
            out.write("\t<" + this.getClass().getSimpleName() + " ");
            for (int i = 0; i < f.length; i++) {
                if (Modifier.isStatic(f[i].getModifiers()) || !f[i].isAnnotationPresent(XmlAttribute.class)) {
                    continue;
                }
                final XmlAttribute property = f[i].getAnnotation(XmlAttribute.class);
                if ((property.name() != null) & (property.required() | this.mode)) {
                    try {
                        if ((f[i].getType() == InternalString.class) || (f[i].getType() == MultiInternalString.class)) {
                            if (this.mode) {
                                final String escapedString = escapeCharacters((f[i].get(this)).toString());
                                if ((escapedString.length() > 0) | property.required()) {
                                    writeAttr((String) this.FiledsName[counter], escapedString, out);
                                }
                                counter++;
                            }
                        } else if (f[i].getType().isArray()) {
                            final Object sd = f[i].get(this);
                            for (int j = 0; j < Array.getLength(sd); j++) {
                                Array.get(sd, j);
                                writeAttr((String) this.FiledsName[counter++], Array.get(sd, j).toString(), out);
                            }
                        } else {
                            writeAttr((String) this.FiledsName[counter++], f[i].get(this).toString(), out);
                        }
                        
                    } catch (final IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (final IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    
                }
            }
            out.write("/>\n");
            counter = 0;
        } while (this.next() != null);
    }
    
    public void writeAttr(final String name, final String value, final Writer out) throws IOException {
    
        out.write(name + "=\"" + value + "\" ");
    }
    
    public String escapeCharacters(final String str) {
    
        if (str == null) {
            return "";
        }
        StringBuffer s = new StringBuffer(str);
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '\"':
                    s = s.replace(i++, i, "&quot;");
                    break;
                case '&':
                    s = s.replace(i++, i, "&amp;");
                    break;
                case '<':
                    s = s.replace(i++, i, "&lt;");
                    break;
                case '>':
                    s = s.replace(i++, i, "&gt;");
                    break;
                case '\'':
                    s = s.replace(i++, i, "&apos;");
                    break;
                default:
                    break;
            }
        }
        return s.toString();
    }
    
    public void setCurrposition(final int currposition) {
    
        this.currposition = currposition;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T iterator() {
    
        return (T) this;
    }
}
