package br.com.mtz.cleanarch.infrastructure;

import br.com.mtz.cleanarch.domain.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Component
public class CustomerExtractor implements ResultSetExtractor<Set<Customer>> {

    @Override
    public Set<Customer> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Set<Customer> customers = new HashSet<>();

        while (resultSet.next()) {
            customers.add(mapCustomer(resultSet));
        }

        return customers;
    }

    private Customer mapCustomer(ResultSet resultSet) throws SQLException {
        return new Customer(
                resultSet.getString("id"),
                resultSet.getString("name"),
                resultSet.getTimestamp("birth_date").toLocalDateTime().toLocalDate(),
                resultSet.getString("city"),
                resultSet.getString("cpf")
        );
    }

}
