
package soccer.play;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import soccer.event.GameEvent;
import soccer.event.HalfTime;
import soccer.event.Kickoff;
import soccer.util.Settings;


/**
 *
 * @author mont_
 */
public class Game implements IDisplayDataItem  {
    
    private Team homeTeam;
    private Team awayTeam;
    private GameEvent[] events;
    private LocalDateTime theDataTime;
    
    private boolean detailAvailable = false;
    private int id = 0;
    private String detailType = "Game";

    public Game(Team homeTeam, Team awayTeam, LocalDateTime theDataTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.theDataTime = theDataTime;
    }
    
    public void playGame(){
        ArrayList<GameEvent> eventList = new ArrayList();
        Team currTeam;
        Player currPlayer;
        GameEvent currEvent = new Kickoff();
        currEvent.setBallPos(50);
        
        currEvent.setTheTeam(Math.random()>0.5?homeTeam: awayTeam);
        
        
        currEvent.setThePlayer(currEvent.getTheTeam().getPlayerArray()[(int)(Math.random()* this.homeTeam.getPlayerArray().length)]);
        currEvent.setTheTime(0);
        eventList.add(currEvent);
            Team teamKickoff = currEvent.getTheTeam();
            Player  playerKickoff = currEvent.getThePlayer(); 
            
        for (int i = 1; i <= Settings.GAME_LENGTH; i++) {
            
            if(Math.random() > Settings.GAME_EVENT_FREQUENCY){
                
                currTeam = currEvent.getTheTeam();
                currPlayer = currEvent.getThePlayer();
                
                int currBallPos = currEvent.getBallPos();
                
                currEvent = currTeam.getNextPlayAttempt(currEvent);
                
                
                currEvent.setBallPos(currBallPos);
                
                if(currEvent.changeTeam()){
                   currTeam = getOtherTeam(currTeam);
                   currEvent.reverseBallPos();
                   
                }
                
                currEvent.setTheTeam(currTeam);
                
                
                ArrayList <Player> currPlayerList = new ArrayList (Arrays.asList(currEvent.getTheTeam().getPlayerArray()));
                currPlayerList.remove(currPlayer);
                currEvent.setThePlayer(  
                    currEvent.changePlayer()?
                    currPlayerList.get((int)(Math.random()* currPlayerList.size())):
                    currPlayer 
                );
               
                currEvent.setTheTime(i);
                eventList.add(currEvent);
                
                
            }
            
            if (i == Settings.HALF_TIME){
                currTeam = teamKickoff;
                currPlayer = playerKickoff;
                
                currEvent =new HalfTime();
                currEvent.setTheTeam(currTeam);
                currEvent.setThePlayer(currPlayer);
                currEvent.setBallPos(50);
                currEvent.setTheTime(i);
                eventList.add(currEvent);
                
                currEvent = new Kickoff();
                currEvent.setBallPos(50);
                
                    if(currEvent.changeTeam()){
                   currTeam = getOtherTeam(currTeam);
                   currEvent.reverseBallPos();
                   
                }
                    currEvent.setTheTime(i);
                    currEvent.setTheTeam(currTeam);
                    currEvent.setThePlayer(currEvent.getTheTeam().
                    getPlayerArray()[(int)(Math.random()* this.homeTeam.
                            getPlayerArray().length)]);
                    currEvent.setBallPos(50);
                    eventList.add(currEvent);
                    
                    
            }
             
            if(i == Settings.GAME_LENGTH){
                
            }
            this.events = new GameEvent[eventList.size()];
            eventList.toArray(events);
        }
        
        
        
        
    }
    public String getDescription(boolean showEvents){
        // equeipo1 vs. equipo2 (09/07/2023)
        //Empate! (2 -1)
        //EquipoX Gana! (2 -1)
        
        //50 : Regate en los 15.0 mins por James Rodriguez de Equipo1
        // 100 : Gol! en los 20.0 mins por Juanito de Equipo2
        //
        StringBuilder returnString = new StringBuilder();
        returnString.append(this.getHomeTeam().getTeamName() + " vs. "+
                this.getAwayTeam().getTeamName()+ " (" +
                this.getTheDataTime().format(DateTimeFormatter.ISO_LOCAL_DATE)+")");
        returnString.append("\n");
        
        GameResult theResult = getGameResult();
        
        if(theResult.isIsDrawn()){
            returnString.append("Empate!");
        }else{
            returnString.append((theResult.getWinner().getTeamName()));
            returnString.append(" Gana!");
        }
        returnString.append(" ("+theResult.getHomeTeamGoals()+" - "+theResult.getAwayTeamGoals()+") \n");
        
        if (showEvents){
            for(GameEvent currEvent :this.getEvents()){
               if(currEvent instanceof HalfTime){
                    returnString.append(currEvent+"\n");
                }else{
                    returnString.append(currEvent.getBallPos()+ " : "+currEvent+" en los "+
                        currEvent.getTheTime()+" mins por "+
                        currEvent.getThePlayer().getPlayerName()+
                        " de "+currEvent.getTheTeam().getTeamName()+
                        "\n");
              }
                
                        
            }
        }
        return returnString.toString();
        }
    
    /**
     * 
     * @param currTeam ingreso un equipo actual de evento
     * @return el equipo contrario
     */
    
    public String getDescription(){
        return getDescription(false);
        
    }
    public String getScore(){
        String theScore;
        GameResult theResult = getGameResult();
        theScore = theResult.getHomeTeamGoals() + " - "+theResult.getAwayTeamGoals();
        return theScore;
    }
    
     public Team getOtherTeam(Team currTeam){
         if(currTeam == homeTeam){
             currTeam = awayTeam;
         } else currTeam = homeTeam;
         return currTeam;
     }
     
     
     public GameResult getGameResult(){
         return new GameResult(this);
     }
     
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public GameEvent[] getEvents() {
        return events;
    }

    public void setEvents(GameEvent[] events) {
        this.events = events;
    }
    public LocalDateTime getLocalDataTime(){
        return getTheDateTime();
    }
    
  
    public LocalDateTime getTheDateTime() {
        return theDataTime;
    }

    public void setTheDataTime(LocalDateTime theDataTime) {
        this.theDataTime = theDataTime;
    }
    
    public void setLocalDataTime (LocalDateTime theDataTime){
        this.setTheDataTime(theDataTime);
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public boolean isDetailAvailable() {
        return detailAvailable;
    }

    @Override
    public String getDisplayDetail() {
       return getScore();
    }

    public LocalDateTime getTheDataTime() {
        return theDataTime;
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
    
}
