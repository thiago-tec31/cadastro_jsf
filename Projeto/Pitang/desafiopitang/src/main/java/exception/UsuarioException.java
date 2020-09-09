package exception;

public class UsuarioException extends Exception {

	private static final long serialVersionUID = 7715116019362831678L;

	public UsuarioException(String msg) {
		super(msg);
	}

	public UsuarioException(Exception e) {
		super(e);
	}

	public UsuarioException(String msg, Exception e) {
		super(msg, e);
	}

}
