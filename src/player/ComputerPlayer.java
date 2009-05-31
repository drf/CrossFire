package player;

import java.util.Random;
import java.util.Set;

import gameChart.Box;
import gameLogic.Attackable;
import gameLogic.CanAttack;
import gameLogic.CanMeleeAttack;
import gameLogic.CanPick;
import gameLogic.CombatHandler;
import gameLogic.Movable;
import gameLogic.PickException;
import gameLogic.Pickable;
import gameLogic.CombatHandler.AttackType;
import globals.Entity;
import globals.PlayableEntity;

public class ComputerPlayer extends Player {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5556432692116050384L;

	public ComputerPlayer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleTurn(PlayableEntity entity) {
		// Attack, if possible
		if (entity instanceof CanAttack) {
			// Ok, let's see what we're capable of. Our entity will prefer,
			// in order: Magic, Melee, Ranged
			
			CanAttack attacker = (CanAttack)entity;
			
			if (CombatHandler.canPerformAttack(attacker, AttackType.Magic)) {
				// Ok, let's kill someone in range
				return;
			}
			
			if (CombatHandler.canPerformAttack(attacker, AttackType.Melee)) {
				for (Box box : entity.getBox().getAdjacentBoxes()) {
					for (Entity ent : box.getChart().getEntitiesOn(box)) {
						// First, check if the entity is actually attackable
						if (ent instanceof Attackable) {
							// Now, that we're not attacking our allies!
							if (ent instanceof PlayableEntity) {
								if (((PlayableEntity)ent).getPlayer() == this) {
									continue;
								}
							}
							
							// Great, let's hit it!
							CombatHandler.meleeAttack((CanMeleeAttack)attacker, (Attackable)ent);
							// End of turn
							return;
						}
					}
				}
			}
			
			if (CombatHandler.canPerformAttack(attacker, AttackType.Ranged)) {
				
			}
		}
		
		// Clearly we couldn't attack: let's see if we can move at least
		if (entity instanceof Movable) {
			// Randomly choose a box
			Set<Box> boxes = entity.getBox().getAdjacentBoxes();
			Random r = new Random();
			Box box = (Box) boxes.toArray()[r.nextInt(boxes.size())];
			entity.move(box);
		}
		
		// Maybe on our box there are some items, in case, let's pick them
		if (entity instanceof CanPick) {
			for (Entity item : entity.getBox().getChart().getEntitiesOn(entity.getBox())) {
				if (item instanceof Pickable) {
					try {
						((CanPick)entity).pick((Pickable)item);
					} catch (PickException e) {
						
					}
				}
			}
		}
		
	}

}
