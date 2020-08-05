package br.com.mtz.cleanarch.application;

import br.com.mtz.cleanarch.application.response.CustomerResponse;
import br.com.mtz.cleanarch.application.response.PageResponse;
import br.com.mtz.cleanarch.domain.PageRequest;

public interface FindAllCustomersInteractor {

    PageResponse<CustomerResponse> execute(PageRequest pageRequest);

}
