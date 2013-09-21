/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.tools.m2;

/**
 * 
 * @author MinimaJack
 * 
 */
public class Data {

    /**
     * Name.
     */
    private String name;
    /**
     * Vertexes.
     */
    private Vertex[] vertexes;
    /**
     * GlobalSequences.
     */
    private int[] globalSequences;
    /**
     * AnimationLookups
     */
    private short[] animationLookups;
    /**
     * RenderFlags
     */
    private int[] renderFlags;
    /**
     * BoneLookupTable
     */
    private short[] boneLookupTable;
    /**
     * KeyBoneLookupTable
     */
    private short[] keyBoneLookupTable;
    /**
     * AnimationSequence
     */
    private AnimationSequence[] animations;
    /**
     * Textures
     */
    private Textures[] textures;

    /**
     * @return the name
     */
    public final String getName() {

        return this.name;
    }

    /**
     * @param givenName
     *        the name to set
     */
    public final void setName(final String givenName) {

        this.name = givenName;
    }

    /**
     * @return the vertexes
     */
    public final Vertex[] getVertexes() {

        return this.vertexes;
    }

    /**
     * @param givenVertexes
     *        the vertexes to set
     */
    public final void setVertexes(final Vertex[] givenVertexes) {

        this.vertexes = givenVertexes;
    }

    /**
     * @return the globalSequences
     */
    public final int[] getGlobalSequences() {

        return this.globalSequences;
    }

    /**
     * @param glSequences
     *        the globalSequences to set
     */
    public final void setGlobalSequences(final int[] glSequences) {

        this.globalSequences = glSequences;
    }

    /**
     * @return the animationLookups
     */
    public final short[] getAnimationLookups() {

        return this.animationLookups;
    }

    /**
     * @param animLookups
     *        the animationLookups to set
     */
    public final void setAnimationLookups(final short[] animLookups) {

        this.animationLookups = animLookups;
    }

    /**
     * @return the renderFlags
     */
    public final int[] getRenderFlags() {

        return this.renderFlags;
    }

    /**
     * @param renderFlag
     *        the renderFlags to set
     */
    public final void setRenderFlags(final int[] renderFlag) {

        this.renderFlags = renderFlag;
    }

    /**
     * @return the boneLookupTable
     */
    public final short[] getBoneLookupTable() {

        return this.boneLookupTable;
    }

    /**
     * @param boneLookupTables
     *        the boneLookupTable to set
     */
    public final void setBoneLookupTable(final short[] boneLookupTables) {

        this.boneLookupTable = boneLookupTables;
    }

    /**
     * @return the keyBoneLookupTable
     */
    public final short[] getKeyBoneLookupTable() {

        return this.keyBoneLookupTable;
    }

    /**
     * @param keyBoneLookupTables
     *        the keyBoneLookupTable to set
     */
    public final void setKeyBoneLookupTable(final short[] keyBoneLookupTables) {

        this.keyBoneLookupTable = keyBoneLookupTables;
    }

    /**
     * @return the animations
     */
    public final AnimationSequence[] getAnimations() {

        return this.animations;
    }

    /**
     * @param animation
     *        the animations to set
     */
    public final void setAnimations(final AnimationSequence[] animation) {

        this.animations = animation;
    }

    /**
     * @return the textures
     */
    public final Textures[] getTextures() {

        return this.textures;
    }

    /**
     * @param usedTextures
     *        the textures to set
     */
    public final void setTextures(final Textures[] usedTextures) {

        this.textures = usedTextures;
    }
}
