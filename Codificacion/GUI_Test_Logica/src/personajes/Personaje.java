package personajes;

import java.util.Random;
import mapa.*;

public abstract class Personaje extends Entidad {
	
	protected int fuerza_kamikaze;
	
	public Personaje(Celda c){
		super(c);
		velocidad=10;
	}
	
	public Personaje() {
		velocidad = 10;
	}
	
	public void mover(int dir){
		this.pos.removeEntidad(this);
		Celda next = this.pos.getVecina(dir);
		Random r = new Random();
		int x;
		if (next.esObstaculo()) {
			do{
				x = r.nextInt(3);
				switch (x) {
					case 0 : next = next.getVecina(Celda.DOWN);
					case 1 : next = next.getVecina(Celda.UP);
					case 2 : next = next.getVecina(Celda.LEFT);
				}
			} while(next.esObstaculo());
		}
		this.pos = next;
		pos.addEntidad(this);
		this.grafico.mover(dir);
	}
}