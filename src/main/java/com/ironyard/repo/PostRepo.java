package com.ironyard.repo;

import com.ironyard.data.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rohanayub on 2/9/17.
 */
public interface PostRepo extends CrudRepository<Post,Long> {
}
