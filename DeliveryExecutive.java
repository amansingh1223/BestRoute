import java.util.List;

public class DeliveryExecutive {
    private Location currentLocation;
    
    public DeliveryExecutive(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    public double calculateDeliveryTime(List<Order> orders) {
        double totalDistance = 0.0;
        double totalTime = 0.0;
        Location previousLocation = currentLocation;
        
        for (Order order : orders) {
            Location restaurantLocation = order.getRestaurant().getLocation();
            double distance = calculateDistance(previousLocation, restaurantLocation);
            totalDistance += distance;
            double timeToRestaurant = distance / 20.0; 
            double preparationTime = order.getRestaurant().getPreparationTime() / 60.0; 
            totalTime += timeToRestaurant + preparationTime;
            previousLocation = restaurantLocation;
        }
        
        return totalTime;
    }
    
    private double calculateDistance(Location loc1, Location loc2) {
      return Math.sqrt(Math.pow(loc2.getLatitude() - loc1.getLatitude(), 2) +
                         Math.pow(loc2.getLongitude() - loc1.getLongitude(), 2));
    }
}
