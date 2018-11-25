package Colliders;

import Disparo.DisparoEnemigo;
import Disparo.DisparoJugador;
import Objetos.Barricada;
import Objetos.Obstaculo;
import Objetos.Premio;
import personajes.*;

public class ColliderMalo implements Collider {

	protected Malo malo;
	public ColliderMalo(Malo m) {
		malo=m;
	}

	public void collideWith(Jugador j) {
		j.disminuirHP(10);
		malo.disminuirHP(100);
	}

	public void collideWith(DisparoJugador d) {
		malo.disminuirHP(d.getDa�o());
		d.morir();
	}

	public void collideWith(Malo m) { /*NADA*/ }

	public void collideWith(DisparoEnemigo de) { /*NADA*/ }

	public void collideWith(Obstaculo o) { /*NADA*/ }

	public void collideWith(Premio p) { /*NADA*/ }

	public void collideWith(Barricada b) { /*NADA*/ }
}