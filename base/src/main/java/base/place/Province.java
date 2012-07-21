package base.place;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_province")
@Proxy(lazy = false)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Province implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "province", fetch = FetchType.EAGER)
	@OrderBy("code asc")
	private Set<City> citys;

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

	public Set<City> getCitys() {
		return citys;
	}

	public void setCitys(Set<City> citys) {
		this.citys = citys;
	}

}
