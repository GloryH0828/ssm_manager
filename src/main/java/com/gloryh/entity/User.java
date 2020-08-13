package com.gloryh.entity;

public class User {
  private int id;
  private String username;
  private String name;
  private String password;
  private String role;
  private int state;

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "User{"
        + "id="
        + id
        + ", username='"
        + username
        + '\''
        + ", name='"
        + name
        + '\''
        + ", password='"
        + password
        + '\''
        + ", role='"
        + role
        + '\''
        + '}';
  }
}
