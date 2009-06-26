package characters;

import gameLogic.CombatHandler;
import items.ItemGenerator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CharacterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(ItemGenerator.generateCasualConsumable().toString());
		System.out.println(ItemGenerator.generateCasualConsumable().toString());
		System.out.println(ItemGenerator.generateCasualConsumable().toString());
		
		Random r = new Random();
		System.out.println("Creazione personaggi");
		Set<Character> chars = new HashSet<Character>();
		for (int i = 0; i < 300; ++i) {
			chars.add(new Human("a"));
			chars.add(new Wizard("b"));
			chars.add(new Orc("c"));
			chars.add(new Elf("d"));
		}
		
		int elf = 0;
		int human = 0;
		int orc = 0;
		int wizard = 0;
		
		System.out.println("Giù mazzate!");
		
		while (!chars.isEmpty()) {
			Character a = null;
			Character b = null;
			if (chars.size() > 2) {
				while (a == b) {
					a = (Character)chars.toArray()[r.nextInt(chars.size())];
					b = (Character)chars.toArray()[r.nextInt(chars.size())];
				}
			} else {
				a = (Character)chars.toArray()[0];
				b = (Character)chars.toArray()[1];
				
				Character winner = killahFaighht(a, b);
				
				if (winner instanceof Human) {
					human++;
				} else if (winner instanceof Elf) {
					elf++;
				} else if (winner instanceof Orc) {
					orc++;
				} else {
					wizard++;
				}
				
				break;
			}
			
			Character winner = killahFaighht(a, b);
			
			if (winner instanceof Human) {
				human++;
			} else if (winner instanceof Elf) {
				elf++;
			} else if (winner instanceof Orc) {
				orc++;
			} else {
				wizard++;
			}
			
			chars.remove(a);
			chars.remove(b);
		}
		
		System.out.println();
		System.out.println("I risultati del rissone:");
		System.out.println();
		System.out.printf("Gli umani han vinto %d volte\n", human);
		System.out.printf("Gli orchi han vinto %d volte\n", orc);
		System.out.printf("Gli elfi han vinto %d volte\n", elf);
		System.out.printf("I maghi han vinto %d volte\n", wizard);
	}
	
	public static Character killahFaighht(Character a, Character b) {
		while (true) {
			CombatHandler.getInstance().meleeAttack(a, b);
			
			CombatHandler.getInstance().meleeAttack(b, a);
		}
	}

}
