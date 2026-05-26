package CustomFoodshop;

import CustomFoodshop.Ingredients.Condiments.Condiment;

public class FoodshopMain {
    public static void main(String[] args) {
        Condiment salt = Condiment.createSaltPacket(1);
        System.out.println(salt.toString());
    }
}
