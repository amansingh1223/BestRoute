// Restaurant.java
public class Restaurant {
    private Location location;
    private int preparationTime;
    
    public Restaurant(Location location, int preparationTime) {
        this.location = location;
        this.preparationTime = preparationTime;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public int getPreparationTime() {
        return preparationTime;
    }
}
