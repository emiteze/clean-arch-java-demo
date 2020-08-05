package br.com.mtz.cleanarch.infrastructure.service.client.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerScoreResponse {

    private CustomerScoreStatusEnum status;

    @JsonCreator
    public CustomerScoreResponse(@JsonProperty("status") CustomerScoreStatusEnum status) {
        this.status = status;
    }

    public CustomerScoreStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CustomerScoreStatusEnum status) {
        this.status = status;
    }
}
