package view;

import business.concretes.CustomerManager;
import dao.concretes.CustomerJdbcDao;
import entities.Customer;
//Presentation Layer   - presentation katmanı business'la iltişime geçtiği için business'ta customer oluşturulur
public class App {
    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setMail("test@patika.dev");
        customer.setName("Test");
        

        // Bağımlılığı dışardan yönetme işlemine Dependency Injection denir
        CustomerManager customerManager = new CustomerManager(new CustomerJdbcDao());  // Jdbc katmanını çalıştırdık
        customerManager.save(customer);                     // new CustomerHibernateDao()'da yazabiliriz, bu sefer Hibernate çalışır.


        Customer test = customerManager.getById(1);
        System.out.println(test);


    }
}
