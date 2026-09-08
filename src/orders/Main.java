package orders;

import java.util.List;
import java.util.Scanner;

/**
 * Точка входа: консольное меню "Системы управления заказами".
 * Вся логика вынесена в отдельные классы (Product, Order, OrderManager,
 * OrderStatus) — этот класс отвечает только за взаимодействие с пользователем.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final OrderManager manager = new OrderManager();
    private static int nextProductId = 1;

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Выберите пункт меню: ");
            switch (choice) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    addProductToOrder();
                    break;
                case 3:
                    showOrder();
                    break;
                case 4:
                    showAllOrders();
                    break;
                case 5:
                    changeOrderStatus();
                    break;
                case 6:
                    findOrder();
                    break;
                case 0:
                    running = false;
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный пункт меню, попробуйте снова.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("========= СИСТЕМА УПРАВЛЕНИЯ ЗАКАЗАМИ =========");
        System.out.println("1. Создать новый заказ");
        System.out.println("2. Добавить товар в заказ");
        System.out.println("3. Показать заказ по ID");
        System.out.println("4. Показать все заказы");
        System.out.println("5. Изменить статус заказа");
        System.out.println("6. Найти заказ по ID");
        System.out.println("0. Выход");
    }

    private static void createOrder() {
        Order order = manager.createOrder();
        System.out.println("Создан новый заказ с ID = " + order.getId());
    }

    private static void addProductToOrder() {
        if (manager.isEmpty()) {
            System.out.println("Нет ни одного заказа. Сначала создайте заказ.");
            return;
        }
        int orderId = readInt("Введите ID заказа: ");
        Order order = manager.findOrderById(orderId);
        if (order == null) {
            System.out.println("Заказ с ID " + orderId + " не найден.");
            return;
        }
        System.out.print("Название товара: ");
        String name = scanner.nextLine();
        double price = readDouble("Цена товара: ");
        int quantity = readInt("Количество: ");

        Product product = new Product(nextProductId, name, price, quantity);
        nextProductId++;
        order.addProduct(product);
        System.out.println("Товар добавлен в заказ №" + orderId);
    }

    private static void showOrder() {
        int orderId = readInt("Введите ID заказа: ");
        Order order = manager.findOrderById(orderId);
        if (order == null) {
            System.out.println("Заказ с ID " + orderId + " не найден.");
            return;
        }
        order.printInfo();
    }

    private static void showAllOrders() {
        List<Order> orders = manager.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("Заказов пока нет.");
            return;
        }
        for (Order order : orders) {
            order.printInfo();
        }
    }

    private static void changeOrderStatus() {
        int orderId = readInt("Введите ID заказа: ");
        Order order = manager.findOrderById(orderId);
        if (order == null) {
            System.out.println("Заказ с ID " + orderId + " не найден.");
            return;
        }
        System.out.println("Текущий статус: " + order.getStatus());
        System.out.println("Доступные статусы: NEW, PAID, DELIVERED, CANCELLED");
        System.out.print("Новый статус: ");
        String input = scanner.nextLine().trim().toUpperCase();
        try {
            OrderStatus status = OrderStatus.valueOf(input);
            order.setStatus(status);
            System.out.println("Статус заказа №" + orderId + " изменён на " + status);
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректный статус. Введите один из: NEW, PAID, DELIVERED, CANCELLED");
        }
    }

    private static void findOrder() {
        int orderId = readInt("Введите ID заказа для поиска: ");
        Order order = manager.findOrderById(orderId);
        if (order == null) {
            System.out.println("Заказ с ID " + orderId + " не найден.");
        } else {
            System.out.println("Заказ найден:");
            order.printInfo();
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim().replace(",", ".");
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число.");
            }
        }
    }
}
