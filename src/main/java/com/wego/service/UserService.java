package com.wego.service;

import com.wego.common.base.BaseService;
import com.wego.dao.UserDao;
import com.wego.dto.UserDto;
import com.wego.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 *
 * @author caoyn
 * @date 2020/4/9
 */

@Service
@Transactional(readOnly = true)
public class UserService extends BaseService<UserDao, User>  {

    public List<UserDto> listUser() {
        List<User> list = dao.listUser();
        return UserDto.ofEntitys(list);
    }


}
