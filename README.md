# Order Management System

A console-based Java application for managing customer orders, created as part of Practical Work №1.

## Description

The **Order Management System** allows users to create and manage multiple orders, add products to orders, calculate costs, apply discounts, update order statuses, and search for orders by ID.

The project demonstrates basic object-oriented programming principles and the use of Java collections.

## Features

The application provides the following functionality:

* Create a new order
* Add products to an order
* Store product information:

  * ID
  * Name
  * Price
  * Quantity
* Automatically calculate the cost of each product
* Calculate the total cost of an order
* Automatically apply a **10% discount** when the order total exceeds **20,000 KZT**
* Display complete order information
* Manage order statuses:

  * `NEW`
  * `PAID`
  * `DELIVERED`
  * `CANCELLED`
* Store multiple orders using `ArrayList`
* Search for an order by its ID

## Technologies

* **Java**
* **ArrayList**
* Object-Oriented Programming (OOP)
* Console-based user interface

## Project Structure

The application is divided into several classes instead of placing all functionality inside `Main`.

Typical project structure:

```text
orders_system/
├── src/
│   └── orders/
│       ├── Main.java
│       ├── Order.java
│       ├── Product.java
│       └── OrderStatus.java
├── .gitignore
└── README.md
```

### Main Classes

**`Product`**
Represents a product in an order. Stores its ID, name, price, and quantity and calculates the product's total cost.

**`Order`**
Represents an order and contains its products, ID, status, and total cost calculations.

**`OrderStatus`**
An enumeration containing the available order statuses: `NEW`, `PAID`, `DELIVERED`, and `CANCELLED`.

**`Main`**
Provides the console interface and allows the user to interact with the order management system.

## Discount Rules

The system automatically applies a **10% discount** if the total order amount is greater than **20,000 KZT**.

For example:

```text
Order total: 25,000 KZT
Discount: 10%
Final total: 22,500 KZT
```

## How to Run

1. Clone the repository:

```bash
git clone <repository-url>
```

2. Open the project in an IDE such as IntelliJ IDEA.

3. Compile and run `Main.java`.

4. Follow the instructions displayed in the console.

## Requirements

* Java Development Kit (JDK)
* Java-compatible IDE or terminal

## Purpose

This project was developed for **Practical Work №1 — "Order Management System"** to practice:

* Classes and objects
* Encapsulation
* Enumerations
* Collections
* Methods and constructors
* Basic business logic
* Separation of responsibilities between classes
