package gestion;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<Libro> libros;
	
	public Biblioteca() {
		this.libros = new ArrayList<Libro>();
	}
	public boolean agregarLibro(Libro unLibro) {
		boolean exito = false;
		if(unLibro !=null) {
			this.libros.add(unLibro);
			exito = true;
		}
		return exito;
	}
	
	public boolean eliminarLibro(String titulo) {
		boolean exito = false;
		int posicion = buscarIndice(titulo);
		//Si se encontro el endice elimina el libro
		if(posicion !=-1) {
			this.libros.remove(posicion);
			exito = true;
		}
		return exito;
	}
	
	private int buscarIndice(String titulo) {
		int posicion =-1;
		int i = 0;
		//Busca la posicion del libro en la lista
		while(i<this.libros.size() && posicion ==-1) {
			//Comparacion ignorando mayusculas
			if(this.libros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				posicion = i;
			}else {
				i++;
			}
		}
		return posicion;
	} 

	public String obtenerDetallesDeLibros() {
		String detalles = "";
		int cantidadLibros = this.libros.size();
		//Si la coleccion esta vacía no hay nada que mostrar
		if(cantidadLibros==0) {
			detalles = "No hay libros";
		}else {
			//Si hay al menos un libro se itera para obtener los detalles.
			for(Libro unLibro: this.libros) {
				detalles = detalles +unLibro.toString()+"\n";
			}
		}
		return detalles;
	}

	public Libro buscarLibro(String titulo) {
		Libro unLibro;
		int posicion = buscarIndice(titulo);
		//Buscamos la posicion del libro en la lista
		if(posicion==-1) {
			// Si no lo encuentra devuelve null
			unLibro=null;
		}else {
			unLibro = this.libros.get(posicion);
		}
		return unLibro;
	}
}
