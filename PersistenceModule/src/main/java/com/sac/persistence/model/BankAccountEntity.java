package com.sac.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sac.model.BankAccount;

@Entity
@Table(name = "bank_account")
public class BankAccountEntity implements BankAccount<AppUserEntity> {

    @Id
    @Column(name = "iban")
    private String iban;

    @Column(name = "bic")
    private String bic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_username")
    private AppUserEntity appUser;

    public BankAccountEntity() {
        super();
    }

    public BankAccountEntity(String iban, String bic, AppUserEntity appUser) {
        this.iban = iban;
        this.bic = bic;
        this.appUser = appUser;
    }

    @Override
    public String getIban() {
        return iban;
    }

    @Override
    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String getBic() {
        return bic;
    }

    @Override
    public void setBic(String bic) {
        this.bic = bic;
    }

    public AppUserEntity getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUserEntity appUser) {
        this.appUser = appUser;
    }
}
