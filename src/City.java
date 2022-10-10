import java.util.Iterator;
import java.util.LinkedList;
//import java.util.List;
    
public class City
{   
    private int width;
    private int height;
	private LinkedList<Object> items;

    public City(int width, int height)
    {   this.width = width;
        this.height = height;
        items = new LinkedList<Object>(); // oi sabrina :)

        if(width < 1) {
            throw new IllegalArgumentException(
                        "Width must be positive: " +
                        width);
        }
        if(height < 1) {
            throw new IllegalArgumentException(
                        "Height must be positive: " +
                        height);
        }
    }
    
    //Troquei DEFAULT_WIDTH e DEFAULT_HEIGHT, para zero
    public City()
    {
        this(0, 0);
    } 
    


    public Iterator<Object> getItems()
    {
        return items.iterator();
    }

  
    public void addItem(Object item)
    {
        if(items.contains(item)) {
            throw new IllegalArgumentException(
                item + " already recorded in the city.");
        }
        items.add(item);
    }


    public void removeItem(Object item)
    {
        if(!items.remove(item)) {
            throw new IllegalArgumentException(
                        item + " is not in the city.");
        }
    }

    public String toString()
    {
        return "City size " + width + " by " + height;
    }
    

    public int getWidth()
    {
        return width;
    }
    

    public int getHeight()
    {
        return height;
    }
}
