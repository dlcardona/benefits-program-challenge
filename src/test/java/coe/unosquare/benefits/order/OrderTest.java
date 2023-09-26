/*
 *  OrderTest
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.order;

import coe.unosquare.benefits.enums.PaymetType;
import coe.unosquare.benefits.product.Product;
import coe.unosquare.benefits.util.ProductGenerator;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static coe.unosquare.benefits.util.PayOrderSimulator.payOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {
    @Test
    void orderWithVisaMoreThan10ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(15);
        assertEquals(0.15, payOrder(products, PaymetType.VISA));
    }

    @Test
    void orderWithVisa10ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(10);
        assertEquals(0.15, payOrder(products, PaymetType.VISA));
    }

    @Test
    void orderWithVisa7ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(7);
        assertEquals(0.10, payOrder(products, PaymetType.VISA));
    }

    @Test
    void orderWithVisaLessThan7ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(5);
        assertEquals(0.05, payOrder(products, PaymetType.VISA));
    }

    @Test
    void orderWithMastercardTotalAmountToPayMoreThan100DiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(110.0);
        assertEquals(0.17, payOrder(products, PaymetType.MASTERCARD));
    }

    @Test
    void orderWithMastercardTotalAmountToPayLessThan100DiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(100.0);
        assertEquals(0.17, payOrder(products, PaymetType.MASTERCARD));
    }

    @Test
    void orderWithMastercardTotalAmountToPayBetween75And99DiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(80.0);
        assertEquals(0.12, payOrder(products, PaymetType.MASTERCARD));
    }

    @Test
    void orderWithMastercardTotalAmountToPayEqualTo75DiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(75.0);
        assertEquals(0.12, payOrder(products, PaymetType.MASTERCARD));
    }

    @Test
    void orderWithMastercardTotalAmountToPayLessThan75DiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(60.0);
        assertEquals(0.08, payOrder(products, PaymetType.MASTERCARD));
    }
}
