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

    public static Burger createClassicBurger(List<Ingredient> baseIngredients) {
        return new Burger("Classic Cheeseburger", 5.99, baseIngredients, Burger.BunType.BRIOCHE, false);
    }

    public static Pasta createChickenAlfredo(Pasta.PastaMealSize size, List<Ingredient> ingredients) {
        return new Pasta("Chicken Alfredo", 11.50, ingredients,
                Pasta.PastaMealType.CHICKEN_ALFREDO, size, false);
    }

    public static Cheesecake createNewYorkCheesecake() {
        return new Cheesecake("NY Style Cheesecake Slice", 4.50, new ArrayList<>(), Cheesecake.CakeSize.MED);
    }

    public static Pizza createPepperoniPizza(Pizza.PizzaSize size, List<Ingredient> toppings) {
        double price;
        if (size == Pizza.PizzaSize.SM) {
            price = 6.99;
        } else if (size == Pizza.PizzaSize.MED) {
            price = 9.99;
        } else {
            price = 13.99;
        }
        return new Pizza("Pepperoni Pizza", price, toppings, size, false);
    }

    public static Drink createFountainSoda(String flavor, Drink.DrinkSize size) {
        double price;
        if (size == Drink.DrinkSize.SM) {
            price = 1.99;
        } else if (size == Drink.DrinkSize.MED) {
            price = 2.49;
        } else {
            price = 2.99;
        }
        return new Drink(flavor, price, new ArrayList<>(), size, true);
    }

    public static Fries createFrenchFries(Fries.FriesSize size) {
        return new Fries("French Fries", 2.25, new ArrayList<>(), size);
    }

}

class Burger extends SingleItem {
    enum BunType { BRIOCHE, SESAME };
    private BunType bunType;
    private boolean isDoublePatty;

    Burger(String name, double totalPrice, List<Ingredient> ingredients,
                     BunType bunType, boolean isDoublePatty) {
        super(name, totalPrice, ingredients);
        this.bunType = bunType;
        this.isDoublePatty = isDoublePatty;
    }

    public BunType getBunType() {return this.bunType;}
    public void setBunType(BunType bunType) {this.bunType = bunType;}
    public boolean getDoublePatty() {return this.isDoublePatty;}
    public void setIsDoublePatty(boolean isDoublePatty) {this.isDoublePatty = isDoublePatty;}
}

class Pizza extends SingleItem {
    enum PizzaSize { SM, MED, LRG };
    private PizzaSize size;
    private boolean hasStuffedCrust;

    Pizza(String name, double totalPrice, List<Ingredient> ingredients,
                 PizzaSize size, boolean hasStuffedCrust) {
        super(name, totalPrice, ingredients);
        this.size = size;
        this.hasStuffedCrust = hasStuffedCrust;
    }

    public PizzaSize getSize() {return this.size;}
    public void setSize(PizzaSize size) {this.size = size;}
    public boolean getHasStuffedCrust() {return this.hasStuffedCrust;}
    public void setHasStuffedCrust(boolean hasStuffedCrust) {this.hasStuffedCrust = hasStuffedCrust;}
}

class Pasta extends SingleItem {
    enum PastaMealType { CHICKEN_ALFREDO, BACON_CHEESE, REGULAR };
    private PastaMealType mealType;
    enum PastaMealSize { SM, MED, LRG };
    private PastaMealSize size;
    private boolean hasBreadBowl;

    Pasta(String name, double totalPrice, List<Ingredient> ingredients,
                 PastaMealType mealType, PastaMealSize size, boolean hasBreadBowl) {
        super(name, totalPrice, ingredients);
        this.mealType = mealType;
        this.size = size;
        this.hasBreadBowl = hasBreadBowl;
    }

    public PastaMealType getMealType() {return this.mealType;}
    public void setMealType(PastaMealType mealType) {this.mealType = mealType;}
    public PastaMealSize getSize() {return this.size;}
    public void setSize(PastaMealSize size) {this.size = size;}
    public boolean getHasBreadBowl() {return this.hasBreadBowl;}
    public void setHasBreadBowl(boolean hasBreadBowl) {this.hasBreadBowl = hasBreadBowl;}
}

class Drink extends SingleItem {
    enum DrinkSize { SM, MED, LRG };
    private DrinkSize size;
    private boolean hasIce;

    Drink(String name, double totalPrice, List<Ingredient> ingredients, DrinkSize size, boolean hasIce) {
        super(name, totalPrice, ingredients);
        this.size = size;
        this.hasIce = hasIce;
    }

    public DrinkSize getSize() {return this.size;}
    public void setSize(DrinkSize size) {this.size = size;}
    public boolean getHasIce() {return this.hasIce;}
    public void setHasIce(boolean hasIce) {this.hasIce = hasIce;}
}

class Fries extends SingleItem {
    enum FriesSize { SM, MED, LRG };
    private FriesSize size;

    Fries(String name, double totalPrice, List<Ingredient> ingredients, FriesSize size) {
        super(name, totalPrice, ingredients);
        this.size = size;
    }

    public FriesSize getSize() {return this.size;}
    public void setSize(FriesSize size) {this.size = size;}
}

class Cheesecake extends SingleItem {
    enum CakeSize { SM, MED, LRG };
    private CakeSize size;

    Cheesecake(String name, double totalPrice, List<Ingredient> ingredients, CakeSize size) {
        super(name, totalPrice, ingredients);
        this.size = size;
    }

    public CakeSize getSize() {return this.size;}
    public void setSize(CakeSize size) {this.size = size;}
}

