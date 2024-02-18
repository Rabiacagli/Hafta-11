package dev.patika.spring.api;

import dev.patika.spring.entities.Customer;
import dev.patika.spring.business.abstracts.ICustomerService;
import dev.patika.spring.dto.CustomerResponse;
import dev.patika.spring.dto.CustomerSaveRequest;
import dev.patika.spring.dto.CustomerUpdateRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class CustomerController {
    @Autowired // bağımlılık enjeksiyonu
    private ICustomerService customerService;

 /*   @Autowired
    private CustomerDtoConverter converter;*/

    @Autowired
    private ModelMapper modelMapper;

 /*   @GetMapping("/customers") //verileri listeleme
    @ResponseStatus(HttpStatus.OK)  // http status belirtme, diğer statusleri de ekleyebiliriz
    public List<Customer> findAll(){
        return this.customerService.findAll();
    }*/


  /*  @GetMapping("/customers") //dto'ya göre verileri listeleme
    @ResponseStatus(HttpStatus.OK)  // http status belirtme, diğer statusleri de ekleyebiliriz
    public List<CustomerDto> findAll(){
        return this.customerService.findAll().stream().map(
                customer -> this.converter.convertDto(customer)
        ).collect(Collectors.toList());
    }*/


    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findAll(){
        List<CustomerResponse> customerDtoList = this.customerService.findAll().stream().map(
                customer -> this.modelMapper.map(customer, CustomerResponse.class) // neyi, neye .evireceğimiz
        ).collect(Collectors.toList());
       return customerDtoList;
    }


  /*  @PostMapping("/customers")  // postmapping kullandıgımızda  requestbody kullanmalıyız, json a çecırmesi için
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer){
        return this.customerService.save(customer);
    }*/

    @PostMapping("/customers")  // postmapping kullandıgımızda  requestbody kullanmalıyız, json a çecırmesi için
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody CustomerSaveRequest customerSaveRequest){
        Customer newCustomer = this.modelMapper.map(customerSaveRequest , Customer.class);
        newCustomer.setOnDate(LocalDate.now());
        return this.customerService.save(newCustomer);
    }

  /*  @PutMapping("/customers")  // putmapping kullandıgımızda  requestbody kullanmalıyız, json a çecırmesi için
    @ResponseStatus(HttpStatus.OK)
    public Customer update(@RequestBody Customer customer){
        return this.customerService.update(customer);
    }*/

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public Customer update(@RequestBody CustomerUpdateRequest customerUpdateRequest){
        Customer updatedCustomer = this.customerService.getById(customerUpdateRequest.getId());
        updatedCustomer.setName(customerUpdateRequest.getName());
        updatedCustomer.setGender(customerUpdateRequest.getGender());
        return this.customerService.update(updatedCustomer);

    }



    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable("id") int id){
        this.customerService.delete(id);
    }


/*    @GetMapping("/customers/{id}")  // tek ıd ye gore verı cekmek ıstersek
    @ResponseStatus(HttpStatus.OK)
    public Customer getById(@PathVariable("id") int id){
       return this.customerService.getById(id);
    }*/

 /*   @GetMapping("/customers/{id}")  // tek ıd ye gore verı cekmek ıstersek
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getById(@PathVariable("id") int id){
       return this.converter.convertDto(this.customerService.getById(id));

    }*/
}
/*

// NOT :  Customer entity'sini customerDto'ya donusturme  sınıf adına dıkkat et
@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private ModelMapper modelMapper;

  public CustomerDTO getCustomerById(Long customerId) {
    Optional<Customer> customerOptional = customerRepository.findById(customerId);

    if (customerOptional.isPresent()) {
      Customer customer = customerOptional.get();

      // Customer entity'sini CustomerDTO'ya dönüştürme
      CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);

      return customerDTO;
    }

    // Eğer müşteri bulunamazsa null dönebilir veya uygun bir hata yönetimi yapılabilir.
    return null;
  }
}*/
