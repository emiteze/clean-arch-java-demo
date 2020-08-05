package br.com.mtz.cleanarch.application;

import br.com.mtz.cleanarch.application.request.UpdateCustomerRequest;
import br.com.mtz.cleanarch.application.response.CustomerResponse;

public interface UpdateCustomerInteractor {

    CustomerResponse execute(String id, UpdateCustomerRequest request);

}
