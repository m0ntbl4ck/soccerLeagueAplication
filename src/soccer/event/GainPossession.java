
package soccer.event;

/**
 *
 * @author mont_
 */
public class GainPossession extends GameEvent{

    public GainPossession() {
        super();
    }

    @Override
    public String toString() {
        return "Ganó la posesión ";
    }

    
    @Override
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] ={new GainPossession(), new Pass(), new Dribble(), new Shoot()/*,new Foul()*/};
        return theEvent;
    }

    @Override
    public boolean changePlayer() {
       return true;
    }

    @Override
    public boolean changeTeam() {
        return true;
    }
    
}
