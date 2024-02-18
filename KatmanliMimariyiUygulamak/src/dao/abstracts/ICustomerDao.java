package dao.abstracts;

import entities.Customer;

// customer daolara kullanacakları metodların bir şablonunu çıkartıyor
// keskin kurallar oluşturuyoruz
// jdbc ve hibernate daoları implement etmeli ve bu metodları kullanmalı
public interface ICustomerDao {
    boolean saveCustomer(Customer customer);

    Customer getById(int id);
}
