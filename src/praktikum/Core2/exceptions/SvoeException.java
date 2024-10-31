package praktikum.Core2.exceptions;

public class SvoeException extends Exception{
    /*
    у Exception 4 конструктора, но допускается переопределять только нужные, и даже добавить свои
     */
    public SvoeException() {
    }

    public SvoeException(final String message) {
        super(message);
    }

    public SvoeException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SvoeException(final Throwable cause) {
        super(cause);
    }
}
