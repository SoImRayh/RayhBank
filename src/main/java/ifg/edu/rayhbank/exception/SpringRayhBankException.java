package ifg.edu.rayhbank.exception;

public class SpringRayhBankException extends RuntimeException{
    public SpringRayhBankException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringRayhBankException(String exMessage) {
        super(exMessage);
    }
}
