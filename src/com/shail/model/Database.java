package com.shail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

  private final static Database mDatabaseManager = new Database();
  private Connection mConnection;

  private Database() {
    // Not accessible..
  }

  public static Database getInstance() {
    return mDatabaseManager;
  }

  public Connection getConnection() {
    return mConnection;
  }


  public void connect() throws Exception {
    if (mConnection != null)
      return;

    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new Exception("Driver not found");
    }

    String url = String.format("jdbc:mysql://localhost:%d/patterns", 3306);

    mConnection = DriverManager.getConnection(url, "squiffy", "letmein");
  }

  public void disconnect() {
    if (mConnection != null) {
      try {
        mConnection.close();
      } catch (SQLException e) {
        System.out.println("Can't close connection");
      }
    }

    mConnection = null;
  }

}
