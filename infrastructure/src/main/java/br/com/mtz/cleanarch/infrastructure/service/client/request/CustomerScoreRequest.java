package br.com.mtz.cleanarch.infrastructure.service.client.request;

public class CustomerScoreRequest {

    private String cpf;

    public CustomerScoreRequest(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
