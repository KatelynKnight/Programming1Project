import java.util.Locale;
import java.util.Scanner;

public class ShoppingCartManager {


    // I am not going to comment this class much only because it really was just a place for me to throw my methods
    // together to make one cohesive piece
    public static void stage1(ItemToPurchase item) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter item name");
        String name = scnr.next();
        item.setItemName(name);
        System.out.println("Please enter item price");
        int price = scnr.nextInt();
        item.setItemPrice(price);
        System.out.println("Please enter item quantity");
        int quantity = scnr.nextInt();
        item.setItemQuantity(quantity);
        System.out.print(item.toString());

    }

    public static void stage2(ShoppingCart cart) {
        ItemToPurchase item = new ItemToPurchase();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter name");
        String name = scnr.nextLine();
        cart.setCustomerName(name);
        System.out.println("Please enter date");
        String date = scnr.nextLine();
        cart.setCurrentDate(date);
        cart.printTotal();

        while (true) {

            // A while loop instead of prompting the user only twice because I wanted to experiment with many
            // cart items. You press Q at the end of the add item phase so you can exit at any time after 1 or more items
            System.out.println("Enter new item");
            String newItem = scnr.next();
            item.setItemName(newItem);
            System.out.println("Enter new price");
            int newPrice = scnr.nextInt();
            item.setItemPrice(newPrice);
            System.out.println("Enter new quantity");
            int newQty = scnr.nextInt();
            item.setItemQuantity(newQty);
            cart.addItem(new ItemToPurchase(newItem, newPrice, newQty));
            System.out.println("If you want to quit press q ");
            String input = scnr.next();
            if (input.toLowerCase(Locale.ROOT).equals("q")) {
                cart.printTotal();
                break;
            }

        }

    }

    public static void stage3(ShoppingCart cart) {
        //simple if statement to see if the user wants to proceed with removing or modifying. I could have put this in
        // the remove/modify method but I wanted to keep it short and concise
        Scanner scnr = new Scanner(System.in);
        System.out.println("Do you want to remove an item? Y/N");
        String input = scnr.next();
        if (input.toUpperCase(Locale.ROOT).equals("Y")) {

            System.out.println("Enter item to remove");
            String item = scnr.next();
            cart.removeItem(item);
            cart.printTotal();
        }
        System.out.println("Would you like to modify an item? Y/N");
        String modify = scnr.next();
        if (modify.toUpperCase(Locale.ROOT).equals("Y")) {
            System.out.println("Enter item to modify");
            String item = scnr.next();
            cart.modifyItem(item);
            cart.checkOut();

        }


    }

    public static void stage4(VIPShoppingCart cart) {
        //This is a really long and ugly method but It works marvelously so I am going to leave it as is
        Scanner scnr = new Scanner(System.in);
        ItemToPurchase item = new ItemToPurchase();
        System.out.println("Please VIP enter name");
        String name = scnr.nextLine();
        cart.setCustomerName(name);
        System.out.println("Please enter date");
        String date = scnr.nextLine();
        cart.setCurrentDate(date);
        System.out.println("Please enter amount of points");
        int points = scnr.nextInt();
        cart.setPoints(points);
        System.out.println("Enter new item");
        String newItem = scnr.next();
        item.setItemName(newItem);
        System.out.println("Enter new price");
        int newPrice = scnr.nextInt();
        item.setItemPrice(newPrice);
        System.out.println("Enter new quantity");
        int newQty = scnr.nextInt();
        item.setItemQuantity(newQty);
        cart.addItem(new ItemToPurchase(newItem, newPrice, newQty));
        cart.printTotal();
        cart.checkOut();
    }

    public static void main(String[] args) {
        ItemToPurchase item = new ItemToPurchase();
        ShoppingCart cart = new ShoppingCart();
        VIPShoppingCart vipCart = new VIPShoppingCart();
        System.out.println("***************Stage 1***************");
        stage1(item);
        System.out.println("***************Stage 2***************");
        stage2(cart);
        System.out.println("***************Stage 3***************");
        stage3(cart);
        System.out.println("***************Stage 4***************");
        stage4(vipCart);
    }
}
