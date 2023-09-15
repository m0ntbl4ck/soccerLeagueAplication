
package soccer.play;

/**
 *
 * @author mont_
 */
public class Player implements Comparable {
    
    private String playerName;
    
    private int goalsScored;
    private int numberShirt;
    private String position;
    public Player(){}
    
    public Player(String playerName) {
        this.playerName = playerName;
    }
    
    /**
     * Este metodo incrementa la variable goalsScored
     *  
     */
    public void incGoalsScored(){
        this.goalsScored++; 
    }

    public String getPlayerName() {
        return playerName;
    }
    
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }
    /**
     * 
     * @param 
     * @return 
     */
    @Override
    public int compareTo(Object thePlayer) {
       if(this.getGoalsScored() < ((Player)thePlayer).getGoalsScored()){
           return 1;
       }else return -1;
    }

}
