package CustomFoodshop.OrderSystem;

import CustomFoodshop.Orders.PendingOrder;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OrderManager {
    private HashMap<String, PendingOrder> orders = new HashMap<>();

    public void addOrder(String orderId, PendingOrder order) {
        if (orders.containsKey(orderId)) {
            throw new IllegalArgumentException("An order with ID " + orderId + " already exists!");
        }
        orders.put(orderId , order);
    }

    public void removeOrder(String orderId) {
        orders.remove(orderId);
    }

    public List<PendingOrder> getOrdersByStatus(Predicate<PendingOrder> condition) {
        return orders.values().stream().filter(condition)
                .collect(Collectors.toList());
    }
}
