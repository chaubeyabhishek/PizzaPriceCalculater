import java.util.Scanner;
public class PizzaHut {
    final double extra_cheese_prize = 50.0;
    final double coke_prize = 30.0;
    double regular_price;
    double mediume_price;
    double large_price;

    public PizzaHut(double regular_price , double mediume_price , double large_price){
        this.regular_price = regular_price;
        this.mediume_price = mediume_price;
        this.large_price = large_price;
    }

    public double calculatePrice(String size , int Quantity , boolean extraCheese , int cokeQuantity){
        double pizza_price = 0;

        if(size.equalsIgnoreCase("regular")){
            pizza_price = regular_price;
        }
        else if(size.equalsIgnoreCase("mediume")){
            pizza_price = mediume_price;
        }
        else if(size.equalsIgnoreCase("large")){
            pizza_price = large_price;
        }

        double total_price = pizza_price * Quantity;

        if(extraCheese){
            total_price += extra_cheese_prize * Quantity;
        }

        total_price += coke_prize * cokeQuantity;

        return total_price;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Regular_pizza price in Rs --> ");
        double regularPrice = sc.nextDouble();
        System.out.println("Enter mediume_pizza Price in Rs --> ");
        double mediumePrice = sc.nextDouble();
        System.out.println("Enter large_pizza price in Rs --> ");
        double largePrice = sc.nextDouble();
        PizzaHut pizzaHouse = new PizzaHut(regularPrice, mediumePrice, largePrice);
        System.out.print("Pizza Size (Regular/Medium/Large)--> ");
        String size = sc.next();
        System.out.print("Quantity ");
        int Quantity = sc.nextInt();
        System.out.print("Extra Cheese? (yes/no): ");
        boolean extraCheese = sc.next().equals("yes");
        int cokeQuantity = 0;
        System.out.print("Add Coke? (yes/no): ");
        if(sc.next().equals("Yes")){
            System.out.println("Enter coke Quantity: ");
            cokeQuantity = sc.nextInt();
            if(cokeQuantity < 0){
                System.out.println("Invalid Quantity.Setting coke quantity to 0.");
                cokeQuantity = 0;
            }
        }

        double finalPrice = pizzaHouse.calculatePrice(size, Quantity, extraCheese, cokeQuantity);
        System.out.println("Final Price: Rs " + finalPrice);

        sc.close();
    }

}
