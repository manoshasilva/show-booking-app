package jpmc.book.exception;

public class BookAShowException extends Exception {

    private String errorMessage;

    public BookAShowException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
