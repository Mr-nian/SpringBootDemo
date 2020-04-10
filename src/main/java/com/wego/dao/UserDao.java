package com.wego.dao;

import com.wego.common.base.BaseDao;
import com.wego.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author caoyn
 * Date  2020/4/9
 */
@Mapper
public interface UserDao extends BaseDao<User> {
    /**
     * 用户列表查询
     * @return
     */
    List<User> listUser();

}