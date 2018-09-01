package com.nearu.model;

public class User {

  private long id;
  private long userId;
  private String userName;
  private String tel;
  private long type;
  private long status;
  private long addedTime;
  private long modifiedTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public long getAddedTime() {
    return addedTime;
  }

  public void setAddedTime(long addedTime) {
    this.addedTime = addedTime;
  }


  public long getModifiedTime() {
    return modifiedTime;
  }

  public void setModifiedTime(long modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

}
