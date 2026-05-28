package CustomFoodshop.Meals.ComboMeals;

import CustomFoodshop.Meals.Meal;

import java.util.List;

public abstract class ComboMeal implements Meal {
    private String name;
    private List<Meal> items;
    private double totalPrice;
    private double totalCalories;

    private ComboMeal(String name, List<Meal> items, double totalPrice) {
        this.name = name;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public String getName() {return this.name;}

    public void setName(String name) {this.name = name;}

    public List<Meal> getItems() {return this.items;}

    public void setItems(List<Meal> items) {this.items = items;}

    public double getTotalPrice() {return this.totalPrice;}

    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}

    @Override
    public double calculateTotalPrice() {
        for (Meal singleItem : items) {
            totalPrice += singleItem.calculateTotalPrice();
        }
        return totalPrice;
    }

    @Override
    public double calculateTotalCalories() {
        for (Meal singleItem : items) {
            totalCalories += singleItem.calculateTotalCalories();
        }
        return totalCalories;
    }
}
