/*
 *  Product
 *  1.0
 *  11/8/22, 8:30 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.product;

/**
 * The type Product.
 */
public class Product {
    /** The Product name. **/
    private String productName;
    /** The Product price. **/
    private Double productPrice;
    /** The Product type defined by: 1 = Basic need, 2 =  Work tool, 3 = Luxury.  **/
    private Integer productType;

    /**
     * Instantiates a new Product.
     *
     * @param name  the name
     * @param price the price
     * @param type  the type
     */
    public Product(final String name, final Double price, final Integer type) {
        productName = name;
        productPrice = price;
        productType = type;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return productName;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(final String name) {
        productName = name;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Double getPrice() {
        return productPrice;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(final Double price) {
        productPrice = price;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public Integer getType() {
        return productType;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(final Integer type) {
        productType = type;
    }

    @Override
    public String toString() {
        return "Product{"
                + "name='" + productName + '\''
                + ", price=" + productPrice
                + ", type=" + productType + '}';
    }
}
