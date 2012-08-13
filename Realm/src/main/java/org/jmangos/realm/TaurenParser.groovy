package org.jmangos.realm

/**
 * Created with IntelliJ IDEA.
 * User: paalgyula
 * email: paalgyula@gmail.com
 * Date: 2012.08.12.
 * Time: 22:23
 */
public class TaurenParser {


    public static void main( String[] args ) {
        def bais = new ByteArrayInputStream( TaurenBytes.b );
        def size = bais.read()
        def updateType = bais.read()

        def wowguid = new byte[8];
        bais.read( wowguid )

        def baos = new ByteArrayOutputStream()

        def uint32 = new byte[4]

        for ( int i = 0; i < size; i++ ) {
            bais.read( uint32 )
            baos.write( uint32 )
        }

        def bytes = baos.toByteArray();

        BitSet bits = new BitSet();
        for (int i=0; i<bytes.length*8; i++) {
            if ((bytes[(int)bytes.length-i/8-1]&(1<<(i%8))) > 0) {
                bits.set(i);
            }
        }

        def i=0;
        for (i = 0;i<bits.length();i++) {
            if ( !bits[i] )
                continue;

            def readByte = new byte[4];
            bais.read( readByte );
            print i + ","
        }

        // Ami most benne van, az a maradek az adat.

    }
}