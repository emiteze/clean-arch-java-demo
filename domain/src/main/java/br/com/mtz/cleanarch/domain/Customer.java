package br.com.mtz.cleanarch.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Customer {

    private String id;
    private String name;
    private LocalDate birthDate;
    private String city;
    private String cpf;

    public Customer(String id, String name, LocalDate birthDate, String city, String cpf) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.city = city;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) &&
                name.equals(customer.name) &&
                birthDate.equals(customer.birthDate) &&
                city.equals(customer.city) &&
                cpf.equals(customer.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, city, cpf);
    }

}
