package com.gloryh.service.Impl;

import com.gloryh.entity.Complaint;
import com.gloryh.entity.Fixlog;
import com.gloryh.entity.Page;
import com.gloryh.repository.RepairRepository;
import com.gloryh.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/** @author admin */
@Service
public class RepairServiceImpl implements RepairService {

  @Autowired private RepairRepository repairRepository;

  @Override
  public void addRepair(Complaint complaint) {
    repairRepository.addRepair(complaint);
  }

  @Override
  public Page repairList(int thisPage) {
    System.out.println("thispage:"+thisPage);

    int total = repairRepository.CountForRepair();
    System.out.println("total:"+total);
    Page page = new Page(thisPage, total);
    int end=page.getEnd();
    page.setEnd(end);
    page.setStart(page.getStart());
    page.setStartIndex(page.getStartIndex());
    List<Map<String,Object>> list = repairRepository.repairList(page.getStartIndex(), page.getPageSize());
    page.setList(list);
    return page;
  }

  @Override
  public Complaint findRepairById(Integer id) {
    return repairRepository.findRepairById(id);
  }

  @Override
  public void creatFixLog(Fixlog fixlog) {
    repairRepository.creatFixLog(fixlog);
  }

  @Override
  public void updateRepairState(String repairId, int repairState) {
    Integer id =Integer.parseInt(repairId);
    System.out.println("id"+id);
    repairRepository.updateRepairState(id,repairState);
  }
}
