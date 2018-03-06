package com.stalary.codegroup.service;


import com.stalary.codegroup.entity.Admin;

import com.stalary.codegroup.repo.AdminRepo;
import com.stalary.codegroup.utils.MD5Utils;
import com.stalary.codegroup.viewmodel.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Stalary
 * @Description:管理员业务层，处理管理员操作
 * @Date Created in 2017/8/24
 */
@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public Admin findByPhone(String phone) {
        return adminRepo.findByPhone(phone);//通过账号查找管理员
    }

    public Admin findByStudentNo(String studentNo) {
        return adminRepo.findByStudentNo(studentNo);//通过学号查找管理员
    }

    public List<Admin> sortByPositionAndYear() {
        return adminRepo.sortByPositionAndYear();//通过职务排序
    }

    public Admin findByMail(String mail) {
        return adminRepo.findByMail(mail);//通过邮箱查找
    }

    public ApiResult alterPassword(Admin admin, String password) {
        admin.setPassword(MD5Utils.MD5(password));
        try {
            adminRepo.save(admin);
            return ApiResult.ok("管理员密码修改成功");
        } catch (Exception e) {
            return ApiResult.error("管理员密码修改失败！");
        }
    }

    public void save(Admin admin) {
        adminRepo.save(admin);
    }

    public void deleteById(int id) {
        adminRepo.deleteById(id);
    }

    public Admin findByKeyId(int id) {
        return adminRepo.findByKeyId(id);
    }
}
