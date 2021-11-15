package errors;

public class Errorindice extends Error{/**
 *
 */
private static final long serialVersionUID = 1L;
    private String message = "registro no encontrado";
    public Errorindice() {
        super();
    }

    public String getMessage(){
        return super.getMessage() + "\n" + this.message;
    }
}
