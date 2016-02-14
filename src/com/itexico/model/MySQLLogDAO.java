package com.itexico.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLLogDAO implements ILogDAO {

  /* (non-Javadoc)
   * @see com.itexico.model.ILogDAO#addLog(com.itexico.model.Log)
   */
  @Override
  public void addLog(final Log log) {
    Connection connection = Database.getInstance().getConnection();
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("insert into log(date,message) values(?,?)");
      preparedStatement.setDate(1, log.getDate());
      preparedStatement.setString(2, log.getMessage());
      preparedStatement.executeUpdate();
      preparedStatement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /* (non-Javadoc)
   * @see com.itexico.model.ILogDAO#getLog()
   */
  @Override
  public List<Log> getLog() throws SQLException {
    List<Log> people = new ArrayList<Log>();
    Connection conn = Database.getInstance().getConnection();

    String sql = "select id, date, message from log order by id";
    Statement selectStatement = conn.createStatement();
    ResultSet results = selectStatement.executeQuery(sql);
    while (results.next()) {
      int id = results.getInt("id");
      Date date = results.getDate("date");
      String message = results.getString("message");

      Log log = new Log(id, date, message);
      people.add(log);
    }

    results.close();
    selectStatement.close();

    return people;
  }

  /* (non-Javadoc)
   * @see com.itexico.model.ILogDAO#updateLog(com.itexico.model.Log)
   */
  @Override
  public int updateLog(Log log) {
    Connection conn = Database.getInstance().getConnection();
    int updated = 0;
    PreparedStatement p;
    try {
      p = conn.prepareStatement("update log set date=?, message=? where id=?");
      p.setDate(1, log.getDate());
      p.setString(2, log.getMessage());
      p.setInt(3, log.getId());
      updated = p.executeUpdate();
      p.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return updated;
  }

  /* (non-Javadoc)
   * @see com.itexico.model.ILogDAO#deleteLog(int)
   */
  @Override
  public int deleteLog(int id) {
    Connection conn = Database.getInstance().getConnection();
    int updated = 0;
    PreparedStatement p;
    try {
      p = conn.prepareStatement("delete from log where id=?");
      p.setInt(1, id);

      updated = p.executeUpdate();

      p.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return updated;
  }

  /* (non-Javadoc)
   * @see com.itexico.model.ILogDAO#deleteAll()
   */
  @Override
  public int deleteAll() {
    Connection conn = Database.getInstance().getConnection();
    int updated = 0;
    PreparedStatement p;
    try {
      p = conn.prepareStatement("delete from log");

      updated = p.executeUpdate();

      p.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return updated;
  }



}
