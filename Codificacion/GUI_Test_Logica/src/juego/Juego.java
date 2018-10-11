package juego;
import java.util.ArrayList;

import java.util.Random;
import gui.GUI;
import mapa.Celda;
import mapa.Mapa;
import personajes.Jugador;
import personajes.Malo;
import personajes.Disparo;
import grafica.*;

public class Juego {
	private Jugador jugador;
	private Malo malos[];
	private int cantMalos = 3; //remover
	private Mapa mapa;
	private int tamanioCelda = 50;
	private GUI gui;
	private Score score;
	private ArrayList<Disparo> disparos;
	//a�adir score, hay que crear la clase y relacionarla con la GUI haciendo un metodo para modificarlo y un campo para mostrarlo
	
	public Juego(GUI gui){
		this.mapa = new Mapa(gui.getWidth()/tamanioCelda, gui.getHeight()/tamanioCelda); //hay que modificarlo para poder hacerlo con el archivo
		Celda c = this.mapa.getCelda(0, gui.getHeight()/tamanioCelda/2);
		jugador = new Jugador(c);
		disparos= new ArrayList<Disparo>();
		score = new Score();
		this.gui = gui;
		this.gui.add(jugador.getGrafico());
		this.malos = new Malo[this.cantMalos];
		agregarDisparo();
		Random r = new Random();
		Malo m;
		for(int i = 0; i < this.cantMalos; i++){
			int x = r.nextInt(this.mapa.getWidth());
			int y = r.nextInt(this.mapa.getHeight());
			c = this.mapa.getCelda(x+1, y+1);
			m = new Malo(c);
			this.malos[i] = m;
			c.addEntidad(m);
			this.gui.add(m.getGrafico());
		}
		gui.add(score);
	}
	
	public void removeEnemies() {
		for(int i = 0; i < malos.length; i++) {
			if(malos[i]!=null) {
				/*gui.remove(malos[i].getGrafico());
				malos[i].getPos().removeEntidad(malos[i]);  
				malos[i] = null;
				score.increase(10); //max 99999*/
				malos[i].mover(malos[i].getPos().RIGHT);
			}
		}
	}
	
	public void mover(){
		for(Malo en : malos){
				en.mover();
				//System.out.println("Hola?");
		}
		
		for(int i=0;i<disparos.size();i++){
			System.out.println(disparos.size());
			Disparo d= (Disparo) this.disparos.get(i);
			d.mover(d.getPos().RIGHT);
		}
	}
	
	public void mover(int dir){
		jugador.mover(dir);
	}
	
	public void moverd(int dir){
		
	}
	
	public void agregarDisparo(){
		System.out.println("Entre");
		int x = jugador.getPos().RIGHT; //Lo voy a agregar una celda a la derecha del jugador
		int y = jugador.getPos().getY();
		Celda c = this.mapa.getCelda(x,y);
		//Celda c = this.mapa.getCelda(x+1,y);
		Disparo d= new Disparo(jugador.getPos(),20,5);
		disparos.add(d);
		jugador.getPos().addEntidad(d);
		this.gui.add(d.getGrafico());
		
	}
}