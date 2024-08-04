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
		if(posicion !=-1) {
			this.libros.remove(posicion);
			exito = true;
		}
		return exito;
	}
	
	private int buscarIndice(String titulo) {
		int posicion =-1;
		int i = 0;
		//Buscar la posicion del libro en la lista
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
		if(this.libros.size()==0) {
			detalles = "No hay libros";
		}else {
			for(Libro unLibro: this.libros) {
				detalles = detalles +unLibro.toString()+"\n";
			}
		}
		return detalles;
	}

	public Libro buscarLibro(String titulo) {
		Libro unLibro;
		int posicion = buscarIndice(titulo);
		if(posicion==-1) {
			unLibro=null;
		}else {
			unLibro = this.libros.get(posicion);
		}
		return unLibro;
	}
}
