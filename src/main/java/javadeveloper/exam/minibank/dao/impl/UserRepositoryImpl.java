package javadeveloper.exam.minibank.dao.impl;

import javadeveloper.exam.minibank.dao.UserRepository;
import javadeveloper.exam.minibank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final String CREATE_USER="INSERT INTO USERS(FIRSTNAME,LASTNAME,PASSWORD,BALANCE) VALUES " +
            "(?,?,?,?)";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(User user) {
        jdbcTemplate.update(connection ->{
            PreparedStatement ps = connection.prepareStatement(CREATE_USER);
            ps.setString(1,user.getFirstname());
            ps.setString(2,user.getLastname());
            ps.setString(3,user.getPassword());
            ps.setBigDecimal(4,user.getBalance());
            return ps;
        });
        System.out.println(">>>>>>InsertUser Success<<<<<<");
    }


}
