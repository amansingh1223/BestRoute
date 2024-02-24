public class Main {
    public static void main(String[] args) {
        // Create locations for restaurants, consumers, and the current location of the delivery executive
        Location restaurant1Location = new Location(12.345, 67.890);
        Location restaurant2Location = new Location(23.456, 78.901);
        Location consumer1Location = new Location(34.567, 89.012);
        Location consumer2Location = new Location(45.678, 90.123);
        Location currentLocation = new Location(56.789, 12.345);

        // Create restaurants
        Restaurant restaurant1 = new Restaurant(restaurant1Location, 30); // 30 minutes preparation time
        Restaurant restaurant2 = new Restaurant(restaurant2Location, 25); // 25 minutes preparation time

        // Create consumers
        Consumer consumer1 = new Consumer(consumer1Location);
        Consumer consumer2 = new Consumer(consumer2Location);

        // Create orders
        Order order1 = new Order(restaurant1, consumer1);
        Order order2 = new Order(restaurant2, consumer2);

        // Create a list of orders
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        // Create a DeliveryExecutive instance
        DeliveryExecutive deliveryExecutive = new DeliveryExecutive(currentLocation);

        // Calculate the minimum delivery time for all orders
        double minDeliveryTime = deliveryExecutive.findMinimumDeliveryTime(orders);

        // Print the minimum delivery time
        System.out.println("Minimum delivery time: " + minDeliveryTime + " hours");
    }
}
