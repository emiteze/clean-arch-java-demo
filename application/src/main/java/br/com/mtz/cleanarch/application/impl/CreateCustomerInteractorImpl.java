package br.com.mtz.cleanarch.application.impl;

import br.com.mtz.cleanarch.application.CreateCustomerInteractor;
import br.com.mtz.cleanarch.application.request.CreateCustomerRequest;
import br.com.mtz.cleanarch.application.response.CustomerResponse;
import br.com.mtz.cleanarch.domain.Customer;
import br.com.mtz.cleanarch.domain.repository.CustomerRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CreateCustomerInteractorImpl implements CreateCustomerInteractor {

    private CustomerRepository customerRepository;

    @Inject
    public CreateCustomerInteractorImpl(
        CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse execute(CreateCustomerRequest request) {
        Customer customer = request.toDomain();
        return CustomerResponse.from(customerRepository.create(customer));
    }

}
