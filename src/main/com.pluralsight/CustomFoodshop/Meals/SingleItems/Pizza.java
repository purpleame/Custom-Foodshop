package CustomFoodshop.Meals.SingleItems;

import CustomFoodshop.Ingredients.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends SingleItem {
    public enum PizzaSize { SM, MED, LRG };
    private PizzaSize size;
    private boolean hasStuffedCrust;

    public Pizza(String name, double totalPrice, List<Ingredient> ingredients,
                 PizzaSize size, boolean hasStuffedCrust) {
        super(name, totalPrice, ingredients);
        this.size = size;
        this.hasStuffedCrust = hasStuffedCrust;
    }

    public PizzaSize getSize() {return this.size;}
    public void setSize(PizzaSize size) {this.size = size;}
    public boolean getHasStuffedCrust() {return this.hasStuffedCrust;}
    public void setHasStuffedCrust(boolean hasStuffedCrust) {this.hasStuffedCrust = hasStuffedCrust;}

    public static Pizza createPizza() {
        // double price;
        // if (size == Pizza.PizzaSize.SM) {
        //     price = 6.99;
        // } else if (size == Pizza.PizzaSize.MED) {
        //     price = 9.99;
        // } else {
        //     price = 13.99;
        // }
        return new Pizza("Pizza", 9.99, new ArrayList<>(), Pizza.PizzaSize.MED, false);
    }
}
