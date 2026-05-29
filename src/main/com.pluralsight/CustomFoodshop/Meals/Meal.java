package CustomFoodshop.Meals;

import CustomFoodshop.Ingredients.Ingredient;
import java.util.List;
import java.util.Scanner;

public interface Meal {
    double calculateTotalPrice();
    double calculateTotalCalories();
    List<Ingredient> getIngredientList();
    public String getName();
}