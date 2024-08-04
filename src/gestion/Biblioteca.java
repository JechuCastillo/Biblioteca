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
		while(i<this.libros.size() && posicion ==-1) {
			if(this.libros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				posicion = i;
			}else {
				i++;
			}
		}
		return posicion;
	} 
}
