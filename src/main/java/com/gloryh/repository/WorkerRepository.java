package com.gloryh.repository;

import com.gloryh.entity.User;

import java.util.List;
import java.util.Map;

public interface WorkerRepository {
    public List<Map<String, Object>> findFreeWorker();

    public User findWorker(String workerUsername);

    public void updateWorkerState(User worker);
}
