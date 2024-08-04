package gestion;

public class Libro {
	//Atributos
	private String titulo;
	private String autor;
	private int anio;
	private String genero;

	//Constructor
	public Libro(String titulo, String autor,int anio, String genero) {
		this.titulo = titulo;
		this.autor = autor;
		this.anio = anio;
		this.genero = genero;
	}
	
	//Getters y Setters
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public int getAnio() {
		return anio;
	}
	public String getGenero() {
		return genero;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	//Propios del tipo
	public String toString() {
		return "Libro: {Titulo: "+this.titulo+", Autor: "+this.autor+", Año publicado: "+this.anio+
				", Género: "+this.genero+"}";
		
	}
}
