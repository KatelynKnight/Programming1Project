import java.util.Scanner;

public class VIPShoppingCart extends ShoppingCart {
    private int points;
    private boolean VIP;
    private Scanner scnr = new Scanner(System.in);

    // initialises the VIPShoppingCart
    public VIPShoppingCart(String name, int points, boolean VIP) {
        name = getCustomerName();
        this.points = points;
        this.VIP = true;
    }
    // initialises the VIPShoppingCart
    public VIPShoppingCart() {
        super();
        this.points = 0;
        this.VIP = false;
    }
    // a method to set the points where needed
    public void setPoints(int points) {
        this.points = points;
    }
    // I added this in for clarity but honestly I never used it, I still think it should be here just for good practice
    // of having manipulators/getters&setters
    public int getPoints() {
        return this.points;
    }

    // this method calculates the 5% discount that members get only if the total is equal to or over $100
    // if the discount is not at or over 100 it will just print the regular cost of the cart
    public int vipDiscount() {
        if (getCostOfCart() >= 100) {
            int discount = getCostOfCart() * 5 / 100;
            int total = getCostOfCart() - discount;
            return total;
        }
        return getCostOfCart();
    }

    // this is a method to add the points earned from a transaction and then adds them to the member variable.
    // I added a print message telling the user how much was gained and the new total only because I thought that made
    // more sense and honestly looked better
    public void gainPoints() {
        this.points = getCostOfCart() + this.points;
        System.out.println("\nGained " + getCostOfCart() + " points!" + " New total: " + this.points);
    }

    // a method to redeemPoints, really could have made the method shorted but I ran out of steam towards part 4 and
    // I just wanted it done, that being said, I am quite happy with this method and I think it fulfills all the
    // requirements
    public void redeemPoints() {
        while (true) {
            System.out.println("How many points to redeem? To quit enter -1");
            // if the input is -1 then the method exits from the while loop
            int points = scnr.nextInt();
            if (points == -1) {
                break;
                // the else if statements checks if the input has a modulus of 0 if divided by 50, and if it is less
                // than however many points the user has. It will then redeem the points by removing the requested qty
                // divide the points by 50 to get the whole dollar amount and remove the dollar amount to the discounted
                // I used vipDiscount instead of getCostOfCart only because it allows for either that value or 5% off
                // it then prints out the desired message
            } else if (points % 50 == 0 && points <= this.points) {
                this.points = this.points - points;
                int pointsOff = points / 50;
                int totalPrice = vipDiscount() - pointsOff;
                // I made this the message only because I didn't like the one from the assignment spec sheet
                // I thought a little more clarity and information would reassure the user that everything is working
                // as intended by printing how many points were redeemed and how much money was saved via the points
                // and/or the discount.
                System.out.println("Successfully paid with " + pointsOff + " points, " + points + " points redeemed. " + this.points + " remaining!");
                System.out.println("Total price paid: $" + totalPrice + "!");
                break;

                // checks if the points are multiples of 50, if the modulus of the number is not 0 it will print this
            } else if (points % 50 != 0) {
                System.out.println("Please enter multiples of 50! Re-enter to try again. Type -1 to exit");

                // prints the message if the points requested are not enough to redeem
            } else if (points > this.points) {
                System.out.println("You do not have enough points! Re-enter to try again. Type -1 to exit");
            }
        }

    }

    // a new checkout method overriding the old one
    @Override
    public void checkOut() {
        gainPoints();
        redeemPoints();
        System.out.println("Thank you for shopping with us today");

    }

    // a new print total method overriding the previous one
    @Override
    public void printTotal() {
        System.out.print(getCustomerName() + " - " + getCurrentDate() + "\nNumber of items: " + getNumItemsInCart() + "\n");
        System.out.print("Total: $" + getCostOfCart() + "\n" + "Total after discount: $" + vipDiscount());

    }


}
