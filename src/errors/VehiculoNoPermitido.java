package errors;

public class VehiculoNoPermitido extends Error{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = "El vehiculo ingresado no es permitido";
	public VehiculoNoPermitido() {
		super();
	}
	
	public String getMessage(){
		return super.getMessage() + "\n" + this.message;
	}

}
