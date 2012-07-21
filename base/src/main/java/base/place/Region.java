package base.place;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_region")
@Proxy(lazy = false)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name = "city_code")
	private City city;

	@Column(name = "zip_code")
	private String zipcode;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
