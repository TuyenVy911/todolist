package InstagramDemo.demo.controllers;

import InstagramDemo.demo.models.Post;
import InstagramDemo.demo.models.User;
import InstagramDemo.demo.repository.PostRepository;
import InstagramDemo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instagram/post")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    @PostMapping("/add")
    public Post add(@RequestBody Post post){
        return postRepository.save(post);
    }


//    @GetMapping("/user")
//    public List<Post> getAllPostByUserId(@RequestBody User user){
//        return postRepository.findByUser(user);
//    }

}
