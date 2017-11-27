package br.univel.domain.model.customer;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 * 
 * https://www.iso.org/standard/63546.html
 * 
 * @author aureo.junior
 * @since 27/11/2017
 */
public class CountrySubDivision {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String provinceCode;
	
	private String provinceName;
	
	@JoinColumn
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
