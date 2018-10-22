package mapa;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import personajes.Entidad;

public class Celda {
	public static final int LEFT = KeyEvent.VK_LEFT;
	public static final int RIGHT = KeyEvent.VK_RIGHT;
	public static final int UP = KeyEvent.VK_UP;
	public static final int DOWN = KeyEvent.VK_DOWN;
	private ArrayList<Entidad> entidades;
	private Mapa mapa;
	private int x;
	private int y;
	
	public Celda(Mapa mapa, int x, int y){
		entidades=new ArrayList<Entidad>();
		this.mapa = mapa;
		this.x = x;
		this.y = y;
	}
	
	public void addEntidad(Entidad e) {
		entidades.add(e);
		if(entidades.size()>1)
			for(Entidad a:entidades) {
				a.colision(e);
			}
	}
	public void removeEntidad(Entidad e) {
		entidades.remove(e);
	}
	
	public void eliminarEntidad(Entidad e) {
		entidades.remove(e);
		mapa.remove(e);
	}
	
	public Celda getVecina(int dir){
		switch (dir){
			case UP :
				if (--y >= 0)
					return this.mapa.getCelda(x, y);
				else {
					y = mapa.getHeight()-1;
					return this.mapa.getCelda(x, y);
				}
			case DOWN :
				if (++y < mapa.getHeight())
					return this.mapa.getCelda(x, y);
				else {
					y = 0;
					return this.mapa.getCelda(x, y);
				}
			case LEFT :
				if (--x >= 0)
					return this.mapa.getCelda(x, y);
				else {
					x = mapa.getWidth()-1;
					return this.mapa.getCelda(x, y);
				}
			case RIGHT :
				if (++x < mapa.getWidth())
					return this.mapa.getCelda(x, y);
				else {
					x = mapa.getWidth()-1;
					return this.mapa.getCelda(x, y);
				}
		}
		return null;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean isEndX() {
		return mapa.getCelda(mapa.getWidth()-1, y) == this;
	}
	
	public boolean isStartX() {
		return mapa.getCelda(0, y) == this;
	}
}