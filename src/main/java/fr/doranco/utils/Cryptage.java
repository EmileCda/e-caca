package fr.doranco.utils;

import java.sql.Blob;

public class Cryptage {

	public static String decrypt(Blob blob) throws Exception {

		if (blob != null) {
			Utils.trace("%d\n",blob.length());
			return new String(blob.getBytes(1, (int) blob.length()));

		}
		return "no-blob";
	}

	public static byte[] encrypt(String nonCrypte) throws Exception {

		if ((nonCrypte != null) && (nonCrypte.length() > 0)) {
			return nonCrypte.getBytes("UTF8");

		}
		return null;
	}

}
