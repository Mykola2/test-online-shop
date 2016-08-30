package ua.nickoh.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
public class User implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "phone_num")
    private String phone_num;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    private String role = "ROLE_USER";

    protected User() {

    }

    public User(String first_name, String last_name, String email, String phone_num, String password, String role) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_num = phone_num;
        this.password = password;
        this.role = role;
    }

    public Integer getId_user() {
        return id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}


