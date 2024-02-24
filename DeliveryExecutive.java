import java.util.ArrayList;
import java.util.List;

public class DeliveryExecutive {
    private Location currentLocation;

    public DeliveryExecutive(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public double findMinimumDeliveryTime(List<Order> orders) {
        List<List<Order>> combinations = generateCombinations(orders);
        double minTime = Double.MAX_VALUE;

        for (List<Order> combination : combinations) {
            double totalTime = calculateDeliveryTime(combination);
            if (totalTime < minTime) {
                minTime = totalTime;
            }
        }

        return minTime;
    }

    private double calculateDeliveryTime(List<Order> orders) {
        double totalDistance = 0.0;
        double totalTime = 0.0;
        Location previousLocation = currentLocation;

        for (Order order : orders) {
            Location restaurantLocation = order.getRestaurant().getLocation();
            double distanceToRestaurant = calculateDistance(previousLocation, restaurantLocation);
            totalDistance += distanceToRestaurant;

            double timeToRestaurant = distanceToRestaurant / 20.0;
            double preparationTime = order.getRestaurant().getPreparationTime() / 60.0; 
            Location consumerLocation = order.getConsumer().getLocation();
            double distanceToConsumer = calculateDistance(restaurantLocation, consumerLocation);
            totalDistance += distanceToConsumer;

            double timeToConsumer = distanceToConsumer / 20.0; 
            totalTime += timeToRestaurant + preparationTime + timeToConsumer;
            previousLocation = consumerLocation;
        }

        return totalTime;
    }

    private double calculateDistance(Location loc1, Location loc2) {
         return Math.sqrt(Math.pow(loc2.getLatitude() - loc1.getLatitude(), 2) +
                Math.pow(loc2.getLongitude() - loc1.getLongitude(), 2));
    }

    private List<List<Order>> generateCombinations(List<Order> orders) {
        List<List<Order>> combinations = new ArrayList<>();
        permuteHelper(combinations, new ArrayList<>(), orders);
        return combinations;
    }

    private void permuteHelper(List<List<Order>> combinations, List<Order> current, List<Order> remaining) {
        if (remaining.isEmpty()) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < remaining.size(); i++) {
            Order order = remaining.get(i);
            List<Order> newCurrent = new ArrayList<>(current);
            newCurrent.add(order);
            List<Order> newRemaining = new ArrayList<>(remaining);
            newRemaining.remove(i);
            permuteHelper(combinations, newCurrent, newRemaining);
        }
    }
}
