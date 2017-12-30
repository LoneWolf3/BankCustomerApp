package com.sac.service;

import java.util.List;

import com.sac.exception.RecrtServiceException;
import com.sac.model.AppUser;
import com.sac.model.AppUserRole;

public interface AppUserRoleService {

    List<? extends AppUserRole> getByAppUser(AppUser appUser) throws RecrtServiceException;

}
