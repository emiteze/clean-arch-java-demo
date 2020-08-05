package br.com.mtz.cleanarch.application.impl;

import br.com.mtz.cleanarch.application.UpdateCustomerInteractor;
import br.com.mtz.cleanarch.application.request.UpdateCustomerRequest;
import br.com.mtz.cleanarch.application.response.CustomerResponse;
import br.com.mtz.cleanarch.domain.Customer;
import br.com.mtz.cleanarch.domain.exception.NotFoundException;
import br.com.mtz.cleanarch.domain.repository.CustomerRepository;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UpdateCustomerInteractorImpl implements UpdateCustomerInteractor {

    private CustomerRepository customerRepository;

    @Inject
    public UpdateCustomerInteractorImpl(
        CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse execute(String id, UpdateCustomerRequest request) {
        Customer customer = customerRepository.find(id).orElseThrow(() -> new NotFoundException("customer", id));
        Customer updatedCustomer = new Customer(
            customer.getId(),
            request.getName(),
            customer.getBirthDate(),
            request.getCity(),
            customer.getCpf()
        );
        customerRepository.update(updatedCustomer);
        return CustomerResponse.from(updatedCustomer);
    }

}
