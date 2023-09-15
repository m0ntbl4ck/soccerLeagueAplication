
package soccer.event;

/**
 *
 * @author mont_
 */
public class Pass extends GameEvent{    

    public Pass() {
        super();
    }

    @Override
    public String toString() {
        return "Pase ejecutado ";
    }
    
    
    @Override
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] ={new ReceivePass(), new GainPossession()/*,new Foul()*/};
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
