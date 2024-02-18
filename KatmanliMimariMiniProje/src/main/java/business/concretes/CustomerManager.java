package business.concretes;

import business.abstracts.IcustomerService;
import dao.abstracts.ICustomerDao;
import entities.Customer;

import java.util.List;

public class CustomerManager implements IcustomerService {
    private final ICustomerDao customerDao;

    // Dependency injection
    public CustomerManager(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        Customer checkMailCustomer = this.customerDao.findBymail(customer.getMail());
        if(checkMailCustomer != null){   // mail adresi daha önceden eklendiyse
            throw new RuntimeException(customer.getMail() + "bu e-posta adresi daha önce eklenmiş");
        }
        this.customerDao.save(customer);  // öncesinde yoksa kayıt işlemi yapar

    }

    @Override
    public Customer findById(int id) {  // id'ye göre veri çekme
        return this.customerDao.findById(id);
    }

    @Override
    public void update(Customer customer) {
         Customer checkMailCustomer = this.customerDao.findBymail(customer.getMail());
         if(checkMailCustomer != null && checkMailCustomer.getId() != customer.getId()){
             throw new RuntimeException(customer.getMail() + "bu e-posta adresi daha önce eklenmiş");
         }
        this.customerDao.update(customer);

    }

    @Override
    public void deleteById(int id) {
        Customer customer = this.findById(id); // id'ye göre veri silme işlemi
        this.customerDao.delete(customer);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerDao.findAll();
    }
}
