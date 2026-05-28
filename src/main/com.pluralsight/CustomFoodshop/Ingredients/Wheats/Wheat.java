package CustomFoodshop.Ingredients.Wheats;

import CustomFoodshop.Ingredients.Ingredient;

abstract public class Wheat extends Ingredient {
    private boolean isToasted;
    private int fiberPerServing;

    Wheat(int caloriesPerServing, int servings, double pricePerServing, boolean isSeasoned, boolean isSpicy,
          boolean isToasted, int fiberPerServing) {
        super(caloriesPerServing, servings, pricePerServing, isSeasoned, isSpicy);
        this.isToasted = isToasted;
        this.fiberPerServing = fiberPerServing;
    }

    public boolean getToasted() {return this.isToasted;}
    public void setToasted(boolean isToasted) {this.isToasted = isToasted;}
    public int getFiberPerServing() {return this.fiberPerServing;}
    public void setFiberPerServing(int fiberPerServing) {this.fiberPerServing = fiberPerServing;}

    public static Wheat createSpaghetti(int servings) {
        return new Pasta(200, servings, 1.50, false, false, false, 2,
                Pasta.PastaType.SPAGHETTI);
    }

    public static Wheat createWhiteRice(int servings) {
        return new Rice(180, servings, 1.25, false, false, false, 1,
                Rice.RiceType.WHITE);
    }

    public static Wheat createToastedWhiteBread(int servings) {
        return new Bread(120, servings, 1.00, false, false, true, 3,
                Bread.BreadType.WHITE);
    }

    private static Wheat createPizzaCrust(boolean isSeasoned, boolean isSpicy, boolean isToasted) {
        return new Bread(100, 1, 2.00, isSeasoned, isSpicy, isToasted,
                1, Bread.BreadType.WHITE);
    }

    @Override
    public String toString() {
        return "Wheat{" +
                "isToasted = " + isToasted +
                ", fiberPerServing = " + fiberPerServing + "g" +
                ", calories = " + super.getCaloriesPerServing() +
                ", servings = " + getServings() +
                ", price = $" + getPricePerServing() +
                '}';
    }
}

class Pasta extends Wheat {
    enum PastaType { SPAGHETTI, CAPELLINI, FETTUCCINE, LINGUINE }
    private PastaType pastaType;

    public Pasta(int caloriesPerServing, int servings, double pricePerServing, boolean isSeasoned, boolean isSpicy,
          boolean isToasted, int fiberPerServing, PastaType pastaType) {
        super(caloriesPerServing, servings, pricePerServing, isSeasoned, isSpicy, isToasted, fiberPerServing);
        this.pastaType = pastaType;
    }

    public PastaType getPastaType() {return this.pastaType;}
    public void setPastaType(PastaType pastaType) {this.pastaType = pastaType;}
}

class Rice extends Wheat {
    enum RiceType { BROWN, YELLOW, WHITE, DIRTY, MEXICAN }
    private RiceType riceType;

    public Rice(int caloriesPerServing, int servings, double pricePerServing, boolean isSeasoned, boolean isSpicy,
         boolean isToasted, int fiberPerServing, RiceType riceType) {
        super(caloriesPerServing, servings, pricePerServing, isSeasoned, isSpicy, isToasted, fiberPerServing);
        this.riceType = riceType;
    }

    public RiceType getRiceType() {return this.riceType;}
    public void setRiceType(RiceType riceType) {this.riceType = riceType;}
}

class Bread extends Wheat {
    enum BreadType { HERB, CHEESY, WHEAT, WHITE }
    private BreadType breadType;

    public Bread(int caloriesPerServing, int servings, double pricePerServing, boolean isSeasoned, boolean isSpicy,
          boolean isToasted, int fiberPerServing, BreadType breadType) {
        super(caloriesPerServing, servings, pricePerServing, isSeasoned, isSpicy, isToasted, fiberPerServing);
        this.breadType = breadType;
    }

    public BreadType getBreadType() {return this.breadType;}
    public void setBreadType(BreadType breadType) {this.breadType = breadType;}
}
