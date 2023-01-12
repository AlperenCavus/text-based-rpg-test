package textBasedRPG;

public class Rogue extends GameClasses implements Classes {
	private double maxHP;
	private int dex;
	private int damage;
	
	Rogue(String name){
		this.name=name;
		this.maxHP=15.0;
		this.dex=10;
		this.damage=5;
	}
	
	@Override
	public double attack() {
		System.out.println("You tried to attack..."); 
		int attackChance=(int)(Math.random()*100); 
		if(attackChance>=10) { 
			System.out.println("You successfully attacked your target!"); 
			System.out.println("Your given damage:"+this.damage);
		}
		else 
			System.out.println("You couldn't hit your target!");
		
		return this.getDamage();
	}
	
}
