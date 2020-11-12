package com.example.demo.estudos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private Long id;
	private String firstName;
	private String secondName;

	String uniqueAttributes() {
		return firstName + secondName;
	}

}
