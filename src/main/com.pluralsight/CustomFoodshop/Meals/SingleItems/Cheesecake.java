package CustomFoodshop.Meals.SingleItems;

import CustomFoodshop.Ingredients.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class Cheesecake extends SingleItem {
    public enum CakeSize { SM, MED, LRG };
    private CakeSize size;

    public Cheesecake(String name, double totalPrice, List<Ingredient> ingredients, CakeSize size) {
        super(name, totalPrice, ingredients);
        this.size = size;
    }

    public CakeSize getSize() {return this.size;}
    public void setSize(CakeSize size) {this.size = size;}

    public static Cheesecake createCheesecake() {
        return new Cheesecake("Cheesecake", 4.50, new ArrayList<>(), Cheesecake.CakeSize.MED);
    }
}
