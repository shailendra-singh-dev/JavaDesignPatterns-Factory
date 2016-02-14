package com.shail.model;

public class Person {

  private int mID;
  private String mName;
  private String mPassword;

  public Person() {
    // Empty Constructor.....
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + mID;
    result = prime * result + ((mName == null) ? 0 : mName.hashCode());
    result = prime * result + ((mPassword == null) ? 0 : mPassword.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    if (mID != other.mID)
      return false;
    if (mName == null) {
      if (other.mName != null)
        return false;
    } else if (!mName.equals(other.mName))
      return false;
    if (mPassword == null) {
      if (other.mPassword != null)
        return false;
    } else if (!mPassword.equals(other.mPassword))
      return false;
    return true;
  }

  public Person(int id, String name, String password) {
    mID = id;
    mName = name;
    mPassword = password;
  }

  public int getID() {
    return mID;
  }

  public void setID(int ID) {
    this.mID = ID;
  }

  public String getName() {
    return mName;
  }

  public void setName(String name) {
    this.mName = name;
  }

  public String getPassword() {
    return mPassword;
  }

  public void setPassword(String password) {
    this.mPassword = password;
  }
}
