package com.sac.service;

import java.util.List;

import com.sac.exception.RecrtServiceException;
import com.sac.model.AppUser;

public interface AppUserService {

    List<? extends AppUser> getAll() throws RecrtServiceException;

    AppUser get(String username) throws RecrtServiceException;

}
