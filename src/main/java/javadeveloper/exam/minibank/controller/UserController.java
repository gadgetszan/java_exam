package javadeveloper.exam.minibank.controller;

import javadeveloper.exam.minibank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(HttpServletRequest request,
                                            @RequestBody Map<String,Object> userMap){
        System.out.println("Executing Register API");
        String firstName =(String) userMap.get("firstname");
        String lastName =(String) userMap.get("lastname");
        String password =(String) userMap.get("password");
        String balance = (String) userMap.get("balance");
        System.out.println("Firstname: " + firstName + " Balance: " + balance);
        userService.registerUser(firstName,lastName,password,balance);
        return new ResponseEntity<>(firstName,HttpStatus.OK);
    };
}


