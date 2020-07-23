package com.example.jpa.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	private Name name;

	@NotNull
	@Email
	@Column(unique = true)
	private String email;

	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
			@AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
	})
	private Address address;

	public User(Name name, String email, Address address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}

}
