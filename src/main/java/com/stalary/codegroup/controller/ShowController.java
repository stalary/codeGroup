package com.stalary.codegroup.controller;

import com.stalary.codegroup.entity.Admin;
import com.stalary.codegroup.entity.Rank;
import com.stalary.codegroup.entity.User;
import com.stalary.codegroup.service.AdminService;
import com.stalary.codegroup.service.RankService;
import com.stalary.codegroup.service.UserService;
import com.stalary.codegroup.utils.WebUtils;
import com.stalary.codegroup.viewmodel.ApiResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:Stalary
 * @Description:展示信息时调用
 * @Date Created in 2017/8/24
 */
@RestController
@RequestMapping(value = "show")
public class ShowController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private RankService rankService;

    @ApiOperation(value = "展示用户信息时调用，需要传入排序的类型 1 按照rank积分排序 2 按照注册日期排序")
    @RequestMapping(value = "/showUserList",method = RequestMethod.POST)
    public ApiResult showUserList(Integer type) {
        if(1 == type) {
            List<User> userList = userService.sortByRank();//通过rank排序
            if(null == userList || 0 == userList.size()) {
                return ApiResult.ok("无用户");
            }
            return ApiResult.ok(userList);
        } else if(2 == type) {
            List<User> userList = userService.sortByRegisterTime();//通过注册日期排序
            if(null == userList || 0 == userList.size()) {
                return ApiResult.ok("无用户");
            }
            return ApiResult.ok(userList);
        } else {
            return ApiResult.error("传入类型错误");
        }
    }

    @ApiOperation(value = "展示管理员列表,按照职位排序")
    @RequestMapping(value = "/showAdminList",method = RequestMethod.POST)
    public ApiResult showAdminList() {
        List<Admin> adminList = adminService.sortByPositionAndYear();
        if(null == adminList || 0 == adminList.size()) {
            return ApiResult.ok("无管理员");
        }
        return ApiResult.ok(adminList);
    }

    @ApiOperation(value = "展示用户信息")
    @RequestMapping(value = "/showOneUser",method = RequestMethod.POST)
    public ApiResult showOneUser() {
        Integer keyId = WebUtils.getLoginUserId();
        User user = userService.findByKeyId(keyId);
        if(null == user) {
            return ApiResult.error("用户不存在");
        }
        return ApiResult.ok(user);
    }

    @ApiOperation(value = "展示管理员信息")
    @RequestMapping(value = "/showOneAdmin",method = RequestMethod.POST)
    public ApiResult showOneAdmin() {
        Integer keyId = WebUtils.getLoginUserId();
        Admin admin = adminService.findByKeyId(keyId);
        if(null == admin) {
            return ApiResult.error("用户不存在");
        }
        return ApiResult.ok(admin);
    }

    @ApiOperation(value = "展示用户的积分记录，需要传入用户的keyId")
    @RequestMapping(value = "/showRank",method = RequestMethod.POST)
    public ApiResult showRank(Integer keyId) {
        List<Rank> rankList = rankService.findByUserKeyId(keyId);
        if(null == rankList || 0 == rankList.size()) {
            return ApiResult.ok("无积分列表");
        }
        return ApiResult.ok(rankList);
    }
}
