import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class LuxCompany 
{
   
    private List<Vehicle> vehicles;
    private City city;
    private Map<Vehicle, Passenger> assignments;
    private LuxCompany company;
    private List<LuxCar> cars;

    public static final int TOTAL_LUXCARS = 0;


    public LuxCompany(City city)
    {
        this.city = city;
        vehicles = new LinkedList<Vehicle>();
        assignments = new HashMap<Vehicle, Passenger>();
        setupVehicles();
    }


    public boolean requestPickup(Passenger passenger)
    {
        Vehicle vehicle = scheduleVehicle();
        if(vehicle != null) {
            assignments.put(vehicle, passenger);
            vehicle.setPickupLocation(passenger.getPickupLocation());
            return true;
        }
        else {
            return false;
        }
    }
    

    public void arrivedAtPickup(Vehicle vehicle){
        
        Passenger passenger = assignments.remove(vehicle);
        if(passenger == null) {
            throw new MissingPassengerException(vehicle);
        }
        city.removeItem(passenger);
        vehicle.pickup(passenger);
    }
    

    public void arrivedAtDestination(Vehicle vehicle,Passenger passenger){

    }
    

    public List<Vehicle> getVehicles(LuxCompany company, Location location)
    {
        return vehicles;
    }
    

    private Vehicle scheduleVehicle()
    {
        Iterator<Vehicle> it = vehicles.iterator();
        while(it.hasNext()) {
            Vehicle vehicle = it.next();
            if(vehicle.isFree()) {
                return vehicle;
            }
        }
        return null;
    }


    private void setupVehicles()
    {
        int cityWidth = city.getWidth();
        int cityHeight = city.getHeight();

        Random rand = new Random(12345);

        // Create the taxis.
        for(int i = 0; i < vehicles.size(); i++){
            LuxCar luxcar = new LuxCar(this.company,new Location(rand.nextInt(cityWidth),rand.nextInt(cityHeight)));
            //n??o sei se ?? exatamente isso>>>> criado uma lista de carros cars
            cars.add(luxcar);
            city.addItem(luxcar);
        }
    
   }
}