
public class Vehiculo {
	
	Via via_Origen;
	Via via_Destino;
	char tipo;
	int registro;
	
	Vehiculo(){
		
	}
	Vehiculo(Via Origen, char tipo, int registro){
		
		this.via_Origen = Origen;
		this.tipo = tipo;
		this.registro = registro;
		
	}
	Vehiculo(Via Origen, Via Destino, char tipo, int registro){
		this(Origen, tipo, registro);
		this.via_Destino = Destino;

	}
	
}
