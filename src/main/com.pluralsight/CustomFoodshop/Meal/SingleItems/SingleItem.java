package CustomFoodshop.Meal.SingleItems;

import CustomFoodshop.Ingredients.Ingredient;
import CustomFoodshop.Meal.Meal;

import java.util.List;

public abstract class SingleItem implements Meal {
    private String name;
    private double totalPrice;
    private List<Ingredient> ingredients;

    public SingleItem(String name, double totalPrice, List<Ingredient> ingredients) {
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
    public double calculateTotalPrice(double totalPrice) {
        for (Ingredient ingredient : ingredients) {
            totalPrice += ingredient.getServings() * ingredient.getPricePerServing();
        }
        return totalPrice;
    }

}
