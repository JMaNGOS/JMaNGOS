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
package org.jmangos.tools.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.jmangos.tools.dbc.dataholder.DBCStruct;

public class SpellEffectEntry extends DBCStruct<WorldMapAreaEntry> {

    @XmlAttribute(name = "id")
    public final Unsigned32 ID = new Unsigned32();
    @XmlAttribute(name = "effect")
    public final Unsigned32 effect = new Unsigned32();
    @XmlAttribute(name = "areaId")
    public final Float32 effectAmplitude = new Float32();
    @XmlAttribute(name = "effectAura")
    public final Unsigned32 effectAura = new Unsigned32();
    @XmlAttribute(name = "m_effectAuraPeriod")
    public final Unsigned32 m_effectAuraPeriod = new Unsigned32();
    @XmlAttribute(name = "m_effectBasePoints")
    public final Signed32 m_effectBasePoints = new Signed32();
    @XmlAttribute(name = "m_effectUnk_320")
    public final Float32 m_effectUnk_320 = new Float32();
    @XmlAttribute(name = "m_effectChainAmplitude")
    public final Float32 m_effectChainAmplitude = new Float32();
    @XmlAttribute(name = "m_effectChainTargets")
    public final Unsigned32 m_effectChainTargets = new Unsigned32();
    @XmlAttribute(name = "m_effectDieSides")
    public final Unsigned32 m_effectDieSides = new Unsigned32();
    @XmlAttribute(name = "m_effectItemType")
    public final Unsigned32 m_effectItemType = new Unsigned32();
    @XmlAttribute(name = "m_effectMechanic")
    public final Unsigned32 m_effectMechanic = new Unsigned32();
    @XmlAttribute(name = "m_effectMiscValue")
    public final Signed32 m_effectMiscValue = new Signed32();
    @XmlAttribute(name = "m_effectMiscValueB")
    public final Signed32 m_effectMiscValueB = new Signed32();
    @XmlAttribute(name = "m_effectPointsPerCombo")
    public final Float32 m_effectPointsPerCombo = new Float32();
    @XmlAttribute(name = "m_effectRadiusIndex")
    public final Unsigned32 m_effectRadiusIndex = new Unsigned32();
    @XmlAttribute(name = "m_effectRadiusMaxIndex")
    public final Unsigned32 m_effectRadiusMaxIndex = new Unsigned32();
    @XmlAttribute(name = "m_effectRealPointsPerLevel")
    public final Float32 m_effectRealPointsPerLevel = new Float32();
    @XmlAttribute(name = "m_effectSpellClassMask_1")
    public final Unsigned32 m_effectSpellClassMask_1 = new Unsigned32();
    @XmlAttribute(name = "m_effectSpellClassMask_2")
    public final Unsigned32 m_effectSpellClassMask_2 = new Unsigned32();
    @XmlAttribute(name = "m_effectSpellClassMask_3")
    public final Unsigned32 m_effectSpellClassMask_3 = new Unsigned32();
    @XmlAttribute(name = "m_effectTriggerSpell")
    public final Signed32 m_effectTriggerSpell = new Signed32();
    @XmlAttribute(name = "m_implicitTargetA")
    public final Unsigned32 m_implicitTargetA = new Unsigned32();
    @XmlAttribute(name = "m_implicitTargetB")
    public final Unsigned32 m_implicitTargetB = new Unsigned32();
    @XmlAttribute(name = "m_effectSpellId")
    public final Unsigned32 m_effectSpellId = new Unsigned32();
    @XmlAttribute(name = "m_effectIndex")
    public final Unsigned32 m_effectIndex = new Unsigned32();
}
