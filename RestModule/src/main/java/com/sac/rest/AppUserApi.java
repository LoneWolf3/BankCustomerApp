package com.sac.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sac.exception.RecrtServiceException;
import com.sac.model.AppUser;
import com.sac.rest.model.AppUserResource;
import com.sac.rest.model.BankAccountResource;
import com.sac.service.AppUserService;

@RestController
@RequestMapping(value = "/rest/users", produces = { APPLICATION_JSON_VALUE })
public class AppUserApi {

	@Autowired
	@Qualifier("appUserService")
	private AppUserService appUserService;

	/*
	 * @InitBinder protected void initBinder(WebDataBinder binder) {
	 * binder.setValidator(new AdvisorValidator()); }
	 */

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(method = RequestMethod.GET)
	public List<AppUserResource> search() throws RecrtServiceException {

		List<AppUserResource> result = new ArrayList<>();

		List<? extends AppUser> userEntities = appUserService.getAll();
		for (AppUser userEntity : userEntities) {
			result.add(new AppUserResource(userEntity));
		}

		return result;
	}

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(method = RequestMethod.POST)
	public BankAccountResource create(@RequestBody AppUserResource res) throws RecrtServiceException {
		System.out.println("hiiii");
		return null;
	}
}
