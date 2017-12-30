package com.sac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sac.exception.RecrtServiceException;
import com.sac.model.AppUser;
import com.sac.persistence.repository.AppUserRepository;
import com.sac.service.AppUserService;

@Service("appUserService")
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    @Transactional
    public List<? extends AppUser> getAll() throws RecrtServiceException {
        return appUserRepository.findAll();
    }

    @Override
    @Transactional
    public AppUser get(String username) {
        return appUserRepository.findOne(username);
    }
}
