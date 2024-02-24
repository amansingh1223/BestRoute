# BestRoute
# Delivery System

This project implements a delivery system that helps a delivery executive optimize the delivery route for multiple orders. The goal is to minimize the total delivery time while considering the preparation time at restaurants and the travel time between restaurants, consumers, and the delivery executive's current location.

## Features

- Calculates the minimum delivery time for a batch of orders
- Considers preparation time at restaurants and travel time between locations
- Supports multiple orders with different restaurant and consumer locations

## Classes

1. `Location`: Represents a geographic location with latitude and longitude coordinates.
2. `Restaurant`: Represents a restaurant with a location and preparation time for meals.
3. `Consumer`: Represents a consumer with a location.
4. `Order`: Represents an order placed by a consumer from a specific restaurant.
5. `DeliveryExecutive`: Manages the delivery process, including calculating the minimum delivery time for a batch of orders.

## Usage

To use the delivery system, follow these steps:

1. Create instances of `Location` for restaurants, consumers, and the delivery executive's current location.
2. Create instances of `Restaurant` with their respective locations and preparation times.
3. Create instances of `Consumer` with their locations.
4. Create instances of `Order` with restaurants and consumers.
5. Add the orders to a list.
6. Create an instance of `DeliveryExecutive` with the delivery executive's current location.
7. Call the `findMinimumDeliveryTime` method of the `DeliveryExecutive` class with the list of orders to calculate the minimum delivery time.

Example usage can be found in the `Main` class.

## Requirements

- Java Development Kit (JDK) 8 or higher

## Installation

No installation is required. Simply compile the Java files and run the `Main` class.
