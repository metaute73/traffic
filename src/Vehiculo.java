
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
		
		Main.registros.add(this);

	}
	public String toString() {
		String r = String.valueOf(this.tipo) + String.valueOf(this.via_Origen.numero) + 
				String.valueOf(this.via_Destino.numero);
		return r;
	}
	
	public int getRegistro() {
		return this.registro;
	}
	
}
