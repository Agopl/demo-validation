package net.tncy.demo;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class PersonTestTest {

	private static Validator validator;
	
	@BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
	
	@Test
	public void firstNameNotNull() {
		 Person person = new Person(null, "Crappie", 12, true);
		 Set<ConstraintViolation<Person>> constraintViolations = PersonTestTest.validator.validate( person );
		 
		 assertEquals( 1, constraintViolations.size());
		 assertEquals( "must not be null", constraintViolations.iterator().next().getMessage() );
	}
	
	@Test
	public void lastNameNotNull() {
		 Person person = new Person("Crappie", null, 12, true);
		 Set<ConstraintViolation<Person>> constraintViolations = PersonTestTest.validator.validate( person );
		 
		 assertEquals( 1, constraintViolations.size());
		 assertEquals( "must not be null", constraintViolations.iterator().next().getMessage() );
	}
	
	@Test
	public void ageNotNegative() {
		 Person person = new Person("Crappie", "Crappie", (-2) , true);
		 Set<ConstraintViolation<Person>> constraintViolations = PersonTestTest.validator.validate( person );
		 
		 assertEquals( 1, constraintViolations.size());
		 assertEquals( "must not be null", constraintViolations.iterator().next().getMessage() );
		 
	}
	
	@Test
	public void personIsValid() {
		 Person person = new Person("Crappie", "Crappie", 21 , true);
		 Set<ConstraintViolation<Person>> constraintViolations = PersonTestTest.validator.validate( person );
		 
		 assertEquals( 0, constraintViolations.size());
	}
	
	
}
