package javaCourse.levelTwo.dao.exceptions;

public class DaoException extends Exception {

  	private Exception exception;

    public DaoException(Exception exception) {
        this.exception = exception;
    }

    public DaoException() {

    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
