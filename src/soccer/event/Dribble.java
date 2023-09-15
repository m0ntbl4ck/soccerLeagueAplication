
package soccer.event;

/**
 *
 * @author mont_
 */
public class Dribble extends GameEvent{

    public Dribble(){
        super();
    }
    
    
    @Override
    public String toString(){
        return "Regate ";
    }
    
    
    @Override
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] ={ new GainPossession(), new Shoot(), new Pass()/*,new Foul()*/};
        return theEvent;
    }

    
    @Override
    public boolean changePlayer() {
       return false;
    }

    @Override
    public boolean changeTeam() {
        return false;
    }
    
}
