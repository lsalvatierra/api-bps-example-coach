package uy.com.bps.utilitarios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilFecha {
	
	public String obtenerFechaHoraActual() {
		Date fechaActual = new Date();
		DateFormat formatoHora = new SimpleDateFormat("HHmmss");
        DateFormat formatoFecha = new SimpleDateFormat("ddMMyyyy");
        return formatoFecha.format(fechaActual)+formatoHora.format(fechaActual);
	}

}
