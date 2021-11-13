import java.util.Vector;

public class Main {
	
	public static Vector<String>registros = new Vector<>();

	public static void main(String[] args) {
		
		Via via1 = new Via(1);
		Via via2 = new Via(2);
		Via via3 = new Via(3);

		Vehiculo carro = new Vehiculo(via1,via2,'c',numero_registro());
		
		System.out.println(registros);
	}
	public static int numero_registro() {
		return registros.size();
	}

}
