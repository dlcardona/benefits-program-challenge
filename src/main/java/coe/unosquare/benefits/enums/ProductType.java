package coe.unosquare.benefits.enums;

public enum ProductType {
    BASIC(1),
    WORK_TOOL(2),
    LUXURY(3);

    private int value;

    ProductType(int value) {
        this.value = value;
    }
}
