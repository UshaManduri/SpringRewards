package com.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BootException extends RuntimeException{

	private String message;
	private String errorCode;
	private String errorDescription;
	private String errorDetail;
	
	public BootException(String errorCode, String errorDescription, String errorDetail) {
		this.message = errorDetail;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.errorDetail = errorDetail;
	}

	public BootException(String message, String errorCode, String errorDescription, String errorDetail) {
		super();
		this.message = message;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.errorDetail = errorDetail;
	}

	public BootException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BootException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BootException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BootException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BootException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
