package orders;

/**
 * Товар в заказе: ID, название, цена, количество.
 * Стоимость товара считается автоматически как price * quantity.
 */
public class Product {

    private final int id;
    private final String name;
    private final double price;
    private final int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * Стоимость строки заказа: цена * количество.
     */
    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("  [%d] %-20s %9.2f x %-3d = %10.2f тенге",
                id, name, price, quantity, getTotalPrice());
    }
}
