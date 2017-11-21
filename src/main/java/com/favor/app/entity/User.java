package com.favor.app.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User implements UserDetails, Serializable {
    private static final Logger logger = LoggerFactory.getLogger(User.class);

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "usrid", length = 128)
    private String usrId;

    @Column(name = "loginid", length = 32, nullable = false, unique = true)
    private String loginId;

    @Column(name = "password", length = 256, nullable = false)
    private String password;

    @Column(name = "isaccountnonexpired", nullable = true)
    private boolean isAccountNonExpired;

    @Column(name = "isaccountnonlocked", nullable = true)
    private boolean isAccountNonLocked;

    @Column(name = "iscredentialsnonexpired", nullable = true)
    private boolean isCredentialsNonExpired;

    @Column(name = "isenabled", nullable = true)
    private boolean isEnabled;

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return loginId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }
}
