package br.com.mtz.cleanarch.application.impl;

import br.com.mtz.cleanarch.application.FindCustomerInteractor;
import br.com.mtz.cleanarch.application.response.CustomerResponse;
import br.com.mtz.cleanarch.domain.Customer;
import br.com.mtz.cleanarch.domain.exception.NotFoundException;
import br.com.mtz.cleanarch.domain.repository.CustomerRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class FindCustomerInteractorImpl implements FindCustomerInteractor {

    private CustomerRepository customerRepository;

    @Inject
    public FindCustomerInteractorImpl(
        CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse execute(String id) {
        Customer customer = customerRepository.find(id).orElseThrow(() -> new NotFoundException("customer", id));
        return CustomerResponse.from(customer);
    }

}
