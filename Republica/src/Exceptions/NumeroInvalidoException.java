package Exceptions;
public class NumeroInvalidoException extends Exception{

	public NumeroInvalidoException(float rendimentos) {
		super(rendimentos + " � um valor invalido!");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
