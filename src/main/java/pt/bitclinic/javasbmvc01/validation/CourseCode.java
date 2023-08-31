package pt.bitclinic.javasbmvc01.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pt.bitclinic.javasbmvc01.constraints.CourseCodeConstraintValidator;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	// define default course code
	public String value() default "TEC";
	
	// define default error message
	public String message() default "must start with TEC";
	
	// define default groups
	// Groups: can group related constraints
	Class<?>[] groups() default {};

	// define default payload
	// Payloads: provide custom details about validation failure (severity level, error code...)
	Class<? extends Payload>[] payload() default {};
}
