package com.webedu.springmngdb.services;

import com.webedu.springmngdb.domain.Post;
import com.webedu.springmngdb.repository.PostRepository;
import com.webedu.springmngdb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitle(text);
    }
}