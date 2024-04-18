package items;

public class Refigerator extends Product {
    public Refigerator(String name,
            int productId,
            double price) {
        this.name = name;
        this.productId = productId;
        this.price = price;
    }

    public Refigerator(String name,
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

        if (!(o instanceof Refigerator)) {
            return false;
        }

        Refigerator other = (Refigerator) o;
        return this.productId == other.productId;
    }
}
