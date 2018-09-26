package gui;

import juego.Juego;

public class ContadorTiempo extends Thread {
	private Juego juego;

	ContadorTiempo(Juego j) {
		this.juego = j;
	}

	public void run() {
		while(true){
			juego.mover();
		}
	}
}