
public class MissingPassengerException extends RuntimeException
{
    protected Vehicle vehicle;

    public MissingPassengerException(Vehicle vehicle)
    {
        super("Missing passenger at pickup location.");
    }

}
