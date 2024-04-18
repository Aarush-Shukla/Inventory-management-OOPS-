package items;

public class WashingMachine extends Product {
    public WashingMachine(String name,
            int productId,
            double price) {
        this.name = name;
        this.productId = productId;
        this.price = price;
    }

    public WashingMachine(String name,
            int productId,
            double price, double discount, int quantity) {
        this.name = name;
        this.productId = productId;
        this.price = price;
        this.setDiscount(discount);
        this.setQuantity(quantity);
    }

    public double getDiscountedValue() {
        return this.price * (1 - (this.getDiscount()) / 100);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof WashingMachine)) {
            return false;
        }

        WashingMachine other = (WashingMachine) o;
        return this.productId == other.productId;
    }
}
