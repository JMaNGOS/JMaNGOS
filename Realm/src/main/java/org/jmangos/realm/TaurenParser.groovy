package org.jmangos.realm

import org.jmangos.realm.model.base.update.UpdateFieldUtils
import org.jmangos.realm.model.base.update.ObjectFields
import org.jmangos.realm.model.base.update.PlayerFields
import org.jmangos.realm.model.enums.InventorySlots
import org.jmangos.realm.model.enums.UpdateType
import java.nio.ByteBuffer
import java.nio.ByteOrder

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

        def bSize = (byte)0x00;
        bSize = bais.read() // Size of bitmap

        def size = bSize//ByteBuffer.wrap( bSize ).order( ByteOrder.LITTLE_ENDIAN ).getShort()

        def updateType = bais.read() // Update Type (VALUES)
        println( UpdateType.get( updateType ) )

        // WoW GUID (uint64)
        def wowguid = new byte[8];
        bais.read( wowguid )
        //println( "GUID: " + ByteBuffer.wrap( wowguid ).order( ByteOrder.LITTLE_ENDIAN ).getShort() )
        def guid = new BigInteger( wowguid ).toString( 16 )
        println( "wowguid: $guid" )

        def baos = new ByteArrayOutputStream()

        byte[] mask = new byte[size*4];
        bais.read( mask )
        BitSet bits = new BitSet();

        for (int i=0; i<mask.length*8; i++) {
            if ((mask[(int)mask.length-i/8-1]&(1<<(i%8))) > 0) {
                bits.set(i);
            }
        }

        def i=0;
        for (i = 0;i<bits.size();i++) {
            if ( !bits[i] )
                continue;

            def readByte = new byte[4];
            bais.read( readByte );

            def field = UpdateFieldUtils.getField( i );

            if (
                    (i > PlayerFields.PLAYER_FIELD_INV_SLOT_HEAD.value ) &&
                    (i < PlayerFields.PLAYER_FIELD_PACK_SLOT_1.value )
            ) {
                //println InventorySlots.get( i - ( PlayerFields.PLAYER_FIELD_INV_SLOT_HEAD.getValue() )  )
                println "INVENTORYSLOT"
                continue;
            }

            if ( i > PlayerFields.PLAYER_FIELD_PACK_SLOT_1.value && i < ( PlayerFields.PLAYER_FIELD_PACK_SLOT_1.value + 32 ) ) {
                println "BagSlot"
                continue;
            }

            if ( i > PlayerFields.PLAYER_FIELD_BANK_SLOT_1.value && i < (PlayerFields.PLAYER_FIELD_BANK_SLOT_1.value + 56 ) ) {
                println "BankSlot"
                continue;
            }

            if ( i > PlayerFields.PLAYER_FIELD_BANKBAG_SLOT_1.value && i<(PlayerFields.PLAYER_FIELD_BANKBAG_SLOT_1.value + 14) ){
                println "BankBagSlot"
                continue
            }

            if ( i > PlayerFields.PLAYER_FIELD_VENDORBUYBACK_SLOT_1.value && i < ( PlayerFields.PLAYER_FIELD_VENDORBUYBACK_SLOT_1.value + 24 ) ) {
                println "BuyBackSlot"
                continue
            }


            if ( field != null )
                println field
            else
                println String.format( "0x%04X", i - ObjectFields.OBJECT_END )
        }

        // Ami most benne van, az a maradek az adat.

    }
}