package exceptions;

public class CustomerNotFound extends Throwable{
	public CustomerNotFound(String msg) {
		super(msg);
	}
}
