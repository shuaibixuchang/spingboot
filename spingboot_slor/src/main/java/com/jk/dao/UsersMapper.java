package com.jk.dao;

import com.jk.model.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}