package CustomFoodshop.Ingredients.Condiments;

import CustomFoodshop.Ingredients.Ingredient;

abstract public class Condiment extends Ingredient {
    enum CondimentForm { LIQUID, POWDER, PASTE }
    private CondimentForm condimentForm;

    enum ServingStyle { PACKET, CUP, DRIZZLED }
    private ServingStyle servingStyle;

    private double maxFreeServings;
    private boolean isOnSide;


    Condiment(int caloriesPerServing, int servings, double pricePerServing,
                        boolean isSeasoned, boolean isSpicy, double maxFreeServings, boolean isOnSide) {
        super(caloriesPerServing, servings, pricePerServing, isSeasoned, isSpicy);
        this.maxFreeServings = maxFreeServings;
        this.isOnSide = isOnSide;
    }

    public CondimentForm getCondimentForm() {return this.condimentForm;}
    public void setCondimentForm(CondimentForm condimentForm) {this.condimentForm = condimentForm;}
    public ServingStyle getServingStyle() {return this.servingStyle;}
    public void setServingStyle(ServingStyle servingStyle) {this.servingStyle = servingStyle;}
    public double getMaxFreeServings() {return this.maxFreeServings;}
    public void setMaxFreeServings(double maxFreeServings) {this.maxFreeServings = maxFreeServings;}
    public boolean getOnSide() {return this.isOnSide;}
    public void setIsOnSide(boolean isOnSide) {this.isOnSide = isOnSide;}

    public static Condiment createKetchup(int servings, boolean sideOrNot) {
        return new Sauce(15, servings, 2, sideOrNot,
                CondimentForm.LIQUID, ServingStyle.PACKET, Sauce.SauceType.BBQ, false);
    }

    public static Condiment createGarlicPowder(int servings) {
        return new Herb(5, servings, 0, false,
                CondimentForm.POWDER, ServingStyle.DRIZZLED, Herb.HerbType.OREGANO);
    }

    public static Condiment createRanchCup(int servings) {
        return new Dressing(50, servings, 1, true,
                CondimentForm.LIQUID, ServingStyle.CUP, Dressing.DressingType.RANCH);
    }

    public static Condiment createSaltPacket(int servings) {
        return new Seasoning(0, servings, 2, false,
                CondimentForm.POWDER, ServingStyle.PACKET, Seasoning.SeasoningType.SALT);
    }


    @Override
    public String toString() {
        return "Condiment" +
                "form = " + condimentForm +
                ", style = " + servingStyle +
                ", maxFree = " + maxFreeServings +
                ", isOnSide = " + isOnSide +
                ", calories = " + super.getCaloriesPerServing() +
                ", servings = " + getServings() +
                ", price = $" + getPricePerServing() +
                '}';
    }

}

class Seasoning extends Condiment {
    public enum SeasoningType {
        SALT(0.05), PEPPER(0.10), SUGAR(0.15);

        private final double basePrice;
        SeasoningType(double basePrice) { this.basePrice = basePrice; }
        public double getBasePrice() { return this.basePrice; }
    }

    private SeasoningType seasoningType;

    public Seasoning(int caloriesPerServing, int servings, double maxFreeServings,
                     boolean isOnSide, CondimentForm condimentForm, ServingStyle servingStyle,
                     SeasoningType seasoningType) {

        super(caloriesPerServing, servings, seasoningType.getBasePrice(), false, false, maxFreeServings, isOnSide);
        this.seasoningType = seasoningType;

        setCondimentForm(condimentForm);
        setServingStyle(servingStyle);
    }

    public SeasoningType getSeasoningType() { return this.seasoningType; }
    public void setSeasoningType(SeasoningType seasoningType) { this.seasoningType = seasoningType; }
}


class Sauce extends Condiment {
    public enum SauceType {
        MARINARA(0.50), ALFREDO(0.75), PESTO(0.85), BBQ(0.50);

        private final double basePrice;
        SauceType(double basePrice) { this.basePrice = basePrice; }
        public double getBasePrice() { return this.basePrice; }
    }

    public static final double EXTRA_SAUCE_UPCHARGE = 0.25;
    private SauceType sauceType;
    private boolean isExtraSauce;

    public Sauce(int caloriesPerServing, int servings, double maxFreeServings,
                 boolean isOnSide, CondimentForm condimentForm, ServingStyle servingStyle,
                 SauceType sauceType, boolean isExtraSauce) {

        super(caloriesPerServing, servings, sauceType.getBasePrice() + (isExtraSauce ? EXTRA_SAUCE_UPCHARGE : 0.0), false, false, maxFreeServings, isOnSide);
        this.sauceType = sauceType;
        this.isExtraSauce = isExtraSauce;

        setCondimentForm(condimentForm);
        setServingStyle(servingStyle);
    }

    public SauceType getSauceType() { return this.sauceType; }
    public void setSauceType(SauceType sauceType) { this.sauceType = sauceType; }
    public boolean getExtraSauce() { return this.isExtraSauce; }
    public void setIsExtraSauce(boolean isExtraSauce) { this.isExtraSauce = isExtraSauce; }
}


class Dressing extends Condiment {
    public enum DressingType {
        RANCH(0.60), CAESAR(0.65), VINAIGRETTE(0.55);

        private final double basePrice;
        DressingType(double basePrice) { this.basePrice = basePrice; }
        public double getBasePrice() { return this.basePrice; }
    }

    private DressingType dressingType;

    public Dressing(int caloriesPerServing, int servings, double maxFreeServings,
                    boolean isOnSide, CondimentForm condimentForm, ServingStyle servingStyle,
                    DressingType dressingType) {

        super(caloriesPerServing, servings, dressingType.getBasePrice(), false, false, maxFreeServings, isOnSide);
        this.dressingType = dressingType;

        setCondimentForm(condimentForm);
        setServingStyle(servingStyle);
    }

    public DressingType getDressingType() { return this.dressingType; }
    public void setDressingType(DressingType dressingType) { this.dressingType = dressingType; }
}

class Herb extends Condiment {
    public enum HerbType {
        OREGANO(0.10), BASIL(0.15), RED_PEPPER(0.15);

        private final double basePrice;
        HerbType(double basePrice) { this.basePrice = basePrice; }
        public double getBasePrice() { return this.basePrice; }
    }

    private HerbType herbType;

    public Herb(int caloriesPerServing, int servings, double maxFreeServings,
                boolean isOnSide, CondimentForm condimentForm, ServingStyle servingStyle,
                HerbType herbType) {

        super(caloriesPerServing, servings, herbType.getBasePrice(), false, false, maxFreeServings, isOnSide);
        this.herbType = herbType;

        setCondimentForm(condimentForm);
        setServingStyle(servingStyle);
    }

    public HerbType getHerbType() { return this.herbType; }
    public void setHerbType(HerbType herbType) { this.herbType = herbType; }
}

