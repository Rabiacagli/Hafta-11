package view;

import business.concretes.CustomerManager;
import dao.concretes.CustomerDao;
import entities.Customer;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager(new CustomerDao());

        // veri ekleme
      /*  Customer customer = new Customer();
        customer.setName("Spring dersleri");
        customer.setMail("info@patika.dev");
        customer.setGender(Customer.GENDER.MALE);
        customer.setOnDate(LocalDate.now());  */


     /*  Customer customer = new Customer();
        customer.setName("Test dersleri");
        customer.setMail("test@patika.dev");
        customer.setGender(Customer.GENDER.FEMALE);
        customer.setOnDate(LocalDate.now());

        customerManager.save(customer);*/

        // id'ye göre veriyi gösterme
    /*    Customer firstCustomer = customerManager.findById(1);
        System.out.println(firstCustomer.toString()); */


        // veri silme
     //   customerManager.deleteById(2);


      /*  // update metodu
        Customer customer = customerManager.findById(1);
        customer.setName("Update test");
        customerManager.update(customer);*/

        List<Customer> customerList = customerManager.findAll();
        System.out.println(customerList.toString());
    }
}
