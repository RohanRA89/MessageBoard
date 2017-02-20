package com.ironyard.repo;

import com.ironyard.data.Thread;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by rohanayub on 2/9/17.
 */
public interface ThreadRepo extends PagingAndSortingRepository<Thread, Long> {
}
