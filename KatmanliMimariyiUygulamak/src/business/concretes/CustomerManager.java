package business.concretes;

import business.abstracts.ICustomerService;
import dao.abstracts.ICustomerDao;
import entities.Customer;

// business layer
// Veri tabanında bu customer mail adresi daha önce eklenmiş mi?  (bu aşamada sorgulanır)
public class CustomerManager implements ICustomerService {    // dao'ya ihtiyacı var ,iletişime geçecek

  private final ICustomerDao customerDao;  // hangi veritabanını kullanacağımızı seçebilmek için bu şekilde tanımlandı

    public CustomerManager(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public boolean save(Customer customer){
        System.out.println("Business katmanı çalıştı");
        return customerDao.saveCustomer(customer);  // dao'dan gelen savCustomer metodu
    }

    public Customer getById(int id){
        Customer customer = this.customerDao.getById(id);
        customer.setMail("te.....@pa.....");
        return customer;
    }
/*   private CustomerHibernateDao customerDao = new CustomerHibernateDao();

   public boolean save(Customer customer){
       System.out.println("Business katmanı çalıştı");
       return this.customerDao.save(customer);

   }
   public Customer getById( int id){
       return this.customerDao.findById(id);

   }*/

}
