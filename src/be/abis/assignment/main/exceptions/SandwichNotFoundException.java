package be.abis.assignment.main.exceptions;

public class SandwichNotFoundException extends RuntimeException {
    public SandwichNotFoundException(String message) {
        super(message);
    }
}
