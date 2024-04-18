package items;

// Hello kya be lodu 
public abstract class Product {
    String name;
    int productId;
    double price;
    private int quantity;
    private double discount;

    Product() {
        discount = 0.0;
        quantity = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getProductId() {
        return this.productId;
    }

    public double getprice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public double getDiscount() {
        return this.discount;
    }

    public abstract double getDiscountedValue();

}
