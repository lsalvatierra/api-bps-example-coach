package uy.com.bps.utilitarios;

public class UtilDocumentos {
	
	public String obtenerNombreDocumento(String contentType) {
		String extension = "";
		if(contentType.equals("image/jpeg")) {
			extension = ".jpeg";
		}
		return new UtilFecha().obtenerFechaHoraActual()+extension;
	}
}
