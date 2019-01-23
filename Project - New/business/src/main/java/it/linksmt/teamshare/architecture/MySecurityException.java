package it.linksmt.teamshare.architecture;


public class MySecurityException extends ApplicationException {

	public MySecurityException() {
		super();
		
	}

	public MySecurityException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public MySecurityException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MySecurityException(String arg0) {
		super(arg0);
	}

	public MySecurityException(Throwable arg0) {
		super(arg0);
	}

}
