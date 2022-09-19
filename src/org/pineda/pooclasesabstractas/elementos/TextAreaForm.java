package org.pineda.pooclasesabstractas.elementos;

public class TextAreaForm extends ElementoForm{

	private int filar;
	private int columnas;
	
	public TextAreaForm(String nombre) {
		super(nombre);
	}

	public TextAreaForm(String nombre, int filar, int columnas) {
		super(nombre);
		this.filar = filar;
		this.columnas = columnas;
	}

	public int getFilar() {
		return filar;
	}

	public void setFilar(int filar) {
		this.filar = filar;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	@Override
	public String dibujarHtml() {
		// TODO Auto-generated method stub
		return "<textarea name='" + this.nombre + "' cols='" + this.columnas + "' rows='" + this.filar + "'>" + this.valor + "</textarea>";
	}

}
