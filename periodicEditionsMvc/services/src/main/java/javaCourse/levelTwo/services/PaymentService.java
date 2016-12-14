package javaCourse.levelTwo.services;

public interface PaymentService <T> extends Service<T> {
	double calculate (int issn, int period);
}

