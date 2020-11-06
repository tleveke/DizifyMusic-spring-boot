package com.ynov.nantes.soap.entity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Administrateur {

    @OneToOne
    @JoinColumn(name = "emailUser")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
