public class Order {
    private Restaurant restaurant;
    private Consumer consumer;

    public Order(Restaurant restaurant, Consumer consumer) {
        this.restaurant = restaurant;
        this.consumer = consumer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Consumer getConsumer() {
        return consumer;
    }
}
