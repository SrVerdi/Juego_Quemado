package Juego;

import java.util.Scanner;

public class Ahorcado {
	private static Scanner sc;
	public static void main (String[] args) {
		sc = new Scanner(System.in);
		//se inicia los jugadores y la palabra secreta
		String jug1 = "", jug2 ="", palabra = "";
		//se importa la clase validaciones 
		validaciones val = new validaciones();
		Separador();
		
		do {
		System.out.println("Ingrese nombre jugador 1");
		jug1 = sc.nextLine();
		//valpal compara si la palabra es una sola y contiene letras {1,23} y retorna un mensaje
		valPal(jug1);
		//val.esPalabra hace lo mismo que valpal pero retorna boolean
		}while(!val.esPalabra(jug1));
		do {
			System.out.println(jug1+" - Ingrese palabra secreta");
			palabra = sc.nextLine();
			valPal(palabra);
	    }while(!val.esPalabra(palabra));
		Separador();
		do {
			System.out.println("Ingrese nombre jugador 2");
			jug2 = sc.nextLine();
			valPal(jug2);
			}while(!val.esPalabra(jug2));
		juego(jug1 , jug2, palabra);
	}
	public static void juego(String j1 , String j2, String pal) {
		try (Scanner sc = new Scanner(System.in)) {
			validaciones val = new validaciones();
			int cont = 5;
			boolean termino = false;
			boolean compara = false;
			String letra;
			String vectorjug2[] = new String[pal.length()];
			llenarVec(vectorjug2);
			do {
				do {
					Separador();
					System.out.print("\nAdivine la palabra secreta de "+j1+": ");
					mostrarVec(vectorjug2);
					monito(cont);
					System.out.println("\nTe quedan "+cont+" vidas");
					System.out.print(j2+" ingrese una letra: ");
					letra = sc.nextLine();
					}while(!val.esPalabra(letra));
				Separador();
				if(compararLetra(letra, vectorjug2)) {
					System.out.println("Ya ingresaste la letra: "+letra);
					
				} else {
					compara = comparar(pal, letra ,vectorjug2);
					termino = compararGanador(pal,letra,vectorjug2);
					if(compara || termino) {
					System.out.println("WENA");
					
					} else {
						System.out.println("MALA");
						cont--;
					}
				}
				if(cont==0) {
					Separador();
					System.out.print("La palabra secreta era: "+pal);
					System.out.println("\n"+j2 + " LOOSER!! - FIN DEL JUEGO");
				}
				
				
			}while(!termino && cont>0);
			
			if(termino) {
				Separador();
				System.out.print("La palabra secreta era: "+pal);
				System.out.println("\n"+j2 + " - YOU WIN!!  - FIN DEL JUEGO");
			}
		}
	}
	public static boolean comparar(String palabra , String letra, String vec[]) {
		boolean esLetra = false;
		String letrapal="";
		letra = letra.toLowerCase();
		for(int i =0; i<palabra.length();i++) {
			letrapal = palabra.substring(i,i+1);
			if(letra.equals(letrapal.toLowerCase())) {
					vec[i]=letra;
					esLetra = true;
			}
		}
		return esLetra;
	}
	
	public static boolean compararLetra(String letra, String vec[]) {
		boolean esLetra = false;
		letra = letra.toLowerCase();
		for(int i =0; i<vec.length;i++) {
			if(vec[i].toLowerCase().equals(letra)) {
					esLetra = true;
			}
		}
		return esLetra;
	}
	
	public static boolean compararGanador(String palabra, String letra, String vec[]) { //vec[1]= A ...... palabra.subtring(1,2)=A 
		boolean esLetra = true;
		String letrapal="";
		for(int i =0; i<palabra.length();i++) {
			letrapal = palabra.substring(i,i+1);
			if(!vec[i].toLowerCase().equals(letrapal.toLowerCase())) {
					esLetra = false;
			}
		}
		if(letra.toLowerCase().equals(palabra.toLowerCase())) {
			esLetra = true;
		}
		return esLetra;
	}
	public static void mostrarVec(String vec[]) {
		for (int i= 0; i< vec.length;i++) {
			System.out.print(vec[i]+" ");
		}
	}
	public static void llenarVec(String vec[]) {
		for (int i= 0; i< vec.length;i++) {
			vec[i]="_";
		}
	}
	public static void valPal(String pal) {
		validaciones val = new validaciones();
		if(!val.esPalabra(pal)) {
			System.out.println("Error - ingrese una palabra que contenga sólo letras del abcdario por favor");
		}
	}
	public static void Separador() {
		System.out.println("******************************************************************");
	}
	public static void monito(int cont) {
		switch(cont){ 
			case 5: 
				System.out.println("\n------\n"
						+ "|   |\n"
						+ "|   o\n"
						+ "|  /|\\ \n"
						+ "|  / \\"); break;
			case 4: System.out.println("\n------\n"
					+ "|   |\n"
					+ "|   o\n"
					+ "|  /|\\ \n"
					+ "|  / "); break;
			case 3: System.out.println("\n------\n"
					+ "|   |\n"
					+ "|   o\n"
					+ "|  /|\\ \n"
					+ "|"); break;
			case 2: System.out.println("\n------\n"
					+ "|   |\n"
					+ "|   o\n"
					+ "|   | \n"
					+ "|"); break;
			case 1: System.out.println("\n------\n"
					+ "|   |\n"
					+ "|   o\n"
					+ "| \n"
					+ "|"); break;
		}
	}
}
