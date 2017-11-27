package br.univel.domain.model.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * https://en.wikipedia.org/wiki/ISO_3166-1
 * www.iso.org/iso/country_codes.htm
 * 
 * @author aureo.junior
 * @since 27/11/2017
 */
@Entity
@Table(name = "country")
public class Country {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String alphaCode2;
	
	private String alphaCode3;
	
	private String shortName;
	
	private String numericCode;
	
	private boolean independent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlphaCode2() {
		return alphaCode2;
	}

	public void setAlphaCode2(String alphaCode2) {
		this.alphaCode2 = alphaCode2;
	}

	public String getAlphaCode3() {
		return alphaCode3;
	}

	public void setAlphaCode3(String alphaCode3) {
		this.alphaCode3 = alphaCode3;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getNumericCode() {
		return numericCode;
	}

	public void setNumericCode(String numericCode) {
		this.numericCode = numericCode;
	}

	public boolean isIndependent() {
		return independent;
	}

	public void setIndependent(boolean independent) {
		this.independent = independent;
	}
	
	
}
