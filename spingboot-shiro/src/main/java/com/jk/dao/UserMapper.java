package com.jk.dao;

import com.jk.model.User;

public interface UserMapper {

    User queryUserByName(String username);

}
