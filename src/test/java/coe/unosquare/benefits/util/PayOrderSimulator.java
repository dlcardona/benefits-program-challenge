/*
 *  PayOrderSimulator
 *  1.0
 *  11/8/22, 8:29 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.util;

import coe.unosquare.benefits.enums.PaymetType;
import coe.unosquare.benefits.order.Order;
import coe.unosquare.benefits.product.Product;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/**
 * The type Pay order simulator.
 */
public final class PayOrderSimulator {
    /**
     * Hide constructor to avoid instances of this utility class.
     */
    private PayOrderSimulator() { }

    /**
     * Method to simulate the process of an order being paid.
     *
     * @param products    the products
     * @param paymentType the payment type
     * @return the double
     */
    public static Double payOrder(final Map<Product, Integer> products,
                                  final PaymetType paymentType) {
        Order order = new Order(products);
        Double subtotal = products.entrySet()
                            .stream()
                            .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                            .sum();
        return new BigDecimal((subtotal - order.pay(paymentType)) / subtotal)
                .setScale(2, RoundingMode.HALF_EVEN)
                .doubleValue();
    }
}

