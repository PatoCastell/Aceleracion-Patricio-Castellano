package com.alkemy.disney.auth.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Email
    private String username;
    @Size(min=8)
    private String password;

    private boolean accounNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public UserEntity(){
        this.accounNonExpired=true;
        this.accountNonLocked=true;
        this.credentialsNonExpired=true;
        this.enabled=true;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){this.id=id;}


    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password){
        this.password=password;
    }
}
