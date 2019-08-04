package com.virtusa.payroll.exception;

public class PayrollException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PayrollException() {

	}

	public PayrollException(String arg0) {
		super(arg0);

	}

	public PayrollException(Throwable arg0) {
		super(arg0);

	}

	public PayrollException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public PayrollException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);

	}

}
