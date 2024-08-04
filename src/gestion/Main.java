package gestion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		boolean ejecucion = true;
		int opcion;
		while (ejecucion) {
			System.out.println("Menú de opciones");
			System.out.println("1- Agregar un libro.");
			System.out.println("2- Mostrar todos los libros.");
			System.out.println("3- Buscar un libro especifico.");
			System.out.println("4- Eliminar un libro especifico.");
			System.out.println("5- Salir");
			System.out.println("Ingrese una opción: ");
			opcion = obtenerInt();

			switch (opcion) {
			case 1:
				agregarLibro(biblioteca);
				break;
			case 2:
				mostrarLibros(biblioteca);
				break;
			case 3:
				buscarLibro(biblioteca);
				break;
			case 4:
				eliminarLibro(biblioteca);
				break;
			case 5:
				System.out.println("Programa finalizado");
				ejecucion = false;
				break;
			default:
				System.out.println("Opcion no valida, elija otra");
				break;
			}
		}
	}

	public static int obtenerInt() {
		int i = 0;
		Scanner sc = new Scanner(System.in);
		// Validacion de que pida un numero y que al menos sea mayor que 0
		while (i == 0) {
			try {
				int nro = sc.nextInt();
				if (nro > 0) {
					i = nro;
				} else {
					System.out.println("El numero debe ser mayor a 0");
				}
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
		boolean conseguido = false;
		Scanner sc = new Scanner(System.in);
		while (!conseguido) {
			// Validacion de un texto vacio
			texto = sc.nextLine();
			if (!texto.isBlank()) {
				conseguido = true;
			} else {
				System.out.println("Por favor escriba algo en el texto");
			}
		}
		return texto;
	}

	public static void agregarLibro(Biblioteca biblioteca) {
		System.out.println("Ingrese el titulo del libro");
		String titulo = obtenerString();
		System.out.println("Ingrese el nombre del autor de " + titulo);
		String autor = obtenerString();
		System.out.println("Ingrese el año en que se publi el libro");
		int anio = obtenerInt();
		System.out.println("Ingrese el genero del libro");
		String genero = obtenerString();
		Libro unLibro = new Libro(titulo, autor, anio, genero);
		biblioteca.agregarLibro(unLibro);
	}

	public static void eliminarLibro(Biblioteca biblioteca) {
		System.out.println("Ingrese el titulo del libro que desea eliminar");
		String titulo = obtenerString();
		// Eliminación del libro
		if (biblioteca.eliminarLibro(titulo)) {
			System.out.println("Libro:'" + titulo + "' eliminado con exito.");
		} else {
			System.out.println("No se ha encontrado ese libro");
		}
	}

	public static void mostrarLibros(Biblioteca biblioteca) {
		System.out.println(biblioteca.obtenerDetallesDeLibros());
	}

	public static void buscarLibro(Biblioteca biblioteca) {
		System.out.println("Ingrese el titulo del libro que desea buscar:");
		String titulo = obtenerString();
		Libro unLibro = biblioteca.buscarLibro(titulo);
		if (unLibro != null) {
			System.out.println(unLibro.toString());
		} else {
			System.out.println("Libro no encontrado");
		}
	}
}
