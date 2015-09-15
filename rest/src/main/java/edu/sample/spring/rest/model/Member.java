package edu.sample.spring.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Kafeilab on 9/15/15.
 */
@XmlRootElement
public class Member {

    private String name;
    private String phone;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
