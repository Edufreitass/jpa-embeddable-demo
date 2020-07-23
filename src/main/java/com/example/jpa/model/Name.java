package com.example.jpa.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Name {

	@NotNull
	@Size(max = 40)
	private String firstName;

	@Size(max = 40)
	private String middleName;

	@Size(max = 40)
	private String lastName;

}
