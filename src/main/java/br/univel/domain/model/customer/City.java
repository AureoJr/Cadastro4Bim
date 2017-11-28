package br.univel.domain.model.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private Integer population;
	
	@OneToOne
	@JoinColumn(referencedColumnName = "country_subdivision_id")
	private CountrySubDivision countrySubDivision;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public CountrySubDivision getCountrySubDivision() {
		return countrySubDivision;
	}

	public void setCountrySubDivision(CountrySubDivision countrySubDivision) {
		this.countrySubDivision = countrySubDivision;
	}
	
	
}
