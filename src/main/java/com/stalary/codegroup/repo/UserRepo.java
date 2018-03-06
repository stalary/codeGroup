package com.stalary.codegroup.repo;

import com.stalary.codegroup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Stalary
 * @Description:用户数据库操作层
 * @Date Created in 2017/8/24
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    /**
     * 通过rank排序
     * @return
     */
    @Query("select u from User u order by u.rank desc")
    List<User> sortByRank();

    /**
     * 通过注册日期排序
     * @return
     */
    @Query("select u from User u order by u.registerTime asc")
    List<User> sortByRegisterTime();

    /**
     * 通过学号查找用户
     * @param studentNo
     * @return
     */
    User findByStudentNo(String studentNo);

    /**
     * 通过邮箱查找
     * @param mail
     * @return
     */
    User findByMail(String mail);

    /**
     * 通过id查找用户
     */
    User findById(int id);
}
