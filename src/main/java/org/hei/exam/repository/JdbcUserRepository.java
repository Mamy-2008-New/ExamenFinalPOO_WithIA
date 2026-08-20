package org.hei.exam.repository;

import org.hei.exam.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcUserRepository implements UserRepository {

    private static final RowMapper<User> USER_ROW_MAPPER = (rs, rowNum) -> new User(
            rs.getString("id"),
            rs.getString("ref"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("email"),
            rs.getString("phone")
    );

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findById(String id) {
        List<User> results = jdbcTemplate.query(
                "SELECT id, ref, first_name, last_name, email, phone FROM \"user\" WHERE id = ?",
                USER_ROW_MAPPER, id
        );
        return results.stream().findFirst();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
                "SELECT id, ref, first_name, last_name, email, phone FROM \"user\"",
                USER_ROW_MAPPER
        );
    }
}
