package textBasedRPG;
import java.util.Random;
import textBasedRPG.GameClasses;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Gameplay  {

	Creatures creature;
	GameClasses player;
	public Gameplay(GameClasses player){
		this.player=player;
	}

	Scanner scan= new Scanner(System.in);
	Random random;
	public void start(GameClasses player) throws InterruptedException {
		while(true) {
			random=new Random();
			int generate=random.nextInt(5)+1;
			int i=0;
			while(i<generate) {
				System.out.println("Which direction do you want to go? \n1-North \n2-South \n3-East \n4-West");
				int choice=scan.nextInt();
				i++;

			}
			Random r=new Random();
			int generate2=random.nextInt(3)+1;
			switch(generate2) {
			case 1:
				this.creature=new Orc("Orc");
				break;
			case 2:
				this.creature=new Demon("Demon");
				break;
			case 3:
				this.creature=new Zombie("Zombie");
				break;
			}

			this.fight(this.creature,this.player);
		}
	}

	public void fight(GameClasses creature,GameClasses player) throws InterruptedException {
		System.out.println("You have encountered a creature!");
		if(creature.dex>player.dex) {

			System.out.println(creature.name+" will start first!");

		}
		else if(player.dex>creature.dex) {
			System.out.println(player.name+" will start first");

		}
		else {
			System.out.println(player.name+" will start first");
		}

		TimeUnit.SECONDS.sleep(3);
		while(this.creature.maxHP>=0 && this.player.maxHP>=0) {
			if(this.creature.dex>this.player.dex) {
				while(this.creature.maxHP>=0 && this.player.maxHP>=0) {
					this.player.setMaxHP(this.player.getMaxHP()-this.creature.attack());
					if(this.player.getMaxHP()<=0) {
						break;
					}
					this.creature.setMaxHP(this.creature.getMaxHP()-this.player.attack());
					status(this.player,this.creature);
				}

			}
			else if(this.player.dex>this.creature.dex) {

				while(this.creature.maxHP>=0 && this.player.maxHP>=0) {
					this.creature.setMaxHP(this.creature.getMaxHP()-this.player.attack());
					if(this.creature.getMaxHP()<=0) {
						break;
					}
					this.player.setMaxHP(this.player.getMaxHP()-this.creature.attack());
					status(this.player,this.creature);
				}
			}
			else {
				while(this.creature.maxHP>=0 && this.player.maxHP>=0) {
					this.creature.setMaxHP(this.creature.getMaxHP()-this.player.attack());
					if(this.creature.getMaxHP()<=0) {
						break;
					}
					this.player.setMaxHP(this.player.getMaxHP()-this.creature.attack());
					status(this.player,this.creature);
				}

			}
		}
	}
	public void status(GameClasses creature,GameClasses player){
		System.out.println("Your health:"+player.getMaxHP());
		System.out.println(creature.name+"'s health:"+player.getMaxHP());
	}


}

