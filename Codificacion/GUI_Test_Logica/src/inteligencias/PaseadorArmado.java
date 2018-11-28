package inteligencias;

import java.util.Random;
import Disparo.ArmaEnemigo;
import Disparo.Disparo;
import mapa.Celda;
import personajes.Malo;

public class PaseadorArmado extends Strategy {

	protected ArmaEnemigo miArma;
	
	public PaseadorArmado(Malo e) {
		super(e);
		miArma = new ArmaEnemigo(e,10);
	}

	public void mover() {
		Random r = new Random();		
		int dir = r.nextInt(3);		
		int direccion = -1;
		switch (dir) {
			case 0 : //Arriba
				direccion = Celda.UP;
				break;
			case 1 : //Abajo
				direccion = Celda.DOWN;
				break;
			case 2 : //Izquierda
				direccion = Celda.LEFT;
				break;
		}
		en.mover(direccion);
		if (r.nextInt(100) < 45)
			disparar();
	}
	
	private void disparar(){
		Disparo d=miArma.createDisparo();
		mediator.agregarDisparo(d);
	}
}