package br.com.mtz.cleanarch.application.impl;

import br.com.mtz.cleanarch.application.DeleteCustomerInteractor;
import br.com.mtz.cleanarch.domain.Customer;
import br.com.mtz.cleanarch.domain.exception.NotFoundException;
import br.com.mtz.cleanarch.domain.repository.CustomerRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DeleteCustomerInteractorImpl implements DeleteCustomerInteractor {

    private CustomerRepository customerRepository;

    @Inject
    public DeleteCustomerInteractorImpl(
        CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void execute(String id) {
        Customer customer = customerRepository.find(id).orElseThrow(() -> new NotFoundException("customer", id));
        customerRepository.delete(customer);
    }

}
