package base.place;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_city")
@Proxy(lazy = false)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
	@OrderBy("code asc")
	private Set<Region> regions;

	@ManyToOne(optional = false)
	@JoinColumn(name = "province_code")
	private Province province;

	@Column(name = "zip_code")
	private String zipcode;

	@Column(name = "phone_code")
	private String phoneCode;

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

	public Set<Region> getRegions() {
		return regions;
	}

	public void setRegions(Set<Region> regions) {
		this.regions = regions;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

}
