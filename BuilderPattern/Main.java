package BuilderPattern;

import java.util.List;

class Burger {

    // required fields
    private final String bun;
    private final String patty;

    // optional fields
    private final boolean cheese;
    private final List<String> toppings;
    private final String side;
    private final String drink;

    // private constructor
    private Burger(Builder builder) {
        this.bun = builder.bun;
        this.patty = builder.patty;
        this.cheese = builder.cheese;
        this.toppings = builder.toppings;
        this.side = builder.side;
        this.drink = builder.drink;
    }

    public void showBurger() {
        System.out.println("Burger Details:");
        System.out.println("Bun: " + bun);
        System.out.println("Patty: " + patty);
        System.out.println("Cheese: " + cheese);
        System.out.println("Toppings: " + toppings);
        System.out.println("Side: " + side);
        System.out.println("Drink: " + drink);
        System.out.println("-------------------");
    }

    // Builder class
    public static class Builder {

        // required
        private final String bun;
        private final String patty;

        // optional (default values)
        private boolean cheese = false;
        private List<String> toppings = List.of();
        private String side = "None";
        private String drink = "None";

        public Builder(String bun, String patty) {
            this.bun = bun;
            this.patty = patty;
        }

        public Builder addCheese() {
            this.cheese = true;
            return this;
        }

        public Builder setToppings(List<String> toppings) {
            this.toppings = toppings;
            return this;
        }

        public Builder setSide(String side) {
            this.side = side;
            return this;
        }

        public Builder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Burger basicBurger =
                new Burger.Builder("Wheat Bun", "Veg Patty")
                        .build();

        Burger deluxeBurger =
                new Burger.Builder("Sesame Bun", "Chicken Patty")
                        .addCheese()
                        .setToppings(List.of("Lettuce", "Tomato", "Onion"))
                        .setSide("Fries")
                        .setDrink("Coke")
                        .build();

        basicBurger.showBurger();
        deluxeBurger.showBurger();
    }
}
