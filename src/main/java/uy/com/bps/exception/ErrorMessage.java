package uy.com.bps.exception;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorMessage {
	
	private Integer statusCode;
	private Date timeStamp;
	private String menssage;
	private String description;

}
