package CustomFoodshop.Meals.SingleItems;

import CustomFoodshop.Ingredients.Ingredient;
import CustomFoodshop.Meals.Meal;

import java.util.List;
import java.util.ArrayList;

public abstract class SingleItem implements Meal {
    private String name;
    private double totalPrice;
    private double totalCalories;
    private List<Ingredient> ingredients;

    SingleItem(String name, double totalPrice, List<Ingredient> ingredients) {
        this.name = name;
        this.totalPrice = totalPrice;
        this.ingredients = ingredients;
    }

    public String getName() {return this.name;}

    public void setName(String name) {this.name = name;}

    public double getTotalPrice() {return this.totalPrice;}

    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}

    public List<Ingredient> getIngredients() {return this.ingredients;}

    public void setIngredients(List<Ingredient> ingredients) {this.ingredients = ingredients;}

    @Override
    public double calculateTotalPrice() {
        return this.totalPrice + ingredients.stream()
                .mapToDouble(ing -> ing.getServings() * ing.getPricePerServing())
                .sum();
    }

    @Override
    public double calculateTotalCalories() {
        return this.totalCalories + ingredients.stream()
                .mapToDouble(ing -> ing.getServings() * ing.getCaloriesPerServing())
                .sum();
    }

    @Override
    public List<Ingredient> getIngredientList() {
        return ingredients.stream().toList();
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredientQuery) {
        ingredients.removeIf(ingredient -> ingredient == ingredientQuery);
    }

}

