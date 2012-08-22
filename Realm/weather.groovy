import org.jmangos.realm.model.base.update.*;

import org.apache.log4j.Logger;
import org.jmangos.realm.model.UpdateType;
import org.jmangos.realm.model.base.update.UpdateFieldUtils;
import org.jmangos.realm.model.player.Player;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;
import org.jmangos.commons.network.model.UpdateFieldType;

import java.math.BigInteger;
import java.util.BitSet;

public class Weather extends AbstractWoWServerPacket {
    Logger log = Logger.getLogger(getClass());

    private Player player;

    public Weather() {};

    public Weather( Player player ) {
        this.player = player;
        opCode = 0x2F4;
    }
    
    @Override
    protected void writeImpl() {
        /*
          WEATHER_TYPE_NORMAL            = 0, // NORMAL (SUNNY)
          WEATHER_TYPE_FOG               = 1, // FOG
          WEATHER_TYPE_RAIN              = 2, // RAIN
          WEATHER_TYPE_HEAVY_RAIN        = 4, // HEAVY_RAIN
          WEATHER_TYPE_SNOW              = 8, // SNOW
          WEATHER_TYPE_SANDSTORM         = 16 // SANDSTORM
         */
         
      writeD( 4 ); // uint32 type
      writeF( 2.0 ); // destiny 0.3 - 2.0
      writeD( 0 ); // soundid
      writeC( 0x00 ) //empty byte
    }
}

def up = new Weather( player );
sender.send( player.channel, up );