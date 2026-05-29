package CustomFoodshop.Orders;

import CustomFoodshop.Meals.Meal;

import java.time.LocalDateTime;
import java.util.List;

public class PendingOrder extends Order {
    public enum OrderStatus { IN_PROGRESS, FINISHED, CANCELLED };
    private OrderStatus orderStatus;

    public PendingOrder(String orderId, OrderType orderType, List<Meal> orderedItems,
                        LocalDateTime timestamp, OrderStatus orderStatus) {
        super(orderId, orderType, orderedItems, timestamp);
        this.orderStatus = OrderStatus.IN_PROGRESS;
    }

    public OrderStatus getOrderStatus() {return this.orderStatus;}

    public void setOrderStatus(OrderStatus orderStatus) {this.orderStatus = orderStatus;}

    public boolean isInProgress() {return this.orderStatus == OrderStatus.IN_PROGRESS;}

    public boolean isCancelled() {return this.orderStatus == OrderStatus.CANCELLED;}

    public boolean isFinished() {return this.orderStatus == OrderStatus.FINISHED;}

    void cancelOrder() {
        System.out.println("Order " + getOrderId() + " has been cancelled.");
        orderStatus = OrderStatus.CANCELLED;
    }
}
