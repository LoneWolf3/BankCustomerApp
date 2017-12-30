package com.sac.rest.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sac.rest.model.AppUserResource;

/**
 *
 */
public class AdvisorValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AppUserResource.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors e) {

        //ValidationUtils.rejectIfEmpty(e, "id", "id.empty");

        //AppUserResource p = (AppUserResource) target;

        //perform additional checks
        //if name already exists or ?
    }
}