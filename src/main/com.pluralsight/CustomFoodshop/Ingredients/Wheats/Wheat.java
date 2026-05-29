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
        return new Pasta(200, servings, false, false, false, 2, Pasta.PastaType.SPAGHETTI);
    }

    public static Wheat createWhiteRice(int servings) {
        return new Rice(180, servings, false, false, false, 1, Rice.RiceType.WHITE);
    }

    public static Wheat createToastedWhiteBread(int servings) {
        return new Bread(120, servings, false, false, true, 3, Bread.BreadType.WHITE);
    }

    public static Wheat createPizzaCrust(boolean isSeasoned, boolean isSpicy, boolean isToasted) {
        return new Bread(100, 1, isSeasoned, isSpicy, isToasted, 1, Bread.BreadType.WHITE);
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
    public enum PastaType {
        SPAGHETTI(2.50), CAPELLINI(2.75), FETTUCCINE(2.50), LINGUINE(2.50);

        private final double basePrice;
        PastaType(double basePrice) { this.basePrice = basePrice; }
        public double getBasePrice() { return this.basePrice; }
    }

    private PastaType pastaType;

    public Pasta(int caloriesPerServing, int servings, boolean isSeasoned, boolean isSpicy,
                 boolean isToasted, int fiberPerServing, PastaType pastaType) {
        super(caloriesPerServing, servings, pastaType.getBasePrice(), isSeasoned, isSpicy, isToasted, fiberPerServing);
        this.pastaType = pastaType;
    }

    public PastaType getPastaType() {return this.pastaType;}
    public void setPastaType(PastaType pastaType) {this.pastaType = pastaType;}
}

class Rice extends Wheat {
    public enum RiceType {
        BROWN(1.75), YELLOW(1.50), WHITE(1.25), DIRTY(1.85), MEXICAN(1.60);

        private final double basePrice;
        RiceType(double basePrice) { this.basePrice = basePrice; }
        public double getBasePrice() { return this.basePrice; }
    }

    private RiceType riceType;

    public Rice(int caloriesPerServing, int servings, boolean isSeasoned, boolean isSpicy,
                boolean isToasted, int fiberPerServing, RiceType riceType) {
        super(caloriesPerServing, servings, riceType.getBasePrice(), isSeasoned, isSpicy, isToasted, fiberPerServing);
        this.riceType = riceType;
    }

    public RiceType getRiceType() {return this.riceType;}
    public void setRiceType(RiceType riceType) {this.riceType = riceType;}
}

class Bread extends Wheat {
    public enum BreadType {
        HERB(1.50), CHEESY(2.00), WHEAT(1.25), WHITE(1.00);

        private final double basePrice;
        BreadType(double basePrice) { this.basePrice = basePrice; }
        public double getBasePrice() { return this.basePrice; }
    }

    public static final double TOASTED_UPCHARGE = 0.20;
    private BreadType breadType;

    public Bread(int caloriesPerServing, int servings, boolean isSeasoned, boolean isSpicy,
                 boolean isToasted, int fiberPerServing, BreadType breadType) {
        super(caloriesPerServing, servings, breadType.getBasePrice() + (isToasted ? TOASTED_UPCHARGE : 0.0), isSeasoned, isSpicy, isToasted, fiberPerServing);
        this.breadType = breadType;
    }

    public BreadType getBreadType() {return this.breadType;}
    public void setBreadType(BreadType breadType) {this.breadType = breadType;}
}
