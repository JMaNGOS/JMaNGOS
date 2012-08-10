package org.jmangos.realm.network.netty.packetClient.client;

import org.jmangos.realm.network.netty.packetClient.AbstractWoWClientPacket;

import java.nio.BufferUnderflowException;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.08.
 * Time: 2:44
 * To change this template use File | Settings | File Templates.
 */
public class MSG_MOVE_FALL_LAND extends AbstractWoWClientPacket {
    Logger log = Logger.getLogger( MSG_MOVE_FALL_LAND.class.getSimpleName() );

    /*
    transGuid = 0;
	unk13 = 0;
	data >> flags >> unk_230 >> time;
	data >> x >> y >> z >> orientation;

	if (flags & MOVEFLAG_TAXI)
	{
		data >> transGuid >> transX >> transY >> transZ >> transO >> transUnk >> transUnk_2;
	}
	if (flags & (MOVEFLAG_SWIMMING | MOVEFLAG_AIR_SWIMMING) || unk_230 & 0x20)
	{
		data >> pitch;
	}
	if (flags & MOVEFLAG_FALLING || flags & MOVEFLAG_REDIRECTED)
	{
		data >> FallTime >> unk8 >> unk9 >> unk10;
	}
	if (flags & MOVEFLAG_SPLINE_MOVER)
	{
		data >> unk12;
	}

	data >> unklast;
	if(data.rpos() != data.wpos())
	{
		if(data.rpos() + 4 == data.wpos())
			data >> unk13;
		else
			DEBUG_LOG("Extra bits of movement packet left");
	}
}

void MovementInfo::write(WorldPacket & data)
{
	data << flags << unk_230 << getMSTime();

	data << x << y << z << orientation;

	if (flags & MOVEFLAG_TAXI)
	{
		data << transGuid << transX << transY << transZ << transO << transUnk << transUnk_2;
	}
	if (flags & MOVEFLAG_SWIMMING)
	{
		data << pitch;
	}
	if (flags & MOVEFLAG_FALLING)
	{
		data << FallTime << unk8 << unk9 << unk10;
	}
	if (flags & MOVEFLAG_SPLINE_MOVER)
	{
		data << unk12;
	}
	data << unklast;
	if(unk13)
		data << unk13;
}
     */

    /*class MovementInfo {
        uint32 time;
        float pitch;// -1.55=looking down, 0=looking forward, +1.55=looking up
        uint32 unk8;//on slip 8 is zero, on jump some other number
        uint32 unk9, unk10;//9,10 changes if you are not on foot
        uint32 unk11, unk12;
        uint8 unk13;
        uint32 unklast;//something related to collision
        uint16 unk_230;

        float x, y, z, orientation;
        uint32 flags;
        uint32 FallTime;
        uint64 transGuid;
        float transX, transY, transZ, transO, transUnk;
        uint8 transUnk_2;

        void init(WorldPacket & data);
        void write(WorldPacket & data);
    };*/

    Integer flags;
    Integer unk_230;
    Integer time;
    Float x, y, z, orientation;

    Integer fallTime;

    Integer unk8, unk9, unk10, unkLast, unk13;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
        log.info( "Movement packet received" );

        flags = readD();
        unk_230 = readH();
        time = readD();

        x = readF();
        y = readF();
        z = readF();
        orientation = readF();

        // Epp lepottyant, most nincs ilyen
        /*
        fallTime = readD();

        unk8 = readD();
        unk9 = readD();
        unk10 = readD(); */

        unkLast = readD();

        if ( getAvaliableBytes() == 2 )
            unk13 = readC();
        else
            log.severe( "Hoppa, valami mas maradt itt: " + getAvaliableBytes() );

        skipAll();
    }

    @Override
    protected void runImpl() {

    }
}
