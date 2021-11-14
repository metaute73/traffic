package errors;

public class ViaErronea extends Error{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = "Giro no permitido";
	public ViaErronea() {
		super();
	}
	
	public String getMessage(){
		return super.getMessage() + "\n" + this.message;
	}
}
