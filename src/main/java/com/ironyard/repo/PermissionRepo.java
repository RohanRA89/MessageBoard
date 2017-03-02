package com.ironyard.repo;

import com.ironyard.data.Permissions;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rohanayub on 2/27/17.
 */
public interface PermissionRepo extends CrudRepository<Permissions, Long> {
    public Permissions findBykey(String key);
}
