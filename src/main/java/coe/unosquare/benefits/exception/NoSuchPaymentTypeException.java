package coe.unosquare.benefits.exception;

public class NoSuchPaymentTypeException extends RuntimeException {

    public NoSuchPaymentTypeException(String message) {
        super(message);
    }
}
