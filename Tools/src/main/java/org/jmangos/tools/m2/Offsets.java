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
class Offsets {

    /**
     * Offset Name
     */
    private int ofsName;
    /**
     * Offset GlobalSequences
     */
    private int ofsGlobalSequences;
    /**
     * Offset Animations
     */
    private int ofsAnimations;
    /**
     * Offset AnimationLookup
     */
    private int ofsAnimationLookup;
    /**
     * Offset Bones
     */
    private int ofsBones;
    /**
     * Offset KeyBoneLookup
     */
    private int ofsKeyBoneLookup;
    /**
     * Offset Vertices
     */
    private int ofsVertices;
    /**
     * Offset Colors
     */
    private int ofsColors;
    /**
     * Offset Textures
     */
    private int ofsTextures;
    /**
     * Offset Transparency
     */
    private int ofsTransparency;
    /**
     * Offset TextureAnimations
     */
    private int ofsTextureAnimations;
    /**
     * Offset TexReplace
     */
    private int ofsTexReplace;
    /**
     * Offset RenderFlags
     */
    private int ofsRenderFlags;
    /**
     * Offset BoneLookupTable
     */
    private int ofsBoneLookupTable;
    /**
     * Offset TexLookup
     */
    private int ofsTexLookup;
    /**
     * Offset TexUnits
     */
    private int ofsTexUnits;
    /**
     * Offset BoundTriangles
     */
    private int ofsBoundTriangles;
    /**
     * Offset BoundingVertices
     */
    private int ofsBoundingVertices;
    /**
     * Offset BoundingNormals
     */
    private int ofsBoundingNormals;
    /**
     * Offset Attachments
     */
    private int ofsAttachments;
    /**
     * Offset AttachLookup
     */
    private int ofsAttachLookup;
    /**
     * Offset Attachments2
     */
    private int ofsAttachments2;
    /**
     * Offset Lights
     */
    private int ofsLights;
    /**
     * Offset Cameras
     */
    private int ofsCameras;
    /**
     * Offset CameraLookup
     */
    private int ofsCameraLookup;
    /**
     * Offset RibbonEmitters
     */
    private int ofsRibbonEmitters;
    /**
     * Offset ParticleEmitters
     */
    private int ofsParticleEmitters;
    /**
     * Offset Unknown
     */
    private int ofsUnknown;
    /**
     * Offset TransLookup
     */
    private int ofsTransLookup;

    /**
     * @return the ofsName
     */
    public final int getOfsName() {

        return this.ofsName;
    }

    /**
     * @param givenofsName
     *        the ofsName to set
     */
    public final void setOfsName(final int givenofsName) {

        this.ofsName = givenofsName;
    }

    /**
     * @return the ofsGlobalSequences
     */
    public final int getOfsGlobalSequences() {

        return this.ofsGlobalSequences;
    }

    /**
     * @param givenofsGlobalSequences
     *        the ofsGlobalSequences to set
     */
    public final void setOfsGlobalSequences(final int givenofsGlobalSequences) {

        this.ofsGlobalSequences = givenofsGlobalSequences;
    }

    /**
     * @return the ofsAnimations
     */
    public final int getOfsAnimations() {

        return this.ofsAnimations;
    }

    /**
     * @param givenofsAnimations
     *        the ofsAnimations to set
     */
    public final void setOfsAnimations(final int givenofsAnimations) {

        this.ofsAnimations = givenofsAnimations;
    }

    /**
     * @return the ofsAnimationLookup
     */
    public final int getOfsAnimationLookup() {

        return this.ofsAnimationLookup;
    }

    /**
     * @param givenofsAnimationLookup
     *        the ofsAnimationLookup to set
     */
    public final void setOfsAnimationLookup(final int givenofsAnimationLookup) {

        this.ofsAnimationLookup = givenofsAnimationLookup;
    }

    /**
     * @return the ofsBones
     */
    public final int getOfsBones() {

        return this.ofsBones;
    }

    /**
     * @param givenofsBones
     *        the ofsBones to set
     */
    public final void setOfsBones(final int givenofsBones) {

        this.ofsBones = givenofsBones;
    }

    /**
     * @return the ofsKeyBoneLookup
     */
    public final int getOfsKeyBoneLookup() {

        return this.ofsKeyBoneLookup;
    }

