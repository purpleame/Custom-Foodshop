package CustomFoodshop.Orders;

import CustomFoodshop.Meals.Meal;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Order {
    private String orderId;
    public enum OrderType { SINGLE_ITEM, COMBO };
    private OrderType orderType;
    private List<Meal> orderedItems;
    private LocalDateTime timestamp;
    double subtotal;

    Order(String orderId, OrderType orderType, List<Meal> orderedItems, LocalDateTime timestamp) {
        this.orderId = orderId;
        this.orderedItems = orderedItems;
        this.timestamp = timestamp;
        this.orderType = orderType;
    }

    public String getOrderId() {return this.orderId;}

    public void setOrderId(String orderId) {this.orderId = orderId;}

    public List<Meal> getOrderedItems() {return this.orderedItems;}

    public void setOrderedItems(List<Meal> orderedItems) {this.orderedItems = orderedItems;}

    public LocalDateTime getTimestamp() {return this.timestamp;}

    public void setTimestamp(LocalDateTime timestamp) {this.timestamp = timestamp;}

    void addMeal(Meal meal) {
        orderedItems.add(meal);
    }

    void removeMeal(Meal meal) {
        orderedItems.remove(meal);
    }

    public double calculateSubtotal() {
        double currentSubtotal = 0.0;

        for (Meal meal : getOrderedItems()) {
            currentSubtotal += meal.calculateTotalPrice();
        }

        this.subtotal = currentSubtotal;
        return this.subtotal;
    }
}
