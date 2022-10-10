import java.awt.Image;
import javax.swing.ImageIcon;


public class LuxCar implements DrawableItem{
    private Passenger passenger;
    //private LuxCompany company;
    //private Location location;
    //private LuxCar notifyPassengerArrival;
    //private LuxCar car;
    //private boolean free;
    private Image emptyImage, passengerImage;
    

    public LuxCar(LuxCompany company, Location location){
       // super(company, location);
      // this.company = company;
       //this.location = location;
        emptyImage = new ImageIcon(getClass().getResource("images/luxCar.jpg")).getImage();

        passengerImage = new ImageIcon(getClass().getResource("images/luxCar+person.jpg")).getImage();
    
    }
    
 
    public void act()
    {
        Location target = getTargetLocation();
        if(target != null) {
            Location next = getLocation().nextLocation(target);
            setLocation(next);
            if(next.equals(target)) {
                if(passenger != null) {
                    notifyPassengerArrival(passenger); //notificar a chegada do passageiro
                    offloadPassenger();
                }
                else {
                    notifyPickupArrival();
                }
            }
        }
        else {
            incrementIdleCount();
        }
    }

    public void notifyPassengerArrival(Passenger passenger2) {
	}

    public void incrementIdleCount() {

	}

    private  void notifyPickupArrival(){

    }
	private  void setLocation(Location next) {
    }

    private Location getTargetLocation() {
        return null;
    }


    public boolean isFree()
    {
        return getTargetLocation() == null && passenger == null;
    }
    
  
    public void setPickupLocation(Location location)
    {
        setTargetLocation(location);
    }
    

    public void pickup(Passenger passenger)
    {
        this.passenger = passenger;
        setTargetLocation(passenger.getDestination());
    }

    public void offloadPassenger()
    {
        passenger = null;
        clearTargetLocation();
    }
    public void setTargetLocation(Location destination){

    }
    public void clearTargetLocation(){

    }
    public Image getImage()
    {
        if(passenger != null) {
            return passengerImage;
        }
        else {
            return emptyImage;
        }
    }
    public String toString()
    {
        return "luxCar at " + getLocation ();
    }
    public Location getLocation(){
        return null;
    }
  
    public void interator(){

    }
    public void addItem(){

    }
    public void removeItem(){

    }
    public void notifyPassengerArrival(){

    }
    
}
