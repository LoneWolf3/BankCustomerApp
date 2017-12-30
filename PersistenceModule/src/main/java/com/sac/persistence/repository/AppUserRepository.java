package com.sac.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sac.persistence.model.AppUserEntity;

@Transactional
public interface AppUserRepository extends JpaRepository<AppUserEntity, String> {

}
