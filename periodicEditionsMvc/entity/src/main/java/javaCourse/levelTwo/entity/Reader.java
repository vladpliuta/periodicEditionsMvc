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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * POJO reader
 * 
 * @author Vladimir Pliuta
 *
 */
@Entity
@Table(name = "reader")
// @NamedQuery(name = "findAll", query = "FROM Reader")
// @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Reader implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reader", unique = true, nullable = false)
	private Integer id;

	@Column
	private String surname;
	@Column
	private String forename;
	@Column
	private String login;
	@Column
	private String password;

	@Column(name = "admin_flag")
	private Integer adminFlag;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_address")
	private Address address;

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "subscription", joinColumns = @JoinColumn(name = "id_reader"), inverseJoinColumns = @JoinColumn(name = "ISSN"))
	private Set<PeriodicEdition> periodicEditions;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reader")
	private Set<Payment> payments;

	public Reader() {
	}

	public Reader(String surname, String forename, String login, String password) {
		this.surname = surname;
		this.forename = forename;
		this.login = login;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(int adminFlag) {
		this.adminFlag = adminFlag;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<PeriodicEdition> getPeriodicEditions() {
		return periodicEditions;
	}

	public void setPeriodicEditions(Set<PeriodicEdition> periodicEditions) {
		this.periodicEditions = periodicEditions;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "Reader [id=" + id + ", surname=" + surname + ", forename=" + forename + ", login=" + login
				+ ", password=" + password + ", adminFlag=" + adminFlag + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = id != null ? id.hashCode() : 0;
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((forename == null) ? 0 : forename.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((adminFlag == null) ? 0 : adminFlag.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Reader))
			return false;

		Reader reader = (Reader) o;

		if (id != null ? !id.equals(reader.id) : reader.id != null)
			return false;
		if (surname != null ? !surname.equals(reader.surname) : reader.surname != null)
			return false;
		if (forename != null ? !forename.equals(reader.forename) : reader.forename != null)
			return false;
		if (login != null ? !login.equals(reader.login) : reader.login != null)
			return false;
		if (password != null ? !password.equals(reader.password) : reader.password != null)
			return false;
		if (adminFlag != null ? !adminFlag.equals(reader.adminFlag) : reader.adminFlag != null)
			return false;

		return true;
	}
}
