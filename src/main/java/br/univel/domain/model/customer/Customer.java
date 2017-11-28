package br.univel.domain.model.customer;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "custumer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "customer_sequence")
	private Integer id;
	
	@Column(name = "display_name")
	private String displayName;
	
	@Column
	private String name;
	
	@OneToMany
	@JoinColumn(name = "customer_id")
	private List<Address> address;
	
	@Column(name = "image_profile")
	private String imageProfile;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageProfile() {
		return imageProfile;
	}

	public void setImageProfile(String imageProfile) {
		this.imageProfile = imageProfile;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
}
