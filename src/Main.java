import java.util.Vector;

import errors.VehiculoNoPermitido;
import errors.ViaErronea;
import errors.Errorindice;
import java.util.Scanner;

public class Main {

	public static Vector<Vehiculo> registros = new Vector<>();

	static Via via1 = new Via(1);
	static Via via2 = new Via(2);
	static Via via3 = new Via(3);

	public static void main(String[] args) {

		new Vehiculo(via1, via2, "C", numero_registro());
		new Vehiculo(via3, via1, "M", numero_registro());
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("Bienvenido \n ¿Qué desea realizar hoy?");
			System.out.println("1. Motrar registros\n2. Agregar vehiculo \n3. Buscar vehiculo \n4. Borrar vehiculo"
					+ "\n5 Salir ");

			int x = input.nextInt();
			switch (x) {
			case 1:
				
				while (true) {
					System.out.println("1. Mostrar todos los registros\n2. Total de registros  \n3. Total de vehiculos por tipo "
							+ "\n4. Total de giros \n5. Total giros por tipo \n6. Volver al menú prinipal ");
					int opcion = input.nextInt();
					switch (opcion) {
					case 1:
						continue;
					case 2:
						System.out.println("Total de Registros: " + Vehiculo.getTotalRegistros());
						continue;
					case 3:
						System.out.println(Vehiculo.getVehiculosPorTipo());
						continue;
					case 4:
						System.out.println("Total de giros: " + Vehiculo.getTotalGiros());
						continue;
					case 5:
						System.out.println(Vehiculo.getTotalGirosPorVehiculo());
						continue;

					case 6:
						break;
					}
					break;
				}
				continue;

			case 2:

				System.out.print("tipo: ");
				String tipo = input.next();
				System.out.print("via origen: ");
				int via_origen = input.nextInt();
				System.out.print("via destino: ");
				int via_destino = input.nextInt();

				try {
					checkVehiculoVia(via_origen, via_destino);
				} catch (ViaErronea e) {
					System.out.println(e.getMessage());
					continue;
				}
				try {
					checkVehiculoTipo(tipo);
				} catch (VehiculoNoPermitido h) {
					System.out.println(h.getMessage());
					continue;
				}
				Vehiculo vehiculo = new Vehiculo(numero_via(via_origen), numero_via(via_destino), tipo,
						numero_registro());
				continue;
			case 3:
				System.out.println("escribe numero de registro:");
				int identificador = input.nextInt();
				try {
					checkindice(identificador);

				} catch (Errorindice k) {
					System.out.println(k.getMessage());
					continue;
				}
				System.out.println(registros.get(identificador).toString());
				continue;
			case 4:
				System.out.println("escribe numero de registro:");
				int borrado = input.nextInt();
				try {
					checkindice(borrado);

				} catch (Errorindice p) {
					System.out.println(p.getMessage());
					continue;
				}
				int registroborrado = registros.get(borrado).registro;
				registros.remove(borrado);
				for (int i = registroborrado; i < registros.size(); i++) {
					registros.get(i).registro--;

				}

				continue;
			case 5:
				break;
			}
			break;

		}
		input.close();
		for (Vehiculo v : registros) {
			System.out.println(v.toString());
		}
		
	}

	public static int numero_registro() {
		return registros.size();
	}

	public static Via numero_via(int via) {
		if (via == 1)
			return via1;
		else if (via == 2)
			return via2;
		else
			return via3;
	}

	static void checkVehiculoVia(int via_origen, int via_destino) throws ViaErronea {
		if (via_origen == 2) {
			if (via_destino != 2)
				throw new ViaErronea();
		} else if (via_origen == 3) {
			if (via_destino == 2)
				throw new ViaErronea();
		}

	}

	static void checkVehiculoTipo(String tipo) throws VehiculoNoPermitido {
		if (!tipo.equals("C") && !tipo.equals("M") && !tipo.equals("A"))

			throw new VehiculoNoPermitido();
	}

	static void checkindice(int borrar) throws Errorindice {
		if (borrar >= registros.size()) {
			throw new Errorindice();
		}
	}
}
