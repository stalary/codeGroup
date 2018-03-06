package com.stalary.codegroup.repo;

import com.stalary.codegroup.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Stalary
 * @Description:积分数据库操作层
 * @Date Created in 2017/8/24
 */
@Repository
public interface RankRepo extends JpaRepository<Rank, Integer> {

    @Query("select r from Rank r where r.user_keyId = ?1 order by r.latestTime desc")
    List<Rank> findByUserKeyId(Integer keyId);//通过关联用户的keyId来查找积分纪录
}
