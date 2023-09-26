/*
 *  Order
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.order;

import coe.unosquare.benefits.enums.PaymetType;
import coe.unosquare.benefits.exception.NoSuchPaymentTypeException;
import coe.unosquare.benefits.product.Product;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * The type Order.
 */
public class Order {
    /** Store the final list of products and quantity for each product. **/
    private final Map<Product, Integer> products;

    /** Represents the type of visa card **/
    private static final String VISA = "Visa";

    /** Represents the type of Mastercard card **/
    private static final String MASTERCARD = "Mastercard";

    /**
     * Instantiates a new Order.
     *
     * @param productsMap the list of products added to the order
     */
    public Order(final Map<Product, Integer> productsMap) {
        products = productsMap;
    }

    /**
     * Pay double.
     *
     * @param paymentType the payment type
     * @return the double
     */
    public Double pay(final PaymetType paymentType) {
        Double discount;
        Integer productsToPay;
        Double subtotal = getTotalAmountToPay(products.entrySet());

        if (paymentType.equals(VISA)) {
            productsToPay = getNumberOfProductsToPay(products.values());
            discount = getDiscount(productsToPay);
        } else if (paymentType.equals(MASTERCARD)) {
            discount = getDiscount(subtotal);
        } else {
            throw new NoSuchPaymentTypeException("Invalid payment type");
        }

        return subtotal - subtotal * discount;
    }

    /**
     * Gets the number of products to pay
     *
     * @param items
     * @return
     */
    private Integer getNumberOfProductsToPay(Collection<Integer> items) {
        return items.stream()
                .reduce(0, (totalProductCount, quantity) -> totalProductCount += quantity);
    }

    /**
     * Gets the total amount to pay
     *
     * @param values
     * @return
     */
    private Double getTotalAmountToPay(Set<Map.Entry<Product, Integer>> values) {
        return values.stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum();
    }

    /**
     * Gets the discount
     *
     * @param productsToPay
     * @return
     */
    private Double getDiscount(Integer productsToPay) {
        Double discount;

        if (productsToPay >= 10) {
            discount = 0.15;
        } else if (productsToPay >= 7) {
            discount = 0.10;
        } else {
            discount = 0.05;
        }

        return discount;
    }

    /**
     * Gets the discount
     *
     * @param totalAmountToPay
     * @return
     */
    private Double getDiscount(Double totalAmountToPay) {
        Double discount;
        if (totalAmountToPay >= 100) {
            discount = 0.17;
        } else if (totalAmountToPay >= 75) {
            discount = 0.12;
        } else {
            discount = 0.08;
        }

        return discount;
    }

    /**
     * Print.
     */
    public void print() {
         products.forEach((product, quantity) ->
                 System.out.println("Product:{" + product.getName() + ","
                         + product.getPrice() + ","
                         + product.getType()
                         + "},Quantity:" + quantity
                         + ",Total:" + product.getPrice() * quantity));
    }
}
