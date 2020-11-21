package com.ynov.nantes.soap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ynov.nantes.soap.config.WebSecurityConfig;

/**
 * Entité Auteur persistente en base de données.
 * 
 * @author Matthieu BACHELIER
 * @since 2020-10
 * @version 1.0
 */
@Entity
@Table(name = "user")
public class User {
    

    @Autowired
    @Transient
    private WebSecurityConfig webSecurityConfig = new WebSecurityConfig();
    
    @Transient
    private PasswordEncoder passwordEncoder = webSecurityConfig.passwordEncoder();
    
    @Id
    @Column (name = "email")
    private String email;
    
    @Column (name = "password")
    private String password;
    
    @Column (name = "pseudo")
    private String pseudo;
    
    
    @Column (name = "avatar")
    private String avatar;
    
    @JsonInclude()
    @Transient
    private boolean isAdmin = false;
    
    @JsonInclude()
    @Transient
    private String token = "";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = passwordEncoder.encode(password);
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}