package br.com.mtz.cleanarch.application;

import br.com.mtz.cleanarch.application.request.CreateCustomerRequest;
import br.com.mtz.cleanarch.application.response.CustomerResponse;

public interface CreateCustomerInteractor {

    CustomerResponse execute(CreateCustomerRequest request);

}
