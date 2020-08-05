package br.com.mtz.cleanarch.application.request;

import br.com.mtz.cleanarch.domain.Customer;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.UUID;

public class CreateCustomerRequest {

    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    private String city;
    private String cpf;

    public CreateCustomerRequest(String name, LocalDate birthDate, String city, String cpf) {
        this.name = name;
        this.birthDate = birthDate;
        this.city = city;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer calculateAge() {
        return LocalDate.now().getYear() - this.birthDate.getYear();
    }

    public Customer toDomain() {
        return new Customer(UUID.randomUUID().toString(), this.name, this.birthDate, this.city, this.cpf);
    }

}
