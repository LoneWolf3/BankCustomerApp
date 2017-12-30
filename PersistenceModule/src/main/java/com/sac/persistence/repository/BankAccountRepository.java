package com.sac.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sac.persistence.model.AppUserEntity;
import com.sac.persistence.model.BankAccountEntity;

import java.util.List;

@Transactional
public interface BankAccountRepository extends JpaRepository<BankAccountEntity, String> {

    List<BankAccountEntity> findByAppUser(AppUserEntity appUser);
}
