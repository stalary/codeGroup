package com.stalary.codegroup.service;

import com.stalary.codegroup.entity.Log;
import com.stalary.codegroup.repo.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:Stalary
 * @Description:日志业务层，操作日志
 * @Date Created in 下午5:07 17/8/24
 */
@Service
public class LogService {

    @Autowired
    private LogRepo repo;

    public void create(String content){
        Log log = new Log();
        log.setContent(content);
        repo.save(log);
    }
}
