package dao.concretes;

import dao.abstracts.ICustomerDao;
import entities.Customer;
// Data Access Layer
// Sadece veritabanı işlemleri var
public class CustomerJdbcDao implements ICustomerDao {

    public boolean saveCustomer(Customer customer){
        System.out.println("JDBC Dao katmanı çalıştı");
        System.out.println("Customer veritabanına eklendi");
        return true;
    }
    public Customer getById(int id){
        System.out.println("JDBC Dao katmanı çalıştı");
        System.out.println("Customer veritabanından çekildi");
        return new Customer();
    }
}
