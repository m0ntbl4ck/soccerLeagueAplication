
package soccer.play;

import soccer.event.GameEvent;
import soccer.event.Goal;

/**
 *
 * @author mont_
 */
public class GameResult {
     
   private final Team homeTeam;
   private final Team awayTeam;
   private Team winner;
   private int homeTeamGoals;
   private int awayTeamGoals;
   private boolean isDrawn;

    public GameResult(Game currGame) {
        this.homeTeam = currGame.getHomeTeam();
        this.awayTeam = currGame.getAwayTeam();
        getScore(currGame);
        if(homeTeamGoals == awayTeamGoals){
            this.isDrawn = true;
        }else if (homeTeamGoals > awayTeamGoals){
            this.winner = this.homeTeam;
        } else{
            this.winner = this.awayTeam;
        }
                
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }
    private void getScore(Game currGame){
        for(GameEvent currEvent: currGame.getEvents()){
            if(currEvent instanceof Goal){
            if(currEvent.getTheTeam() == currGame.getHomeTeam()){
                this.homeTeamGoals++;
            } else{
                this.awayTeamGoals++;
            }
            
            }
        }
    }
            
            
            
    public Team getWinner() {
        return winner;
    }

   

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

   

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    

    public boolean isIsDrawn() {
        return isDrawn;
    }

   
   
   
   
}
