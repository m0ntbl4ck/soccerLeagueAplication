
package soccer.event;

/**
 *
 * @author mont_
 */
public class HalfTime extends GameEvent{
    @Override
    public String toString() {
        return "Descanso. Mitad de Tiempo ";
    }
    
    
    @Override
    public GameEvent[] getNextEvents() {
       GameEvent theEvent[] = {new Kickoff()};
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
