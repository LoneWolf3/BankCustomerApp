package com.sac.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sac.persistence.model.AppUserEntity;
import com.sac.persistence.model.AppUserRoleEntity;
import com.sac.persistence.model.AppUserRoleKey;

import java.util.List;

@Transactional
public interface AppUserRoleRepository extends JpaRepository<AppUserRoleEntity, AppUserRoleKey> {

    List<AppUserRoleEntity> findByKeyAppUser(AppUserEntity appUser);

}
