package grafica;

import javax.swing.ImageIcon;

public class DisparoGrafico extends EntidadGrafica{

	public DisparoGrafico(int velocidad, int x, int y) {
		super(velocidad, x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/BattleCity/Zombie.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/BattleCity/Zombie.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/BattleCity/Zombie.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/BattleCity/Zombie.png"));
	}
}