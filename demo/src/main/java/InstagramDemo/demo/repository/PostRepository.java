package InstagramDemo.demo.repository;

import InstagramDemo.demo.models.Post;
import InstagramDemo.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    //List<Post> findByUser(User user);



}
