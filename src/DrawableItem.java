import java.awt.Image;
    
public interface DrawableItem extends Item {
    public void act();
    public void notifyPassengerArrival();
    public void incrementIdleCount (); 
    public void clearTargetLocation(); 
    public Image getImage();
}