    /**
     * @param givenofsKeyBoneLookup
     *        the ofsKeyBoneLookup to set
     */
    public final void setOfsKeyBoneLookup(final int givenofsKeyBoneLookup) {

        this.ofsKeyBoneLookup = givenofsKeyBoneLookup;
    }

    /**
     * @return the ofsVertices
     */
    public final int getOfsVertices() {

        return this.ofsVertices;
    }

    /**
     * @param givenofsVertices
     *        the ofsVertices to set
     */
    public final void setOfsVertices(final int givenofsVertices) {

        this.ofsVertices = givenofsVertices;
    }

    /**
     * @return the ofsColors
     */
    public final int getOfsColors() {

        return this.ofsColors;
    }

    /**
     * @param givenofsColors
     *        the ofsColors to set
     */
    public final void setOfsColors(final int givenofsColors) {

        this.ofsColors = givenofsColors;
    }

    /**
     * @return the ofsTextures
     */
    public final int getOfsTextures() {

        return this.ofsTextures;
    }

    /**
     * @param givenofsTextures
     *        the ofsTextures to set
     */
    public final void setOfsTextures(final int givenofsTextures) {

        this.ofsTextures = givenofsTextures;
    }

    /**
     * @return the ofsTransparency
     */
    public final int getOfsTransparency() {

        return this.ofsTransparency;
    }

    /**
     * @param givenofsTransparency
     *        the ofsTransparency to set
     */
    public final void setOfsTransparency(final int givenofsTransparency) {

        this.ofsTransparency = givenofsTransparency;
    }

    /**
     * @return the ofsTextureAnimations
     */
    public final int getOfsTextureAnimations() {

        return this.ofsTextureAnimations;
    }

    /**
     * @param givenofsTextureAnimations
     *        the ofsTextureAnimations to set
     */
    public final void setOfsTextureAnimations(final int givenofsTextureAnimations) {

        this.ofsTextureAnimations = givenofsTextureAnimations;
    }

    /**
     * @return the ofsTexReplace
     */
    public final int getOfsTexReplace() {

        return this.ofsTexReplace;
    }

    /**
     * @param givenofsTexReplace
     *        the ofsTexReplace to set
     */
    public final void setOfsTexReplace(final int givenofsTexReplace) {

        this.ofsTexReplace = givenofsTexReplace;
    }

    /**
     * @return the ofsRenderFlags
     */
    public final int getOfsRenderFlags() {

        return this.ofsRenderFlags;
    }

    /**
     * @param givenofsRenderFlags
     *        the ofsRenderFlags to set
     */
    public final void setOfsRenderFlags(final int givenofsRenderFlags) {

        this.ofsRenderFlags = givenofsRenderFlags;
    }

    /**
     * @return the ofsBoneLookupTable
     */
    public final int getOfsBoneLookupTable() {

        return this.ofsBoneLookupTable;
    }

    /**
     * @param givenofsBoneLookupTable
     *        the ofsBoneLookupTable to set
     */
    public final void setOfsBoneLookupTable(final int givenofsBoneLookupTable) {

        this.ofsBoneLookupTable = givenofsBoneLookupTable;
    }

    /**
     * @return the ofsTexLookup
     */
    public final int getOfsTexLookup() {

        return this.ofsTexLookup;
    }

    /**
     * @param givenofsTexLookup
     *        the ofsTexLookup to set
     */
    public final void setOfsTexLookup(final int givenofsTexLookup) {

        this.ofsTexLookup = givenofsTexLookup;
    }

    /**
     * @return the ofsTexUnits
     */
    public final int getOfsTexUnits() {

        return this.ofsTexUnits;
    }

    /**
     * @param givenofsTexUnits
     *        the ofsTexUnits to set
     */
    public final void setOfsTexUnits(final int givenofsTexUnits) {

        this.ofsTexUnits = givenofsTexUnits;
    }

    /**
     * @return the ofsBoundTriangles
     */
    public final int getOfsBoundTriangles() {

        return this.ofsBoundTriangles;
    }

    /**
     * @param givenofsBoundTriangles
     *        the ofsBoundTriangles to set
     */
    public final void setOfsBoundTriangles(final int givenofsBoundTriangles) {

        this.ofsBoundTriangles = givenofsBoundTriangles;
    }

    /**
     * @return the ofsBoundingVertices
     */
    public final int getOfsBoundingVertices() {

        return this.ofsBoundingVertices;
    }

