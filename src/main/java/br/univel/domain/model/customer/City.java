package br.univel.domain.model.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private Integer population;
	
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
