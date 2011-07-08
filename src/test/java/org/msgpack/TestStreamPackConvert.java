package org.msgpack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;

import org.junit.Test;
import org.msgpack.packer.StreamPacker;
import org.msgpack.unpacker.BufferUnpacker;
import org.msgpack.unpacker.Converter;
import org.msgpack.value.Value;


public class TestStreamPackConvert extends TestSet {

    @Test @Override
    public void testBoolean() throws Exception {
	super.testBoolean();
    }

    @Override
    public void testBoolean(boolean v) throws Exception {
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	StreamPacker packer = new StreamPacker(out);
	packer.writeBoolean(v);
	byte[] bytes = out.toByteArray();
	BufferUnpacker unpacker = new BufferUnpacker();
	unpacker.wrap(bytes);
	Value value = unpacker.readValue();
	assertTrue(value.isBoolean());
	boolean ret = new Converter(value).readBoolean();
	assertEquals(v, ret);
    }

    @Test @Override
    public void testByte() throws Exception {
	super.testByte();
    }

    @Override
    public void testByte(byte v) throws Exception {
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	StreamPacker packer = new StreamPacker(out);
	packer.writeByte(v);
	byte[] bytes = out.toByteArray();
	BufferUnpacker unpacker = new BufferUnpacker();
	unpacker.wrap(bytes);
	Value value = unpacker.readValue();
	assertTrue(value.isInteger());
	byte ret = new Converter(value).readByte();
	assertEquals(v, ret);
    }

    @Test @Override
    public void testShort() throws Exception {
	super.testShort();
    }

    @Override
    public void testShort(short v) throws Exception {
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	StreamPacker packer = new StreamPacker(out);
	packer.writeShort(v);
	byte[] bytes = out.toByteArray();
	BufferUnpacker unpacker = new BufferUnpacker();
	unpacker.wrap(bytes);
	Value value = unpacker.readValue();
	assertTrue(value.isInteger());
	short ret = new Converter(value).readShort();
	assertEquals(v, ret);
    }

    @Test @Override
    public void testInteger() throws Exception {
	super.testInteger();
    }

    @Override
    public void testInteger(int v) throws Exception {
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	StreamPacker packer = new StreamPacker(out);
	packer.writeInt(v);
	byte[] bytes = out.toByteArray();
	BufferUnpacker unpacker = new BufferUnpacker();
	unpacker.wrap(bytes);
	Value value = unpacker.readValue();
	assertTrue(value.isInteger());
	int ret = new Converter(value).readInt();
	assertEquals(v, ret);
    }

    @Test @Override
    public void testLong() throws Exception {
	super.testLong();
    }

    @Override
    public void testLong(long v) throws Exception {
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	StreamPacker packer = new StreamPacker(out);
	packer.writeLong(v);
	byte[] bytes = out.toByteArray();
	BufferUnpacker unpacker = new BufferUnpacker();
	unpacker.wrap(bytes);
	Value value = unpacker.readValue();
	assertTrue(value.isInteger());
	long ret = new Converter(value).readLong();
	assertEquals(v, ret);
    }

    @Test @Override
    public void testFloat() throws Exception {
	super.testFloat();
    }

    @Override
    public void testFloat(float v) throws Exception {
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	StreamPacker packer = new StreamPacker(out);
	packer.writeFloat(v);
	byte[] bytes = out.toByteArray();
	BufferUnpacker unpacker = new BufferUnpacker();
	unpacker.wrap(bytes);
	Value value = unpacker.readValue();
	assertTrue(value.isFloat());
	float ret = new Converter(value).readFloat();
	assertEquals(v, ret, 10e-10);
    }

    @Test @Override
    public void testDouble() throws Exception {
	super.testDouble();
    }

    @Override
    public void testDouble(double v) throws Exception {
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	StreamPacker packer = new StreamPacker(out);
	packer.writeDouble(v);
	byte[] bytes = out.toByteArray();
	BufferUnpacker unpacker = new BufferUnpacker();
	unpacker.wrap(bytes);
	Value value = unpacker.readValue();
	assertTrue(value.isFloat());
	double ret = new Converter(value).readDouble();
	assertEquals(v, ret, 10e-10);
    }

    @Test @Override
    public void testNil() throws Exception {
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	StreamPacker packer = new StreamPacker(out);
	packer.writeNil();
	byte[] bytes = out.toByteArray();
	BufferUnpacker unpacker = new BufferUnpacker();
	unpacker.wrap(bytes);
	Value value = unpacker.readValue();
	assertTrue(value.isNil());
	new Converter(value).readNil();
    }

    @Test @Override
    public void testBigInteger() throws Exception {
	super.testBigInteger();
    }

    @Override
    public void testBigInteger(BigInteger v) throws Exception {
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	StreamPacker packer = new StreamPacker(out);
	packer.writeBigInteger(v);
	byte[] bytes = out.toByteArray();
	BufferUnpacker unpacker = new BufferUnpacker();
	unpacker.wrap(bytes);
	Value value = unpacker.readValue();
	assertTrue(value.isInteger());
	BigInteger ret = new Converter(value).readBigInteger();
	assertEquals(v, ret);
    }

    @Test @Override
    public void testString() throws Exception {
	super.testString();
    }

    @Override
    public void testString(String v) throws Exception {
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	StreamPacker packer = new StreamPacker(out);
	packer.writeString(v);
	byte[] bytes = out.toByteArray();
	BufferUnpacker unpacker = new BufferUnpacker();
	unpacker.wrap(bytes);
	Value value = unpacker.readValue();
	assertTrue(value.isRaw());
	String ret = new Converter(value).readString();
	assertEquals(v, ret);
    }

    @Test @Override
    public void testByteArray() throws Exception {
	super.testByteArray();
    }

    @Override
    public void testByteArray(byte[] v) throws Exception {
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	StreamPacker packer = new StreamPacker(out);
	packer.writeByteArray(v);
	byte[] bytes = out.toByteArray();
	BufferUnpacker unpacker = new BufferUnpacker();
	unpacker.wrap(bytes);
	Value value = unpacker.readValue();
	assertTrue(value.isRaw());
	byte[] ret = new Converter(value).readByteArray();
	assertArrayEquals(v, ret);
    }
}
