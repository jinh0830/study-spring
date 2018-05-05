package examples.boot.myboard.controller.api;

import examples.boot.myboard.domain.User;
import examples.boot.myboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserApiController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> list = userService.getUsers();

        return new ResponseEntity(list , HttpStatus.OK);
    }
}
