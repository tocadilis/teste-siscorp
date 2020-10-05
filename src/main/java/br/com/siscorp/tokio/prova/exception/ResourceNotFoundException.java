package br.com.siscorp.tokio.prova.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String errorMessage, Throwable err) {
	super(errorMessage, err);
    }

    public ResourceNotFoundException(String errorMessage) {
	super(errorMessage);
    }
}
