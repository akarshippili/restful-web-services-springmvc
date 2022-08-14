package com.akarsh.restwebservices.dao.repo;


import com.akarsh.restwebservices.dao.entity.Post;
import com.akarsh.restwebservices.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
    public List<Post> getPostsByUserId(long userId);
    public Post getPostById(long postId);
    public Post save(Post post);
}
