package com.gloryh.service;

import com.gloryh.entity.Fixlog;

import java.util.List;

public interface FixLogService {
    public List<Fixlog> findFixingLogList();

    public int fixingLogToFixedLog(Fixlog fixlog);

    public List<Fixlog> findFixedLogList();
}
