
package soccer.play;

/**
 *
 * @author mont_
 */
public class DisplayString implements IDisplayDataItem{

    public DisplayString(String displayString) {
        this.displayDetail= displayString;
    }
   
    String displayDetail;
    int id =0;
    
    
    @Override
    public boolean isDetailAvailable() {
       return false;
    }

    @Override
    public String getDisplayDetail() {
       return this.displayDetail;
    }

    @Override
    public int getID() {
       return this.id;
    }

    @Override
    public String getDetailType() {
       return "String";
    }

    public void setDisplayDetail(String displayDetail) {
        this.displayDetail = displayDetail;                                                                      
    }
    
}
