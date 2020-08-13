package com.gloryh.repository;

import com.gloryh.entity.Fixlog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FixLogRepository {
    public List<Fixlog> findFixingLogList();

    public int fixingLogToFixedLog(@Param("fixlog") Fixlog fixlog,@Param("complaintState") int complaintState);

    public List<Fixlog> findFixedLogList();
}
