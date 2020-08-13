package com.gloryh.repository;

import com.gloryh.entity.Complaint;
import com.gloryh.entity.Fixlog;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
public interface RepairRepository {
    public void addRepair(Complaint complaint);

    public List<Map<String, Object>> repairList(int startIndex, int pageSize);

    public int CountForRepair();

    public Complaint findRepairById(Integer id);

    public void creatFixLog(Fixlog fixlog);

    public void updateRepairState(Integer repairId, int repairState);
}
