package com.h2.db.service;

import com.h2.db.entity.Customer;
import com.h2.db.entity.Order1;
import com.h2.db.entity.Product;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsPractiseQuestions {

  public static void main(String[] args) {
    /** Create Products */
    List<Product> prdLst = new ArrayList<>();
    Product p1 = Product.builder().id(1001l).name("Soap").category("Bathing").price(10d).build();
    Product p2 =
        Product.builder().id(1002l).name("Selling Is Human").category("Books").price(200d).build();
    Product p3 =
        Product.builder().id(1003l).name("baby Cream").category("Baby").price(1000d).build();
    Product p4 =
        Product.builder().id(1004l).name("Flipkart Books").category("Books").price(400d).build();
    Product p5 =
        Product.builder().id(1005l).name("kids-wheel").category("Toys").price(10000d).build();
    Product p6 =
        Product.builder().id(1006l).name("Flipkart Books1").category("Books").price(300d).build();
    prdLst.add(p1);
    prdLst.add(p2);
    prdLst.add(p3);
    prdLst.add(p4);
    prdLst.add(p5);
    prdLst.add(p6);

    /** Create Customers */
    List<Customer> custLst = new ArrayList<>();
    Customer c1 = Customer.builder().id(300l).name("Naman").tier(2).build();
    Customer c2 = Customer.builder().id(301l).name("Ankit").tier(1).build();
    Customer c3 = Customer.builder().id(302l).name("Rahul").tier(2).build();
    Customer c4 = Customer.builder().id(303l).name("Saurabh").tier(3).build();
    Customer c5 = Customer.builder().id(304l).name("Avinash").tier(1).build();
    Customer c6 = Customer.builder().id(305l).name("Neetu").tier(3).build();
    custLst.add(c1);
    custLst.add(c2);
    custLst.add(c3);
    custLst.add(c4);
    custLst.add(c5);
    custLst.add(c6);

    /** Add product to order */
    Set<Product> prdSet1 = new HashSet<>();
    prdSet1.add(p1);
    Set<Product> prdSet2 = new HashSet<>();
    prdSet2.add(p2);
    Set<Product> prdSet3 = new HashSet<>();
    prdSet3.add(p3);
    Set<Product> prdSet4 = new HashSet<>();
    prdSet4.add(p4);
    Set<Product> prdSet5 = new HashSet<>();
    prdSet5.add(p5);

    /** Create Order */
    List<Order1> orderLst = new ArrayList<>();
    Order1 o1 =
        Order1.builder()
            .id(201l)
            .orderDate(LocalDate.of(2021, 02, 15))
            .deliveryDate(LocalDate.now().minusDays(3l))
            .status("Pending")
            .products(prdSet1)
            .customer(c1)
            .build();
    Order1 o2 =
        Order1.builder()
            .id(202l)
            .orderDate(LocalDate.now().minusDays(2l))
            .deliveryDate(LocalDate.now().minusDays(2l))
            .status("Pending")
            .products(prdSet2)
            .customer(c2)
            .build();
    Order1 o3 =
        Order1.builder()
            .id(203l)
            .orderDate(LocalDate.of(2021, 02, 28))
            .deliveryDate(LocalDate.now().minusDays(1l))
            .status("Pending")
            .customer(c3)
            .products(prdSet3)
            .build();
    Order1 o4 =
        Order1.builder()
            .id(204l)
            .orderDate(LocalDate.now().minusDays(4l))
            .deliveryDate(LocalDate.now().minusDays(4l))
            .status("Pending")
            .customer(c4)
            .products(prdSet4)
            .build();
    orderLst.add(o1);
    orderLst.add(o2);
    orderLst.add(o3);
    orderLst.add(o4);

    /** Exercise 1 — Obtain a list of products belongs to category “Books” with price>200 */
    System.out.println(
        prdLst.stream()
            .filter(
                product ->
                    "Books".equals(product.getCategory()) && product.getPrice().compareTo(200d) > 0)
            .collect(Collectors.toList()));

    /** Exercise 2 — Obtain a list of order with products belong to category Baby */
    System.out.println(
        orderLst.stream()
            .filter(
                order1 ->
                    order1.getProducts().stream()
                        .anyMatch(product -> "Baby".equals(product.getCategory())))
            .collect(Collectors.toList()));

    /** Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount */
    System.out.println(
        prdLst.stream()
            .filter(product -> "Toys".equals(product.getCategory()))
            .map(product -> product.withPrice(product.getPrice() + 0.9))
            .collect(Collectors.toList()));

    /**
     * Exercise 4 — Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and
     * 01-Apr-2021
     */
    orderLst.stream()
        .filter(order1 -> order1.getCustomer().getTier() == 2)
        .filter(order1 -> order1.getOrderDate().compareTo(LocalDate.of(2021, 02, 01)) > 0)
        .filter(order1 -> order1.getOrderDate().compareTo(LocalDate.of(2021, 04, 01)) < 0)
        .flatMap(order1 -> order1.getProducts().stream())
        .distinct()
        .collect(Collectors.toList());

    /** Exercise 5 — Get the cheapest products of “Books” category */
    System.out.println(
        prdLst.stream()
            .filter(product -> "Books".equals(product.getCategory()))
            .min(Comparator.comparing(Product::getPrice)));

    /** Exercise 6 — Get the 3 most recent placed order */
    System.out.println(
        orderLst.stream()
            .sorted(Comparator.comparing(Order1::getOrderDate).reversed())
            .limit(3)
            .collect(Collectors.toList()));

    /**
     * Exercise 7 Get a list of orders which were ordered on 15-Mar-2021, log the order records to
     * the console and then return its product list
     */
    System.out.println(
        orderLst.stream()
            .filter(order1 -> order1.getOrderDate().compareTo(LocalDate.of(2021, 03, 15)) == 0)
            .peek(order1 -> System.out.println(order1))
            .flatMap(order1 -> order1.getProducts().stream())
            .collect(Collectors.toList()));

    /** Exercise 8 — Calculate total lump sum of all orders placed in Feb 2021 */
    System.out.println(
        orderLst.stream()
            .filter(order1 -> order1.getOrderDate().compareTo(LocalDate.of(2021, 02, 01)) >= 0)
            .filter(order1 -> order1.getOrderDate().compareTo(LocalDate.of(2021, 02, 28)) <= 0)
            .flatMap(order1 -> order1.getProducts().stream())
            .mapToDouble(Product::getPrice)
            .sum());

    /** Exercise 9 — Calculate order average payment placed on 14-Mar-2021 */
    System.out.println(
        orderLst.stream()
            .filter(order1 -> order1.getOrderDate().compareTo(LocalDate.of(2021, 02, 01)) >= 0)
            .filter(order1 -> order1.getOrderDate().compareTo(LocalDate.of(2021, 02, 28)) <= 0)
            .flatMap(order1 -> order1.getProducts().stream())
            .mapToDouble(Product::getPrice)
            .average()
            .getAsDouble());

    /**
     * Exercise 10 — Obtain a collection of statistic figures (i.e. sum, average, max, min, count)
     * for all products of category “Books”
     */
    DoubleSummaryStatistics summaryStats =
        prdLst.stream()
            .filter(product -> "Books".equals(product.getCategory()))
            .mapToDouble(Product::getPrice)
            .summaryStatistics();
    System.out.println(
        summaryStats.getMax()
            + "/"
            + summaryStats.getAverage()
            + "/"
            + summaryStats.getCount()
            + "/"
            + summaryStats.getMin()
            + "/"
            + summaryStats.getSum());

    /** Exercise 11 — Obtain a data map with order id and order’s product count */
    System.out.println(
        orderLst.stream().collect(Collectors.toMap(o -> o.getId(), o -> o.getProducts().size())));

    /** Exercise 12 — Produce a data map with order records grouped by customer */
    System.out.println(orderLst.stream().collect(Collectors.groupingBy(Order1::getCustomer)));

    /** Exercise 13 — Produce a data map with order record and product total sum */
    System.out.println(
        orderLst.stream()
            .collect(
                Collectors.toMap(
                    Function.identity(),
                    order1 -> order1.getProducts().stream().mapToDouble(Product::getPrice).sum())));

    /** Exercise 14 — Obtain a data map with list of product name by category */
    System.out.println(
        prdLst.stream()
            .collect(
                Collectors.groupingBy(
                    Product::getCategory,
                    Collectors.mapping(product -> product.getName(), Collectors.toList()))));
    /** Exercise 15 — Get the most expensive product by category */
    System.out.println(
        prdLst.stream()
            .collect(
                Collectors.groupingBy(
                    Product::getCategory,
                    Collectors.maxBy(Comparator.comparing(Product::getPrice)))));
  }
}
