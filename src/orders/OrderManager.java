package orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Хранит все заказы в ArrayList и умеет создавать заказы
 * и искать их по ID.
 */
public class OrderManager {

    private final List<Order> orders;
    private int nextOrderId;

    public OrderManager() {
        this.orders = new ArrayList<>();
        this.nextOrderId = 1;
    }

    public Order createOrder() {
        Order order = new Order(nextOrderId);
        nextOrderId++;
        orders.add(order);
        return order;
    }

    /** Поиск заказа по ID. Возвращает null, если не найден. */
    public Order findOrderById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }
}
