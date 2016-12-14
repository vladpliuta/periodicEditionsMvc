package javaCourse.levelTwo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * POJO payment
 * 
 * @author Vladimir Pliuta
 *
 */
@Entity
@Table(name = "payment")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_payment", unique = true, nullable = false)
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_reader")
	private Reader reader;

	@Column
	private Double coast;

	public Payment() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Double getCoast() {
		return coast;
	}

	public void setCoast(double coast) {
		this.coast = coast;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", coast=" + coast + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = id != null ? id.hashCode() : 0;
		result = prime * result + ((coast == null) ? 0 : coast.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Reader))
			return false;

		Payment payment = (Payment) o;

		if (id != null ? !id.equals(payment.id) : payment.id != null)
			return false;
		if (coast != null ? !coast.equals(payment.coast) : payment.coast != null)
			return false;

		return true;
	}
}
