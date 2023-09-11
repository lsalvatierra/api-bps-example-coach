package uy.com.bps.utilitarios;

import java.util.Base64;

public class UtilConvertBase {

	public byte[] decodeBase64(String archivoBase64) {
		return Base64.getDecoder().decode(archivoBase64);
	}

	
	public String encodeBase64(byte[] archivoByte) {
		return Base64.getEncoder().encodeToString(archivoByte);
	}
}
