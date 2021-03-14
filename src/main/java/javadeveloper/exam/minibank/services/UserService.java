package javadeveloper.exam.minibank.services;

import javadeveloper.exam.minibank.model.User;

public interface UserService {
    User registerUser(String firstName, String lastName, String password, String balance);
}
