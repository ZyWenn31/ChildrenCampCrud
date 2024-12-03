package ru.sasha.trzbd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.sasha.trzbd.models.User;

@Component
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public User loginUser (User user1){
        User user = new User();
        user = jdbcTemplate.query("SELECT  * FROM users WHERE login=? AND password = ?",
                new Object[]{user1.getLogin(), user1.getPassword()},
                new BeanPropertyRowMapper<>(User.class)).stream().findAny().orElse(null);
        return user;
    }
}
