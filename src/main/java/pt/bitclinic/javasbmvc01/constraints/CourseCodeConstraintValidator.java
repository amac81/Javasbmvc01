package pt.bitclinic.javasbmvc01.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pt.bitclinic.javasbmvc01.validation.CourseCode;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{
	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext context) {
		boolean result;
		
		if(theCode != null) {
			result = theCode.startsWith(coursePrefix);
		}else {
			result = true; //courseCode isn't a required field
		}
		
		return result;
	}

}
