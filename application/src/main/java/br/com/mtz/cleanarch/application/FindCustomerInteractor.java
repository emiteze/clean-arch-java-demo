package br.com.mtz.cleanarch.application;

import br.com.mtz.cleanarch.application.response.CustomerResponse;

public interface FindCustomerInteractor {

    CustomerResponse execute(String id);

}
