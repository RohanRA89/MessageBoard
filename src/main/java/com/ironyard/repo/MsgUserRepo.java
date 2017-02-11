package com.ironyard.repo;

import com.ironyard.data.MsgBoardUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rohanayub on 2/9/17.
 */
public interface MsgUserRepo extends CrudRepository<MsgBoardUser,Long>{
    public MsgBoardUser findByDisplayNameAndPassword(String displayName, String password);


}
