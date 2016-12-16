package javaCourse.levelTwo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * POJO address
 * 
 * @author Vladimir Pliuta
 *
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_address", unique = true, nullable = false)
	private Integer id;

	@Column(length = 6)
	private Integer postcode;
	@Column
	private String city;
	@Column
	private String street;
	@Column
	private String house;
	@Column
	private Integer flat;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "address")
	private Set<Reader> readers;

	public Address() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public Integer getFlat() {
		return flat;
	}

	public void setFlat(int flat) {
		this.flat = flat;
	}

	public Set<Reader> getReaders() {
		return readers;
	}

	public void setReaders(Set<Reader> readers) {
		this.readers = readers;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", postcode=" + postcode + ", city=" + city + ", street=" + street + ", house="
				+ house + ", flat=" + flat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = id != null ? id.hashCode() : 0;
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + ((flat == null) ? 0 : flat.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Reader))
			return false;

		Address address = (Address) o;

		if (id != null ? !id.equals(address.id) : address.id != null)
			return false;
		if (city != null ? !city.equals(address.city) : address.city != null)
			return false;
		if (postcode != null ? !postcode.equals(address.postcode) : address.postcode != null)
			return false;
		if (street != null ? !street.equals(address.street) : address.street != null)
			return false;
		if (house != null ? !house.equals(address.house) : address.house != null)
			return false;
		if (flat != null ? !flat.equals(address.flat) : address.flat != null)
			return false;

		return true;
	}

}
