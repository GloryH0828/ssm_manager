package com.gloryh.repository;

import com.gloryh.entity.User;

/**
 * @author admin
 */
public interface LoginRepository {
  public User findUser(String username, String role);

  public int countUser(String username, String role);
}
