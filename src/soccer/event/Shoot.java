/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soccer.event;

/**
 *
 * @author mont_
 */
public class Shoot extends GameEvent {
    public Shoot(){
    }

    @Override
    public String toString() {
        return "Disparo al arco ";
    }
    
    @Override
    public GameEvent[] getNextEvents() {
       GameEvent theEvent[] = {new Goal(), new Kickout()};
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
    
    @Override
    public void setBallPos(int currBallPos){
        super.ballPos = currBallPos;
    }
}
