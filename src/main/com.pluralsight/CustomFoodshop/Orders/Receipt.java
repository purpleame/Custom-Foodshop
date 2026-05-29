package CustomFoodshop.Orders;

import CustomFoodshop.Meals.Meal;

import java.time.LocalDateTime;
import java.util.List;

public class Receipt extends Order {
    private double taxRate;
    private double subtotal;
    private double grandTotal;

    public Receipt(String orderId, OrderType orderType, List<Meal> orderedItems,
                   LocalDateTime timestamp, double taxRate) {
        super(orderId, orderType, orderedItems, timestamp);
        this.taxRate = taxRate;
    }

    public double getTaxRate() { return this.taxRate; }
    public void setTaxRate(double taxRate) { this.taxRate = taxRate; }

    public double calculateSubtotal() {
        double currentSubtotal = 0.0;

        for (Meal meal : getOrderedItems()) {
            currentSubtotal += meal.calculateTotalPrice();
        }

        this.subtotal = currentSubtotal;
        return this.subtotal;
    }

    public double calculateGrandTotal() {
        calculateSubtotal();
        this.grandTotal = (this.taxRate + 1.00) * this.subtotal;
        return this.grandTotal;
    }
}
