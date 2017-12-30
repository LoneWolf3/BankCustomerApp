package com.sac.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sac.exception.RecrtServiceException;
import com.sac.model.AppUser;
import com.sac.model.BankAccount;
import com.sac.persistence.model.AppUserEntity;
import com.sac.persistence.model.BankAccountEntity;
import com.sac.persistence.repository.AppUserRepository;
import com.sac.persistence.repository.BankAccountRepository;
import com.sac.service.BankAccountService;



@Service("bankAccountPersistenceService")
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public List<? extends BankAccount> getByAppUser(String appUserName) throws RecrtServiceException {
        AppUserEntity user = appUserRepository.findOne(appUserName);
        if (user != null) {
            return bankAccountRepository.findByAppUser(user);
        }
        return new ArrayList<>();
    }

    @Override
    @Transactional
    public BankAccount create(BankAccount account) throws RecrtServiceException {
        AppUser user = account.getAppUser();
        // TODO throw exception
        if (user != null) {
            AppUserEntity userEntity = appUserRepository.findOne(account.getAppUser().getUsername());

            if (userEntity != null) {
                BankAccountEntity target = new BankAccountEntity(account.getIban(), account.getBic(), userEntity);
                return bankAccountRepository.save(target);
            }
        }
        return null;
    }
}
