package textBasedRPG;

public class Orc extends Creatures implements Classes {
	private String name;
	private double maxHP;
	private int dex;
	private int damage;
	public Orc(String name) {
	this.name=name;
	this.maxHP=11.0;
	this.dex=6;
	this.damage=5;
	}
	@Override
	public double attack() {
		
		int attackChance=(int)(Math.random()*100); 
		if(attackChance>=65) 
			System.out.println(this.name+"'s given damage:"+this.damage); 
		else {
			return 0;
		}
		return damage;
	}


}
