package com.stalary.codegroup.repo;


import com.stalary.codegroup.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author:Stalary
 * @Description:日志数据库操作层
 * @Date Created in 下午5:06 17/8/24
 */
@Repository
public interface LogRepo extends JpaRepository<Log, Integer> {

}
