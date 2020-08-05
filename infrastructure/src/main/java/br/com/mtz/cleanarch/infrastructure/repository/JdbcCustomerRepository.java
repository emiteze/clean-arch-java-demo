package br.com.mtz.cleanarch.infrastructure.repository;

import br.com.mtz.cleanarch.domain.Customer;
import br.com.mtz.cleanarch.domain.Page;
import br.com.mtz.cleanarch.domain.PageRequest;
import br.com.mtz.cleanarch.domain.repository.CustomerRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Repository
public class JdbcCustomerRepository implements CustomerRepository {

    private JdbcTemplate jdbcTemplate;
    private CustomerExtractor customerExtractor;

    @Inject
    public JdbcCustomerRepository(
        JdbcTemplate jdbcTemplate,
        CustomerExtractor customerExtractor
    ) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerExtractor = customerExtractor;
    }

    private static String BASE_QUERY = "SELECT id, name, birth_date, city, cpf FROM customers";

    @Override
    public Customer create(Customer customer) {
        String statement = "INSERT INTO customers VALUES (?, ?, ?, ?, ?)";
        this.jdbcTemplate.update(statement, customer.getId(), customer.getName(), customer.getBirthDate(), customer.getCity(), customer.getCpf());
        return find(customer.getId()).get();
    }

    @Override
    public Customer update(Customer customer) {
        String statement = "UPDATE customers SET name = ?, city = ? WHERE id = ?";

        this.jdbcTemplate.update(
            statement,
            customer.getName(),
            customer.getCity(),
            customer.getId()
        );

        return find(customer.getId()).get();
    }

    @Override
    public Optional<Customer> find(String id) {
        StringBuilder statement = new StringBuilder(BASE_QUERY)
                .append(" WHERE id = ?");
        return this.jdbcTemplate.query(statement.toString(), new String[] {id}, customerExtractor).stream().findFirst();
    }

    @Override
    public Page<Customer> find(PageRequest page) {
        StringBuilder statement = new StringBuilder(BASE_QUERY)
                .append(" LIMIT ?")
                .append(" OFFSET ?");

        ArrayList<Integer> arguments = new ArrayList<>();
        arguments.add(page.getSize());
        arguments.add(page.offset());

        Set<Customer> customers = this.jdbcTemplate.query(statement.toString(), arguments.toArray(), customerExtractor);

        return new Page(
            collectList(customers),
            page.getPage(),
            page.getSize(),
            executeCountQuery()
        );
    }

    @Override
    public void delete(Customer customer) {
        String countStatement = "DELETE FROM customers WHERE id = ?";
        this.jdbcTemplate.update(countStatement, customer.getId());
    }

    private List<Customer> collectList(Set<Customer> customers) {
        if(customers.isEmpty()) return emptyList();
        else return customers.stream().collect(Collectors.toList());
    }

    private Integer executeCountQuery() {
        String countStatement = "SELECT count(*) AS total FROM customers";
        return this.jdbcTemplate.queryForObject(countStatement, Integer.class);
    }

}
