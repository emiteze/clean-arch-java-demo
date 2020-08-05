package br.com.mtz.cleanarch.infrastructure.service.client;

import br.com.mtz.cleanarch.infrastructure.service.client.request.CustomerScoreRequest;
import br.com.mtz.cleanarch.infrastructure.service.client.response.CustomerScoreResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "customerScoreClient", url = "${customer.score.url}")
public interface CustomerScoreClient {

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(
        path = "/serasa",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    CustomerScoreResponse queryScore(@RequestBody CustomerScoreRequest request);

}
