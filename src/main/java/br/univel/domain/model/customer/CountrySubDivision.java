package br.univel.domain.model.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * https://www.iso.org/standard/63546.html
 * 
 * @author aureo.junior
 * @since 27/11/2017
 */
@Entity
@Table(name = "Contry_Subdivision")
public class CountrySubDivision {

	@Id
	@GeneratedValue(generator = "Contry_Subdivision_sequence", 
				    strategy= GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "province_name")
	private String provinceCode;
	
	@Column(name = "province_name")
	private String provinceName;
	
	@OneToOne
	@JoinColumn(name = "country_id")
	private Country country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	
}
