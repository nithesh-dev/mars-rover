package exceptions;

public class RegionOutOFBoundException extends Throwable {
    private final String message;

    public RegionOutOFBoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