    /**
     * @param givenofsBoundingVertices
     *        the ofsBoundingVertices to set
     */
    public final void setOfsBoundingVertices(final int givenofsBoundingVertices) {

        this.ofsBoundingVertices = givenofsBoundingVertices;
    }

    /**
     * @return the ofsBoundingNormals
     */
    public final int getOfsBoundingNormals() {

        return this.ofsBoundingNormals;
    }

    /**
     * @param givenofsBoundingNormals
     *        the ofsBoundingNormals to set
     */
    public final void setOfsBoundingNormals(final int givenofsBoundingNormals) {

        this.ofsBoundingNormals = givenofsBoundingNormals;
    }

    /**
     * @return the ofsAttachments
     */
    public final int getOfsAttachments() {

        return this.ofsAttachments;
    }

    /**
     * @param givenofsAttachments
     *        the ofsAttachments to set
     */
    public final void setOfsAttachments(final int givenofsAttachments) {

        this.ofsAttachments = givenofsAttachments;
    }

    /**
     * @return the ofsAttachLookup
     */
    public final int getOfsAttachLookup() {

        return this.ofsAttachLookup;
    }

    /**
     * @param givenofsAttachLookup
     *        the ofsAttachLookup to set
     */
    public final void setOfsAttachLookup(final int givenofsAttachLookup) {

        this.ofsAttachLookup = givenofsAttachLookup;
    }

    /**
     * @return the ofsAttachments2
     */
    public final int getOfsAttachments2() {

        return this.ofsAttachments2;
    }

    /**
     * @param givenofsAttachments2
     *        the ofsAttachments2 to set
     */
    public final void setOfsAttachments2(final int givenofsAttachments2) {

        this.ofsAttachments2 = givenofsAttachments2;
    }

    /**
     * @return the ofsLights
     */
    public final int getOfsLights() {

        return this.ofsLights;
    }

    /**
     * @param givenofsLights
     *        the ofsLights to set
     */
    public final void setOfsLights(final int givenofsLights) {

        this.ofsLights = givenofsLights;
    }

    /**
     * @return the ofsCameras
     */
    public final int getOfsCameras() {

        return this.ofsCameras;
    }

    /**
     * @param givenofsCameras
     *        the ofsCameras to set
     */
    public final void setOfsCameras(final int givenofsCameras) {

        this.ofsCameras = givenofsCameras;
    }

    /**
     * @return the ofsCameraLookup
     */
    public final int getOfsCameraLookup() {

        return this.ofsCameraLookup;
    }

    /**
     * @param givenofsCameraLookup
     *        the ofsCameraLookup to set
     */
    public final void setOfsCameraLookup(final int givenofsCameraLookup) {

        this.ofsCameraLookup = givenofsCameraLookup;
    }

    /**
     * @return the ofsRibbonEmitters
     */
    public final int getOfsRibbonEmitters() {

        return this.ofsRibbonEmitters;
    }

    /**
     * @param givenofsRibbonEmitters
     *        the ofsRibbonEmitters to set
     */
    public final void setOfsRibbonEmitters(final int givenofsRibbonEmitters) {

        this.ofsRibbonEmitters = givenofsRibbonEmitters;
    }

    /**
     * @return the ofsParticleEmitters
     */
    public final int getOfsParticleEmitters() {

        return this.ofsParticleEmitters;
    }

    /**
     * @param givenofsParticleEmitters
     *        the ofsParticleEmitters to set
     */
    public final void setOfsParticleEmitters(final int givenofsParticleEmitters) {

        this.ofsParticleEmitters = givenofsParticleEmitters;
    }

    /**
     * @return the ofsUnknown
     */
    public final int getOfsUnknown() {

        return this.ofsUnknown;
    }

    /**
     * @param givenofsUnknown
     *        the ofsUnknown to set
     */
    public final void setOfsUnknown(final int givenofsUnknown) {

        this.ofsUnknown = givenofsUnknown;
    }

    /**
     * @return the ofsTransLookup
     */
    public final int getOfsTransLookup() {

        return this.ofsTransLookup;
    }

    /**
     * @param givenofsTransLookup
     *        the ofsTransLookup to set
     */
    public final void setOfsTransLookup(final int givenofsTransLookup) {

        this.ofsTransLookup = givenofsTransLookup;
    }
}
