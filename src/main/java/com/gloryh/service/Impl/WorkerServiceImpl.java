package com.gloryh.service.Impl;

import com.gloryh.entity.User;
import com.gloryh.repository.WorkerRepository;
import com.gloryh.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public List<Map<String, Object>> findFreeWorker() {
        return workerRepository.findFreeWorker();
    }

    @Override
    public User findWorker(String workerUsername) {
        return workerRepository.findWorker(workerUsername);
    }

    @Override
    public void updateWorkerState(User worker) {
        workerRepository.updateWorkerState(worker);
    }
}
