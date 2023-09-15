
package soccer.event;

/**
 *
 * @author mont_
 */
public class Saves extends GameEvent{
    public Saves(){
        super();
    }
    
    
    @Override
    public String toString(){
        return "Atajada del Arquero ";
    }
    
    
    @Override
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] ={ new ReceivePass(), new GainPossession()};
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
