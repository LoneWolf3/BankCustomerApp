package com.sac.persistence.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sac.model.AppUserRole;
import com.sac.model.UserRole;

@Entity
@Table(name = "app_user_role")
public class AppUserRoleEntity implements AppUserRole {

    @EmbeddedId
    private AppUserRoleKey key;

    @Override
    public UserRole getRole() {
        return key.getRole();
    }

    @Override
    public void setRole(UserRole role) {
        this.key.setRole(role);
    }

    public AppUserEntity getAppUser() {
        return key.getAppUser();
    }

    public void setAppUser(AppUserEntity appUser) {
        this.key.setAppUser(appUser);
    }
}
