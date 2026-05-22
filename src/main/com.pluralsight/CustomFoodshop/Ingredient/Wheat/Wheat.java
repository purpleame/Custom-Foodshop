package CustomFoodshop.Ingredient.Wheat;

import CustomFoodshop.Ingredient.Ingredient;

public abstract class Wheat extends Ingredient {
    private boolean isToasted;
    private int fiberPerServing;

    public Wheat(int caloriesPerServing, int servings, double pricePerServing,
                 boolean isSeasoned, boolean isSpicy, boolean isToasted) {
        super(caloriesPerServing, servings, pricePerServing, isSeasoned, isSpicy);
        this.isToasted = isToasted;
    }
}
