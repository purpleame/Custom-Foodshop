package CustomFoodshop.Meals.SingleItems;

import CustomFoodshop.Ingredients.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class Drink extends SingleItem {
    public enum DrinkSize { SM, MED, LRG };
    private DrinkSize size;
    private boolean hasIce;

    public Drink(String name, double totalPrice, List<Ingredient> ingredients, DrinkSize size, boolean hasIce) {
        super(name, totalPrice, ingredients);
        this.size = size;
        this.hasIce = hasIce;
    }

    public DrinkSize getSize() {return this.size;}
    public void setSize(DrinkSize size) {this.size = size;}
    public boolean getHasIce() {return this.hasIce;}
    public void setHasIce(boolean hasIce) {this.hasIce = hasIce;}

    public static Drink createFountainSoda() {
        return new Drink("Soda", 9.99, new ArrayList<>(), Drink.DrinkSize.MED, true);
    }
}
