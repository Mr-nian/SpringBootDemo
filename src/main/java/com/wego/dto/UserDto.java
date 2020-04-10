package com.wego.dto;

import com.wego.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户实体dto
 *
 * @author caoyn
 * @date 2020/4/9
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    /**
     * id
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 封装实体dto
     * @param user
     * @return
     */
    public static UserDto ofEntity(User user){
        UserDto userDto = new UserDto();
        if (user == null) {
            return userDto;
        }
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    /**
     * 封装实体dtos
     * @param list
     * @return
     */
    public static List<UserDto> ofEntitys(List<User> list){
        List<UserDto> listDto = new ArrayList<UserDto>();
        if (list == null || list.isEmpty()) {
            return listDto;
        }
        for (User user : list) {
            UserDto userDto = ofEntity(user);
            listDto.add(userDto);
        }
        return listDto;
    }

}
