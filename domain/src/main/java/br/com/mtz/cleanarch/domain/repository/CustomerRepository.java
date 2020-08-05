package br.com.mtz.cleanarch.domain.repository;

import br.com.mtz.cleanarch.domain.Customer;
import br.com.mtz.cleanarch.domain.Page;
import br.com.mtz.cleanarch.domain.PageRequest;

import java.util.Optional;

public interface CustomerRepository {

    Customer create(Customer customer);

    Customer update(Customer customer);

    Optional<Customer> find(String id);

    Page<Customer> find(PageRequest page);

    void delete(Customer customer);

}
