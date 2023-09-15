
package soccer.play;

import soccer.event.GameEvent;

/**
 *
 * @author mont_
 */
public class Team implements Comparable, IDisplayDataItem {
    
    private String teamName;
    private Player[] playerArray;
    private int pointsTotal;
    private int goalsTotal;
    private boolean detailAvailable = false;
    private int id = 0;
    private String detailType = "Team";

    @Override
    public int compareTo(Object theTeam) {
       int returnValue = -1;
       if(this.getPointsTotal() < ((Team)theTeam).getPointsTotal()){
           returnValue = 1;
       }else if(this.getPointsTotal() == ((Team)theTeam).getPointsTotal()){
           if(this.getGoalsTotal() < ((Team)theTeam).getGoalsTotal()){
              returnValue = 1;
           }
    } 
       return returnValue;
    }
   
    public void incGoalsTotal(int goals){
        this.setGoalsTotal(this.getGoalsTotal() + goals);
    }
    
    public void incPointsTotal(int points){
        this.pointsTotal += points;
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, Player[] playerArray) {
        this(teamName);
        this.playerArray = playerArray;
    }

    public Team() {
    }
    
    
    public String getTeamName() {
        return teamName;
    }
    
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Player[] getPlayerArray() {
        return playerArray;
    }

    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
    }

    public int getPointsTotal() {
        return pointsTotal;
    }

    public void setPointsTotal(int pointsTotal) {
        this.pointsTotal = pointsTotal;
    }

    public int getGoalsTotal() {
        return goalsTotal;
    }

    public void setGoalsTotal(int goalsTotal) {
        this.goalsTotal = goalsTotal;
    }

    @Override
    public String toString() {
        return teamName;
    }
    
    
    @Override
    public boolean isDetailAvailable() {
        return detailAvailable;
    }

    @Override
    public String getDisplayDetail() {
       return teamName;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getDetailType() {
       return detailType;
    }

    public void setDetailAvailable(boolean detailAvailable) {
        this.detailAvailable = detailAvailable;
    }

    public void setDetailType(String detailType) {
        this.detailType = detailType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public GameEvent getNextPlayAttempt(GameEvent currEvent){
        
        GameEvent[] possEvents = currEvent.getNextEvents();
        currEvent = possEvents[(int)(Math.random()*(possEvents.length))];
        return currEvent;
    }
    
}
