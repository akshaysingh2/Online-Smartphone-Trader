package com.me.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.bean.User;

public class Validation implements Validator{

    @Override
    public boolean supports(Class<?> type) {
             return type.isAssignableFrom(User.class);
    }

    @Override
    public void validate(Object m, Errors errors) {
        User user = (User) m;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "empty-username", "Username cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "empty-email", "email cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty-password", "Password cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "empty-city", "City cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "empty-address", "Address cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileno", "empty-mobileno", "Mobile Number cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipcode", "empty-zipcode", "Zipcode cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "empty-country", "Country cannot be blank");
            
        
    }
    
}
