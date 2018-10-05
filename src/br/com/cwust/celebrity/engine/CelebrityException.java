package br.com.cwust.celebrity.engine;

public class CelebrityException extends RuntimeException {

	private static final long serialVersionUID = 6735960383607642048L;

	public CelebrityException(String message, Throwable cause) {
		super(message, cause);
	}

	public CelebrityException(String message) {
		super(message);
	}
}
