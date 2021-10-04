package br.com.orlandoburli.customers;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class CustomerStarter {

  private final CustomerRepository customerRepository;

  public CustomerStarter(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @PostConstruct
  public void dataSetup() {
    this.customerRepository.save(createCustomer("Jon", "Doe", "+55 31 7778-6130"));
    this.customerRepository.save(createCustomer("Mary", "Jane", "+55 24 7223-8745"));
    this.customerRepository.save(createCustomer("Peter", "Parker", "+55 98 96518-3030"));
    this.customerRepository.save(createCustomer("Tony", "Stark", "+55 62 95327-0036"));
  }

  private Customer createCustomer(String firstName, String lastName, String phone) {
    return new Customer(firstName, lastName, phone);
  }
}
