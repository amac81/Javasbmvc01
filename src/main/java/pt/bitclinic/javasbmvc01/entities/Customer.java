package pt.bitclinic.javasbmvc01.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String firstName;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;

	@Min(value = 0, message = "must be greater than or equal to zero")
	@Max(value = 10, message = "must be less than or equal to ten")
	private Integer freePasses;

	@NotNull(message = "is required")
	@Pattern(regexp = "^\\d{4}-\\d{3}$", message="must be in the form ####-###") // PT postal code ####-###
	private String postalCode;

	public Customer() {
	}

	public Customer(Long id, String firstName, String lastName, int freePasses, String postalCode) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.freePasses = freePasses;
		this.postalCode = postalCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", freePasses="
				+ freePasses + ", postalCode=" + postalCode + "]";
	}

}
