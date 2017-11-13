package net.tncy.demo;

import java.util.Date;
import javax.validation.constraints.*;

public class Person {

	@NotNull
	@Size(min=2, max=30)
	private String firstName;
	
	@Size(min=2, max=30)
	private String lastName;
	
	@NotNull
	@PositiveOrZero
	private int age;
	
	@AssertTrue
	private Boolean isAlive;
	
	public Person(String firstName, String lastName, int age, Boolean isAlive) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.isAlive = isAlive;
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return this.firstName;
	}
}
