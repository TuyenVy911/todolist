package InstagramDemo.demo.controllers;

import InstagramDemo.demo.models.User;
import InstagramDemo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//http://localhost:9090/instagram/user/register
@RestController
@RequestMapping("/instagram")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //getAllUsers http://localhost:9090/instagram/user
    @GetMapping("/user")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    //find by id
    @GetMapping("/user/{id}")
    public Optional<User> findById(@PathVariable int id){
        return userRepository.findById(id);
    }


    @PostMapping("/user/register")
    public User register(@RequestBody User user){
        return userRepository.save(user);
    }


    @GetMapping("/user/login")
    public User login(@RequestParam("username") String username, @RequestParam("password") String password){
        return (User) userRepository.findByUsernameAndPassword(username, password);
    }


}
