package dev.patika.spring.dto;

import dev.patika.spring.entities.Customer;

public class CustomerSaveRequest {

    private String name;
    private  String mail;
    private Customer.Gender gender;

   public CustomerSaveRequest() {
    }

    public CustomerSaveRequest( String name, String mail, Customer.Gender gender) {
        this.name = name;
        this.mail = mail;
        this.gender = gender;
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
        return "CustomerSaveRequest{" +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", gender=" + gender +
                '}';
    }
}
