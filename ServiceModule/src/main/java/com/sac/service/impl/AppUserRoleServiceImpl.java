package com.sac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sac.exception.RecrtServiceException;
import com.sac.model.AppUser;
import com.sac.model.AppUserRole;
import com.sac.persistence.model.AppUserEntity;
import com.sac.persistence.repository.AppUserRoleRepository;
import com.sac.service.AppUserRoleService;



@Service
public class AppUserRoleServiceImpl implements AppUserRoleService {

    @Autowired
    private AppUserRoleRepository repository;

    @Override
    @Transactional
    public List<? extends AppUserRole> getByAppUser(AppUser appUser) throws RecrtServiceException {
        return repository.findByKeyAppUser((AppUserEntity) appUser);
    }
}
