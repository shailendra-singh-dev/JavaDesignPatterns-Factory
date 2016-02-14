package com.shail.model;

import java.sql.SQLException;
import java.util.List;



public interface ILogDAO {

  public abstract void addLog(final Log log);

  public abstract List<Log> getLog() throws SQLException;

  public abstract int updateLog(Log log);

  public abstract int deleteLog(int id);

  public abstract int deleteAll();

}
