package mapa;

import java.util.ArrayList;
import java.util.Random;
import gui.GUI;
import personajes.Entidad;
import personajes.Malo;

public class Mapa {
	private Celda mapa[][];
	private int width, height;
	private GUI gui;
	//a�adir un atributo FileOpener para poder abrir el archivo y leerlo, hay que ver bien como hacer funcionar esto

	public Mapa(GUI gui, int width, int height){ //habr�a que modificar esto para que seg�n nuestra implementaci�n el mapa reciba el int del nivel que tiene q crear
		this.gui = gui;
		this.width = width;
		this.height = height;
		this.mapa = new Celda[width][height];
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				this.mapa[i][j] = new Celda(this, i, j);
			}
		}
	}
	
	public Celda getCelda(int x, int y){
		return this.mapa[x][y];
	}
	
	public Celda[][] getMapa() {
		return mapa;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public void remove(Entidad e) {
		gui.remove(e.getGrafico());
	}
	
	public void place(ArrayList<Malo> l) {
		Random r = new Random();
		for (Entidad m : l) {
			int x = r.nextInt(getWidth());
			int y = r.nextInt(getHeight());
			Celda c = getCelda(x, y);
			m.setPos(c);
			c.addEntidad(m);
			gui.add(m.getGrafico());
		}
	}
}