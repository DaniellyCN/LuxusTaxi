import java.util.List;
import java.util.LinkedList;
    
public class Shuttle extends Vehicle
{
    private List<Location> destinations;
    private List<Passenger> passengers;
    protected Location location;
    protected LuxCompany company;

    public Shuttle(LuxCompany company, Location location){
        super(company, location);
        destinations = new LinkedList<Location>();
        passengers = new LinkedList<Passenger>();
    }
           
           /* public Passagers() 
            }   
            passengers = new LinkedList<Passenger>();
          
          {*/
    
    public void companyLocation(Location location, LuxCompany company){
        this.company = company;
        this.location = location;
        }

    public void setPickupLocation(Location location){
        destinations.add(location);
        chooseTargetLocation();
    }
    

    public void pickup(Passenger passenger){
        passengers.add(passenger);
        destinations.add(passenger.getDestination());
        chooseTargetLocation();
    }


    private void chooseTargetLocation(){

    }


    public void offloadPassenger(){

    }
}
