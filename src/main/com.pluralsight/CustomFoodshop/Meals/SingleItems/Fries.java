package CustomFoodshop.Meals.SingleItems;

import CustomFoodshop.Ingredients.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class Fries extends SingleItem {
    enum FriesSize { SM, MED, LRG };
    private FriesSize size;

    Fries(String name, double totalPrice, List<Ingredient> ingredients, FriesSize size) {
        super(name, totalPrice, ingredients);
        this.size = size;
    }

    public FriesSize getSize() {return this.size;}
    public void setSize(FriesSize size) {this.size = size;}

    public static Fries createFrenchFries() {
        return new Fries("French Fries", 2.25, new ArrayList<>(), Fries.FriesSize.MED);
    }
}
