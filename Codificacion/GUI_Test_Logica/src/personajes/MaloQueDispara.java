package personajes;

public class MaloQueDispara extends Malo{

	public MaloQueDispara(Mediator m) {
		super(m);
		strat=new PaseadorArmado(this,m);
	}
	

}
