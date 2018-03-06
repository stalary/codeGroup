package com.stalary.codegroup.service;

import com.stalary.codegroup.entity.User;
import com.stalary.codegroup.repo.UserRepo;
import com.stalary.codegroup.utils.MD5Utils;
import com.stalary.codegroup.viewmodel.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Stalary
 * @Description:用户业务层，处理用户操作
 * @Date Created in 下午6:09 17/8/24
 */
@Service
public class UserService {


    @Autowired
    private UserRepo userRepo;

    public List<User> sortByRank() {
        return userRepo.sortByRank();//通过rank排序
    }

    public List<User> sortByRegisterTime() {
        return userRepo.sortByRegisterTime();//通过注册日期排序
    }

    public User findByMail(String mail) {
        return userRepo.findByMail(mail);//通过邮箱查找
    }

    public ApiResult alterPassword(User user, String password) {
        user.setPassword(MD5Utils.MD5(password));
        try {
            userRepo.save(user);
            return ApiResult.ok("用户密码修改成功");
        } catch (Exception e) {
            return ApiResult.error("用户密码修改失败！");
        }
    }

    public User findByKeyId(int id) {
        return userRepo.findById(id);
    }

    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public User findByStudentNo(String studentNo) {
        return userRepo.findByStudentNo(studentNo);//通过学号查找用户
    }
}
