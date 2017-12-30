package com.sac.service;

import java.util.List;

import com.sac.exception.RecrtServiceException;
import com.sac.model.BankAccount;

public interface BankAccountService {

    List<? extends BankAccount> getByAppUser(String appUserName) throws RecrtServiceException;

    BankAccount create(BankAccount account) throws RecrtServiceException;
}
