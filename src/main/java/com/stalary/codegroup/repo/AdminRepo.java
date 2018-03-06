package com.stalary.codegroup.repo;

import com.stalary.codegroup.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Stalary
 * @Description:管理员数据库操作层
 * @Date Created in 2017/8/24
 */
@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

    /**
     * 通过手机号查找管理员
     */
    Admin findByPhone(String account);

    /**
     * 通过学号查找管理员
     * @param studentNo
     * @return
     */
    Admin findByStudentNo(String studentNo);

    /**
     * 通过职务和年级排序
     * @return
     */
    @Query("select a from Admin a order by a.position asc, a.year asc")
    List<Admin> sortByPositionAndYear();

    /**
     * 通过邮箱查找
     * @param mail
     * @return
     */
    Admin findByMail(String mail);

    /**
     * 通过id查找管理员
     * @param id
     * @return
     */
    Admin findById(int id);
}
