package CustomFoodshop.Meals.ComboMeals;

import CustomFoodshop.Meals.Meal;

import java.util.List;

import CustomFoodshop.Ingredients.Ingredient;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class ComboMeal implements Meal {
    private String name;
    private List<Meal> items;
    private double totalPrice;
    private double totalCalories;

    public ComboMeal(String name, List<Meal> items, double totalPrice) {
        this.name = name;
        this.items = new ArrayList<>(items);
        this.totalPrice = totalPrice;
    }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public List<Meal> getItems() { return this.items; }
    public void setItems(List<Meal> items) { this.items = items; }
    public double getTotalPrice() { return this.totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    @Override
    public double calculateTotalPrice() {
        double componentSum = items.stream().mapToDouble(Meal::calculateTotalPrice).sum();
        return this.totalPrice + componentSum;
    }

    @Override
    public double calculateTotalCalories() {
        double componentSum = items.stream().mapToDouble(Meal::calculateTotalCalories).sum();
        return this.totalCalories + componentSum;
    }

    @Override
    public List<Ingredient> getIngredientList() {
        return items.stream()
                .flatMap(meal -> meal.getIngredientList().stream())
                .collect(Collectors.toList());
    }

    public static ComboMeal createComboMeal(Scanner scanner) {
        String name;
        double bundleDiscountPrice;
        List<Meal> components = new ArrayList<>();

        System.out.print("Enter custom combo meal name (e.g., Value Feast Bundle): ");
        name = scanner.nextLine();

        System.out.print("Enter base premium bundle deal package price ($): ");
        try {
            bundleDiscountPrice = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            bundleDiscountPrice = 8.99;
        }

        return new ComboMeal(name, components, bundleDiscountPrice) {};
    }
}

