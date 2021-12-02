package com.example.pet_out.model;

import java.io.Serializable;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Usuario implements Serializable {

    private String name,lastname,email,phone,id;




    public Usuario(String name, String lastname, String email, String phone) {
        this.id=id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;

    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
