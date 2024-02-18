package dev.patika.spring.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "customers")

// LOMBOK eklentisi sayesinde kullanabildiklerimizden birkaçı

//@Getter    // projeye otomatik olarak Getter metodlarını ekler

//@Setter   // projeye otomatik olarak Setter metodlarını ekler

//@ToString  // projeye otomatik olarak ToString  metodlarını ekler
//@Data
//@NoArgsConstructor  // içi boş Constructor gelir
//@AllArgsConstructor   // tüm değerlerin olduğu Constructor gelir    @Data ile de içi dolu Constructor dışında hepsini yazabiliriz
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id" , columnDefinition = "serial")
    private int id; // customer_id

    @Column(name = "customer_name" , length = 100, nullable = false)
    @NotNull // validation
    private String name; // customer_name

    @Column(name = "customer_mail", unique = true, nullable = false)
    @Email (message = "Lütfen geçerli bir e posta adresi giriniz")  // Validation , kotrol saglar
    private  String mail;


    @Temporal(TemporalType.DATE)
    @Column(name = "customer_on_date")
    private LocalDate onDate;


    @Enumerated(EnumType.STRING)
    @Column(name = "customer_gender")
    private Gender gender;
    public enum Gender{
        MALE,
        FEMALE
    }


    public Customer() {
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

    public LocalDate getOnDate() {
        return onDate;
    }

    public void setOnDate(LocalDate onDate) {
        this.onDate = onDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", onDate=" + onDate +
                ", gender=" + gender +
                '}';
    }
}
