package com.itexico.model;

import java.sql.Date;


public class Log {

  public Log(int id, Date date, String message) {
    super();
    this.id = id;
    this.date = date;
    this.message = message;
  }

  private int id;
  private Date date;
  private String message;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
