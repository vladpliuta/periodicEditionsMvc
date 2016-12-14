package javaCourse.levelTwo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * POJO subscription
 * 
 * @author Vladimir Pliuta
 *
 */
@Entity
@Table(name="subscription")
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_subscription", unique = true, nullable = false)
	private Integer id;
	@Column(name = "id_reader")
	private Integer idReader;
	@Column(name = "ISSN")
	private Integer issn;
	@Column
	private Integer period;

	public Subscription() {
	}

	public Subscription(int idReader, int issn, int period) {
		this.idReader = idReader;
		this.issn = issn;
		this.period = period;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getIdReader() {
		return idReader;
	}

	public void setIdReader(int idReader) {
		this.idReader = idReader;
	}

	public Integer getIssn() {
		return issn;
	}

	public void setIssn(int issn) {
		this.issn = issn;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", id reader=" + idReader + ", ISSN=" + issn + ", period=" + period + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = id != null ? id.hashCode() : 0;
		result = prime * result + ((idReader == null) ? 0 : idReader.hashCode());
		result = prime * result + ((issn == null) ? 0 : issn.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Reader))
			return false;

		Subscription subscription = (Subscription) o;

		if (id != null ? !id.equals(subscription.id) : subscription.id != null)
			return false;
		if (idReader != null ? !idReader.equals(subscription.idReader) : subscription.idReader != null)
			return false;
		if (issn != null ? !issn.equals(subscription.issn) : subscription.issn != null)
			return false;
		if (period != null ? !period.equals(subscription.period) : subscription.period != null)
			return false;
		
		return true;
	}
}
