package dev.patika.spring.dto; // DTO (Response) lar sayesinde görmek istediğimiz verileri özelleştiriyoruz

// pojo class

import dev.patika.spring.entities.Customer;


// Customer nesnesini CustomerDto'ya çeviriyoruz
public class CustomerResponse {
    private int id;
    private String name;
    private  String mail;
    private Customer.Gender gender;

    public CustomerResponse() {
    }

    public CustomerResponse(int id, String name, String mail , Customer.Gender gender){
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public Customer.Gender getGender() {
        return gender;
    }

    public void setGender(Customer.Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", gender=" + gender +
                '}';
    }
}
