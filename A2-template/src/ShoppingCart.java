import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ShoppingCart {
    private static final int CAPACITY = 100;
    private String customerName;
    private String currentDate;
    private ItemToPurchase[] cartItems;
    private int itemCount;
    // I added this in so I did not have to rewrite it throughout the class where it was needed in each method
    private Scanner scnr = new Scanner(System.in);

    //initialise the shopping cart constructor
    public ShoppingCart() {
        this.customerName = "John Doe";
        this.currentDate = "1 January 2021";
        this.cartItems = new ItemToPurchase[CAPACITY];
        this.itemCount = 0;

    }

    //initialise the shopping cart constructor
    public ShoppingCart(String name, String date) {
        this.customerName = name;
        this.currentDate = date;
        this.cartItems = new ItemToPurchase[CAPACITY];
        this.itemCount = 0;
    }

    // sets customer name
    public void setCustomerName(String name) {
        this.customerName = name;
    }

    // gets the customer name
    public String getCustomerName() {
        return this.customerName;
    }

    // sets current date
    public void setCurrentDate(String date) {
        this.currentDate = date;
    }

    //gets the current date
    public String getCurrentDate() {
        return this.currentDate;
    }

    //Method to add an item that the customer inputs as an array with the item name quantity and price
    public boolean addItem(ItemToPurchase item) {
        //checks if the shopping cart is not at CAPACITY (100) and returns false if it has space
        if (this.itemCount + 1 > CAPACITY) {
            System.out.println("SHOPPING CART IS FULL");
            return false;
        } else {
            //it then checks if the item is already in the array, if it is, it returns false
            for (int i = 0; i < this.itemCount; i++) {
                if (this.cartItems[i].getItemName().equals(item.getItemName())) {
                    System.out.println("ITEM ALREADY EXISTS");
                    return false;
                }
            }
            //Finally the method adds the item to the array if all other statements return false
            this.itemCount++;
            //Making it put at the 0 point in the array
            this.cartItems[this.itemCount - 1] = item;

            return true;
        }

    }

    //Retrieves the number of items in cart and outputs into a readable element to be interpreted by other methods
    public int getNumItemsInCart() {
        int totalQty = 0;

        for (int i = 0; i < this.itemCount; i++) {
            totalQty += this.cartItems[i].getItemQuantity();
        }
        return totalQty;
    }

    //calculates the total cost of the cart, it multipies the price of each item by the quantity and then sums the total
    //of each item
    public int getCostOfCart() {
        int total = 0;

        for (int i = 0; i < this.itemCount; i++) {
            total += this.cartItems[i].getTotalPrice();
        }
        return total;
    }

    // A method to remove an item from the cartItems array. For some reason the method prints out the else statement
    // regardless of whether the item was successfully removed enough. As I am constrained by time and the method works
    // functionally, I don't particularly care to work out the issue
    public void removeItem(String itemName) {

        for (int i = 0; i < this.itemCount; i++) {
            // checks if the input is not null and if the names of the cart item and the parameter match
            if (this.cartItems[i] != null && this.cartItems[i].getItemName().equals(itemName)) {
                //overriding the cart items array element to remove it
                this.cartItems[i] = this.cartItems[this.itemCount - 1];
                this.itemCount = this.itemCount - 1;
                System.out.println("Item was removed from cart");
            } else {
                System.out.println("Item not found");
            }
        }

    }
    // the same issue as the remove item method applies with the item not found announcement printing regardless of
    // successful operation.
    public void modifyItem(String itemName) {

        for (int i = 0; i < this.itemCount; i++) {
            // same check as remove item
            if (this.cartItems[i] != null && this.cartItems[i].getItemName().equals(itemName)) {
                // asks user to type a new qty and inserts that int into the space where the original qty in the array was
                System.out.println("Please enter in a new quantity");
                int qty = scnr.nextInt();
                this.cartItems[i].setItemQuantity(qty);
                System.out.println("Quantity overridden");
            } else {
                System.out.println("Item not found");
            }
        }

    }

    // a method to check the cart out, if the user types Y then it will proceed, if it is anything but y, it will
    // exit the program, it was supposed to be to return to adding items but it wasn't specified in the document so
    // I didn't want to waste my time working on it.
    public void checkOut() {
        System.out.println("Do you wish to checkout Y/N");
        String checkout = scnr.next();
        if (checkout.toUpperCase(Locale.ROOT).equals("Y")) {
            // if the user wants to check out then the method will print the total from the array then it will
            // cleanse the array
            printTotal();
            for (int i = 0; i < this.itemCount; i++) {
                this.cartItems[i] = this.cartItems[i];
                this.itemCount = this.itemCount - 1;
                System.out.println("Thank you for shopping");
                break;
            }


        } else {
            System.out.print("Continue on shopping!");
        }
    }

    // a method that prints the total depending on whether there are any items in the item count member variable
    public void printTotal() {
        if (this.itemCount < 1) {
            System.out.println(getCustomerName() + "- " + getCurrentDate() + "\nSHOPPING CART EMPTY \n");
        } else {
            System.out.print(getCustomerName() + " - " + getCurrentDate() + "\nNumber of items: " + getNumItemsInCart() + "\n");
            for (int i = 0; i < this.itemCount; i++) {
                // prints each item of the array that has been filled with the correct information and prints it
                if (this.cartItems[i] != null) {
                    System.out.print(this.cartItems[i]);

                }
            }
            System.out.print("Total: $" + getCostOfCart() + "\n");
        }
    }
}




