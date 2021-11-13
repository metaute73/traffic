
public class Vehiculo {
	
	Via via_Origen;
	Via via_Destino;
	String tipo;
	int registro;

	Vehiculo(){
		
	}
	Vehiculo(Via Origen, String tipo, int registro){
		
		this.via_Origen = Origen;
		this.tipo = tipo;
		this.registro = registro;

		
	}
	Vehiculo(Via Origen, Via Destino, String tipo, int registro){
		this(Origen, tipo, registro);
		this.via_Destino = Destino;
		String r = String.valueOf(tipo) + String.valueOf(Origen.numero) + 
				String.valueOf(Destino.numero);
		Main.registros.add(r);

	}
	
	public int getRegistro() {
		return this.registro;
	}
	
}
