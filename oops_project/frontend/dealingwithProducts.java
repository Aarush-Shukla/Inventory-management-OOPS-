package frontend;

import java.util.*;

import inventory.CustomException;
import items.*;

public class dealingwithProducts {

    public Product initialiseProduct() throws CustomException {

        Scanner sc = new Scanner(System.in);

        String name;
        int productId;
        double price;
        double discount = 0.0;
        int quantity = 0;

        System.out.println("Enter the type of product: ");
        String type = (sc.nextLine()).toLowerCase();
        System.out.println("Enter the name of the product: ");
        name = sc.nextLine();
        System.out.println("Enter the productId: ");
        productId = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the price of the product: ");
        price = Double.parseDouble(sc.nextLine());
        System.out.println("Enter the discount of the product: ");
        if (sc.hasNextDouble()) {
            discount = sc.nextDouble();
        } else {
            sc.nextLine();
        }
        System.out.println("Enter the quantity of the product: ");
        if (sc.hasNextInt()) {
            quantity = sc.nextInt();
        } else {
            sc.nextLine();
        }

        sc.close();
        if (type.equals("ac")) {
            if (quantity != 0 && discount != 0.0) {
                return new AC(name, productId, price, discount, quantity);
            } else {
                return new AC(name, productId, price);
            }
        } else if (type.equals("tv")) {
            if (quantity != 0 && discount != 0.0) {
                return new Tv(name, productId, price, discount, quantity);
            } else {
                return new Tv(name, productId, price);
            }
        } else if (type.equals("dishwasher")) {
            if (quantity != 0 && discount != 0.0) {
                return new Dishwasher(name, productId, price, discount, quantity);
            } else {
                return new Dishwasher(name, productId, price);
            }
        } else if (type.equals("washing machine")) {
            if (quantity != 0 && discount != 0.0) {
                return new WashingMachine(name, productId, price, discount, quantity);
            } else {
                return new WashingMachine(name, productId, price);
            }
        } else if (type.equals("refigerator")) {
            if (quantity != 0 && discount != 0.0) {
                return new Refigerator(name, productId, price, discount, quantity);
            } else {
                return new Refigerator(name, productId, price);
            }
        } else {
            throw new CustomException.NotAType("Product Type doesn't match", null);
        }

    }

    public List<Product> initialiseProducts(int n) throws CustomException {
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Product temp = initialiseProduct();
            products.add(temp);
        }
        return products;
    }
}
