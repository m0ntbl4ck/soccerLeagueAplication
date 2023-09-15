
package soccer.event;

/**
 *
 * @author mont_
 */
public class Foul extends GameEvent {
    
     public Foul(){
        super();
    }
    
    
     @Override
    public String toString(){
        return "Falta ";
    }
    
    
    @Override
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] ={ new Kickoff()};
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
