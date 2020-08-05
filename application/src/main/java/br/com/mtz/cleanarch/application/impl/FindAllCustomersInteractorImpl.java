package br.com.mtz.cleanarch.application.impl;

import br.com.mtz.cleanarch.application.FindAllCustomersInteractor;
import br.com.mtz.cleanarch.application.response.CustomerResponse;
import br.com.mtz.cleanarch.application.response.PageResponse;
import br.com.mtz.cleanarch.domain.Customer;
import br.com.mtz.cleanarch.domain.Page;
import br.com.mtz.cleanarch.domain.PageRequest;
import br.com.mtz.cleanarch.domain.repository.CustomerRepository;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.stream.Collectors;

@Named
public class FindAllCustomersInteractorImpl implements FindAllCustomersInteractor {

    private CustomerRepository customerRepository;

    @Inject
    public FindAllCustomersInteractorImpl(
        CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Override
    public PageResponse<CustomerResponse> execute(PageRequest pageRequest) {
        return convert(customerRepository.find(pageRequest));
    }

    private PageResponse<CustomerResponse> convert(Page<Customer> customers) {
        return new PageResponse<>(
            customers.getContent().stream().map(CustomerResponse::from).collect(Collectors.toList()),
            customers.getPageNumber(),
            customers.size(),
            customers.isLast(),
            customers.totalPages()
        );
    }

}
