package gestion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String []args) {
		Biblioteca biblioteca = new Biblioteca();
	}
	public static int obtenerInt() {
		int i = 0;
		Scanner sc = new Scanner(System.in);
		while (i == 0) {
			try {
				int nro = sc.nextInt();
				i = nro;
			} catch (InputMismatchException e) {
				System.out.println("Por favor ingrese un numero");
				sc.next();
				System.out.println("Ingrese valor: ");
			}
		}
		return i;
	}
	public static String obtenerString() {
		String texto = "";
		boolean conseguido= false;
		Scanner sc = new Scanner(System.in);
		while(!conseguido) {
			texto = sc.nextLine();
			if(!texto.isBlank()) {
				conseguido =true;
			}else {
				System.out.println("Por favor escriba algo en el texto");
			}
		}
		return texto;
	}
	public static void agregarLibro(Biblioteca biblioteca) {
		System.out.println("Ingrese el titulo del libro");
		String titulo = obtenerString();
		System.out.println("Ingrese el nombre del autor de "+titulo);
		String autor = obtenerString();
		System.out.println("Ingrese el año en que se publi el libro");
		int anio= obtenerInt();
		System.out.println("Ingrese el genero del libro");
		String genero = obtenerString();
		Libro unLibro = new Libro(titulo,autor,anio,genero);
		biblioteca.agregarLibro(unLibro);
	}
	public static void eliminarLibro(Biblioteca biblioteca) {
		
	}
	
}
