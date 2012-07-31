package org.JMANGOS.wowdata.dbc.dataholder;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import javolution.io.Struct;

public class DBCBaseStruct extends Struct {

	public static int HEADER_SIZE = 20;
	protected int stringBufPos;
	private int lang = -1;
	
	protected static final Class<?> INTERNALSTRING = new InternalString[0]
				.getClass();
	public class InternalString extends Member {
		private byte[] tsring = new byte[2024];
		private CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();

		public InternalString() {
			super(32, 4);
		}

		public String get() {
			int i = 0;
			final int index = getByteBufferPosition() + offset();
			for (; (tsring[i] = getByteBuffer().get(
					(int) (i + stringBufPos + getByteBuffer().getInt(index)))) != 0; i++) {
			}
			try {
				return decoder.decode(ByteBuffer.wrap(tsring, 0, i)).toString();
			} catch (CharacterCodingException e) {
				e.printStackTrace();
			}
			return "";
		}

		public String toString() {
			return get();
		}

	}
	
	public ByteOrder byteOrder() {
		return ByteOrder.LITTLE_ENDIAN;
	}

	public class MultiInternalString extends Member {
		private byte[] tsring = new byte[2024];
		private CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();

		public MultiInternalString() {
			super(32 * 17, 4);
		}

		public String get() {
			int i = 0;
			if (lang < 0) {
				for (int j = 0; j < 16; j++) {
					if (getByteBuffer().getInt(
							getByteBufferPosition() + offset() + 4 * j) > 0) {
						lang = j;
						break;
					}
				}

			}
			if (lang < 0)
				return "";
			for (; (tsring[i] = getByteBuffer().get(
					(int) (i + stringBufPos + getByteBuffer().getInt(
							getByteBufferPosition() + offset() + 4 * lang)))) != 0; i++) {
			}
			try {
				return decoder.decode(ByteBuffer.wrap(tsring, 0, i)).toString();
			} catch (CharacterCodingException e) {
				e.printStackTrace();
			}
			return "";
		}

		public String toString() {
			return get();
		}

	}
	
	public DBCBaseStruct() {
		super();
	}

}