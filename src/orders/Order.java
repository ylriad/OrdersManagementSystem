package orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Заказ: содержит список товаров и статус.
 * Если сумма заказа превышает DISCOUNT_THRESHOLD, автоматически
 * применяется скидка DISCOUNT_RATE.
 */
public class Order {

    private static final double DISCOUNT_THRESHOLD = 50_000.0;
    private static final double DISCOUNT_RATE = 0.10;

    private final int id;
    private final List<Product> products;
    private OrderStatus status;

    public Order(int id) {
        this.id = id;
        this.products = new ArrayList<>();
        this.status = OrderStatus.NEW;
    }

    public int getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    /** Сумма заказа без учёта скидки. */
    public double getSubtotal() {
        double sum = 0;
        for (Product p : products) {
            sum += p.getTotalPrice();
        }
        return sum;
    }

    public boolean isDiscountApplied() {
        return getSubtotal() > DISCOUNT_THRESHOLD;
    }

    public double getDiscountAmount() {
        return isDiscountApplied() ? getSubtotal() * DISCOUNT_RATE : 0.0;
    }

    /** Итоговая сумма заказа с учётом скидки. */
    public double getTotal() {
        return getSubtotal() - getDiscountAmount();
    }

    /** Выводит полную информацию о заказе на экран. */
    public void printInfo() {
        System.out.println("=================================================");
        System.out.println("Заказ №" + id + "   Статус: " + status);
        System.out.println("-------------------------------------------------");
        if (products.isEmpty()) {
            System.out.println("  (товаров нет)");
        } else {
            for (Product p : products) {
                System.out.println(p);
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.printf("Промежуточный итог:  %10.2f тенге%n", getSubtotal());
        if (isDiscountApplied()) {
            System.out.printf("Скидка 10%%:         -%10.2f тенге%n", getDiscountAmount());
        }
        System.out.printf("ИТОГО К ОПЛАТЕ:      %10.2f тенге%n", getTotal());
        System.out.println("=================================================");
    }
}
