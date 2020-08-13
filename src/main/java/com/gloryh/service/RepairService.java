package com.gloryh.service;

import com.gloryh.entity.Complaint;
import com.gloryh.entity.Fixlog;
import com.gloryh.entity.Page;

/**
 * @author admin
 */
public interface RepairService {

    public void addRepair(Complaint complaint);

    public Page repairList(int thisPage);

    public Complaint findRepairById(Integer id);

    public void creatFixLog(Fixlog fixlog);

    public void updateRepairState(String repairId, int repairState);
}
