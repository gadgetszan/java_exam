package javadeveloper.exam.minibank.services.impl;

import javadeveloper.exam.minibank.dao.UserRepository;
import javadeveloper.exam.minibank.model.User;
import javadeveloper.exam.minibank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(String firstName, String lastName, String password, String balance) {
        User user = new User(firstName,lastName,password, new BigDecimal(balance));
        userRepository.createUser(user);
        System.out.println("performing user service");
        return null;
    }
}
