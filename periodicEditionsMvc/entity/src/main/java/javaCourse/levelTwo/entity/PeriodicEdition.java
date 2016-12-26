package javaCourse.levelTwo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * POJO periodic edition
 * 
 * @author Vladimir Pliuta
 *
 */
@Entity
@Table(name = "periodic_edition")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PeriodicEdition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ISSN", unique = true, nullable = false, length = 8)
	private Integer id;
	@Column
	private String title;
	
	@Column(name = "short_description")
	private String shortDescription;
	
	@Column(name = "month_periodicity")
	private Integer monthPeriodicity;
	
	@Column(name = "month_price")
	private Double monthPrice;
	
	@Column(name = "discount_quarteryear")
	private Integer discountQuarteryear;
	
	@Column(name = "discount_halfyear")
	private Integer discountHalfyear;
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "subscription", joinColumns = @JoinColumn(name = "ISSN"), inverseJoinColumns = @JoinColumn(name = "id_reader"))
	private Set<Reader> readers;

	public PeriodicEdition() {
	}

	public PeriodicEdition(int id, String title, String shortDescription, int monthPeriodicity, double monthPrice,
			int discountQuarteryear, int discountHalfyear) {
		this.id = id;
		this.title = title;
		this.shortDescription = shortDescription;
		this.monthPeriodicity = monthPeriodicity;
		this.monthPrice = monthPrice;
		this.discountQuarteryear = discountQuarteryear;
		this.discountHalfyear = discountHalfyear;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Integer getMonthPeriodicity() {
		return monthPeriodicity;
	}

	public void setMonthPeriodicity(int monthPeriodicity) {
		this.monthPeriodicity = monthPeriodicity;
	}

	public Double getMonthPrice() {
		return monthPrice;
	}

	public void setMonthPrice(double monthPrice) {
		this.monthPrice = monthPrice;
	}

	public Integer getDiscountQuarteryear() {
		return discountQuarteryear;
	}

	public void setDiscountQuarteryear(int discountQuarteryear) {
		this.discountQuarteryear = discountQuarteryear;
	}

	public Integer getDiscountHalfyear() {
		return discountHalfyear;
	}

	public void setDiscountHalfyear(int discountHalfyear) {
		this.discountHalfyear = discountHalfyear;
	}
	public Set<Reader> getReaders() {
		return readers;
	}

	public void setReaders(Set<Reader>readers) {
		this.readers = readers;
	}
	@Override
	public String toString() {
		return "Periodic edition [ISSN=" + id + ", title=" + title + ", short description=" + shortDescription
				+ ", month periodicity=" + monthPeriodicity + ", month price=" + monthPrice + ", discount quarteryear="
				+ discountQuarteryear + ", discount halfyear=" + discountHalfyear + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = id != null ? id.hashCode() : 0;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((shortDescription == null) ? 0 : shortDescription.hashCode());
		result = prime * result + ((monthPeriodicity == null) ? 0 : monthPeriodicity.hashCode());
		result = prime * result + ((monthPrice == null) ? 0 : monthPrice.hashCode());
		result = prime * result + ((discountQuarteryear == null) ? 0 : discountQuarteryear.hashCode());
		result = prime * result + ((discountHalfyear == null) ? 0 : discountHalfyear.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Reader))
			return false;

		PeriodicEdition periodicEdition = (PeriodicEdition) o;

		if (id != null ? !id.equals(periodicEdition.id) : periodicEdition.id != null)
			return false;
		if (title != null ? !title.equals(periodicEdition.title) : periodicEdition.title != null)
			return false;
		if (shortDescription != null ? !shortDescription.equals(periodicEdition.shortDescription)
				: periodicEdition.shortDescription != null)
			return false;
		if (monthPeriodicity != null ? !monthPeriodicity.equals(periodicEdition.monthPeriodicity)
				: periodicEdition.monthPeriodicity != null)
			return false;
		if (monthPrice != null ? !monthPrice.equals(periodicEdition.monthPrice) : periodicEdition.monthPrice != null)
			return false;
		if (discountQuarteryear != null ? !discountQuarteryear.equals(periodicEdition.discountQuarteryear)
				: periodicEdition.discountQuarteryear != null)
			return false;
		if (discountHalfyear != null ? !discountHalfyear.equals(periodicEdition.discountHalfyear)
				: periodicEdition.discountHalfyear != null)
			return false;
		return true;
	}
}
