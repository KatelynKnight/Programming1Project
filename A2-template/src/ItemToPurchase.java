public class ItemToPurchase {
    private String itemName;
    private int itemPrice;
    private int itemQuantity;


    // Initialising constructor method
    public ItemToPurchase() {
        this.itemName = "none";
        this.itemPrice = 0;
        this.itemQuantity = 0;
    }
    // Initialising constructor method
    public ItemToPurchase(String name, int price, int quantity) {
        if (name != null) {
            this.itemName = name;
        }
        if (price > 0) {
            this.itemPrice = price;
        }
        if (quantity > 0) {
            this.itemQuantity = quantity;
        }
    }
    //sets the name of the itemName
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    //method to get the itemName
    public String getItemName() {
        return itemName;
    }
    //method to set the price of the item
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
    //method to retrieve the price of the item
    public int getItemPrice() {
        return itemPrice;
    }
    //method to set the quantity of the item
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
    //method to get the quantity of the item
    public int getItemQuantity() {
        return itemQuantity;
    }
    //calculates the total price of the item set by multiplying the price by the quantity
    public int getTotalPrice() {
        int total = getItemPrice() * getItemQuantity();
        return total;
    }
    //A custom toString method to print the item name quantity and price
    @Override
    public String toString() {
        return getItemName() + " " + getItemQuantity() + " @ $" + getItemPrice() + " = $" + getTotalPrice() + "\n";

    }
}
