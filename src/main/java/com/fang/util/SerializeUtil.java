package com.fang.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {

	/* ���л�,�Ѷ���ת��Ϊbyte���� */
	public static byte[] serialize(Object obj) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			byte[] byteArray = baos.toByteArray();
			return byteArray;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* �����л� */
	public static Object unSerialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois=new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
