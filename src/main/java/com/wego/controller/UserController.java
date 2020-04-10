package com.wego.controller;

import com.wego.common.base.BaseController;
import com.wego.common.exception.BusinessException;
import com.wego.common.result.ResultVO;
import com.wego.dto.UserDto;
import com.wego.entity.User;
import com.wego.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(description = "用户模块")
@Slf4j
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询单个用户详情", response = ResultVO.class)
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public ResultVO<?> getUserById(@RequestParam(value = "id") String id) {
        User user = userService.get(id);
        UserDto userDto = UserDto.ofEntity(user);
        return new ResultVO<>(userDto);
    }

    @ApiOperation(value = "查询用户列表", response = ResultVO.class)
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultVO<?> listUser() {
        List<UserDto> list = userService.listUser();
        return new ResultVO<>(ResultVO.SUCCESS, ResultVO.SUCCESS_MSG, list);
    }

    @ApiOperation(value = "新增用户", response = ResultVO.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultVO<?> addUser(@RequestBody User user) {
        if(userService.save(user) > 0){
            return new ResultVO<>(ResultVO.SUCCESS, ResultVO.SUCCESS_MSG);
        } else {
            throw new BusinessException("新增用户失败！");
        }

    }

    @ApiOperation(value = "修改用户", response = ResultVO.class)
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultVO<?> updateUser(@RequestBody User user) {
        userService.update(user);
        return new ResultVO<>(ResultVO.SUCCESS, ResultVO.SUCCESS_MSG);
    }


    @ApiOperation(value = "删除用户", response = ResultVO.class)
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResultVO<?> deleteUser(@RequestParam(value = "id") String id) {
        userService.delete(id);
        return new ResultVO<>(ResultVO.SUCCESS, ResultVO.SUCCESS_MSG);
    }


}
