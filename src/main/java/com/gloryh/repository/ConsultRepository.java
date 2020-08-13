package com.gloryh.repository;

import com.gloryh.entity.Consult;

import java.util.List;
import java.util.Map;

public interface ConsultRepository {
  public void addConsult(Consult consult);

  public  int countForConsult();

  public List<Map<String, Object>> consultList(int startIndex, int pageSize);
}
