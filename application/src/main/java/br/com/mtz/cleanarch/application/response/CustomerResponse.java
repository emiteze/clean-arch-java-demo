package br.com.mtz.cleanarch.application.response;

import br.com.mtz.cleanarch.domain.Customer;

import java.time.LocalDate;

public class CustomerResponse {

    private String id;
    private String name;
    private LocalDate birthDate;
    private String city;

    public CustomerResponse(String id, String name, LocalDate birthDate, String city) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public static CustomerResponse from(Customer customer) {
        return new CustomerResponse(
            customer.getId(),
            customer.getName(),
            customer.getBirthDate(),
            customer.getCity()
        );
    }

}
