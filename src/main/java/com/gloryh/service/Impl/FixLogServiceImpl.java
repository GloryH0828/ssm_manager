package com.gloryh.service.Impl;

import com.gloryh.entity.Fixlog;
import com.gloryh.repository.FixLogRepository;
import com.gloryh.service.FixLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 */
@Service
public class FixLogServiceImpl implements FixLogService {

    @Autowired
    private FixLogRepository fixLogRepository;

    @Override
    public List<Fixlog> findFixingLogList() {
        return fixLogRepository.findFixingLogList();
    }

    @Override
    public int fixingLogToFixedLog(Fixlog fixlog) {
        int complaintState=2;
        if(fixlog.getState()==1){
            complaintState=1;
        }
        int result=fixLogRepository.fixingLogToFixedLog(fixlog,complaintState);
        return result;
    }

    @Override
    public List<Fixlog> findFixedLogList() {
        return fixLogRepository.findFixedLogList();
    }
}
