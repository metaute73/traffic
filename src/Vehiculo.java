import java.util.Iterator;

public class Vehiculo {

	Via via_Origen;
	Via via_Destino;
	String tipo;
	int registro;

	Vehiculo() {

	}

	Vehiculo(Via Origen, String tipo, int registro) {

		this.via_Origen = Origen;
		this.tipo = tipo;
		this.registro = registro;

	}

	Vehiculo(Via Origen, Via Destino, String tipo, int registro) {
		this(Origen, tipo, registro);
		this.via_Destino = Destino;

		Main.registros.add(this);

	}

	public String toString() {
		String r = String.valueOf(this.tipo) + String.valueOf(this.via_Origen.numero)
				+ String.valueOf(this.via_Destino.numero) + " registro numero: " + this.registro;
		return r;
	}

	public int getRegistro() {
		return this.registro;
	}

	public static String getVehiculosPorTipo() {
		int contadorC = 0;
		int contadorA = 0;
		int contadorM = 0;
		for (Vehiculo elemento : Main.registros) {
			if (elemento.tipo.equals("C")) {
				contadorC++;
			}
			if (elemento.tipo.equals("M")) {
				contadorM++;
			}
			if (elemento.tipo.equals("A")) {
				contadorA++;
			}

		}
		String vehiculosPorTipo = "Numero de camiones: " + contadorC + "\nNumero de automoviles: " + contadorA
				+ "\nNumero de motocicletas: " + contadorM;
		return vehiculosPorTipo;
	}

	public static int getTotalGiros() {
		int contadorGiros = 0;
		for (Vehiculo elemento : Main.registros) {
			if (elemento.via_Origen.numero == 1) {
				if (elemento.via_Destino.numero == 2) {
					contadorGiros++;
				} else if (elemento.via_Destino.numero == 3) {
					contadorGiros++;
				}
			} else if (elemento.via_Origen.numero == 3) {
				if (elemento.via_Destino.numero == 1) {
					contadorGiros++;
				}
			}
		}
		return contadorGiros;
	}

	public static int girosPorTipo(String tipoV) {
		int contador = 0;
		for (Vehiculo elemento : Main.registros) {
			if (elemento.tipo.equals(tipoV)) {
				if (elemento.via_Origen.numero == 1) {
					if (elemento.via_Destino.numero == 2) {
						contador++;
					} else if (elemento.via_Destino.numero == 3) {
						contador++;
					}
				} else if (elemento.via_Origen.numero == 3) {
					if (elemento.via_Destino.numero == 1) {
						contador++;
					}
				}
			}
		}
		return contador;
	}

	public static String  getTotalGirosPorVehiculo() {
		int girosA = girosPorTipo("A");
		int girosC = girosPorTipo("C");
		int girosM = girosPorTipo("M");
		String totalGirosPorTipo = "Giros por camion: "+girosC+
				"\nGiros por automovil: "+girosA+
				"\nGiros por motocicleta: "+girosM;
		return totalGirosPorTipo;
	}



	public static int getTotalRegistros() {
		return Main.registros.size();
	}

}
