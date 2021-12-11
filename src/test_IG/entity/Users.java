package test_IG.entity;

import java.util.Arrays;

public class Users {
    private String firstName;
    private String lastName;
    private String email;
    private Roles[] roles;
    private String[] mobilePhones;

    public Users() {
    }

    public Users(String firstName, String lastName, String email, Roles[] roles, String[] mobilePhones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
        this.mobilePhones = mobilePhones;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles[] getRoles() {
        return roles;
    }

    public void setRoles(Roles[] roles) {
        this.roles = roles;
    }

    public String[] getMobilePhones() {
        return mobilePhones;
    }

    public void setMobilePhones(String[] mobilePhones) {
        this.mobilePhones = mobilePhones;
    }

    @Override
    public String toString() {
        return "Users{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + Arrays.toString(roles) +
                ", mobilePhones=" + Arrays.toString(mobilePhones) +
                '}'+ '\n';
    }
}