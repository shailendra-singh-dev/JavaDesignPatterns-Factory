package com.shail.application.factory;

import com.shail.model.ILogDAO;
import com.shail.model.IPersonDAO;
import com.shail.model.MySQLLogDAO;
import com.shail.model.MySQLPersonDAO;

public final class DAOFactory {

  private static final DAOFactory DAO_FACTORY = new DAOFactory();

  public enum FACTORY_TYPE {
    PERSON("Person"), LOG("Log");

    private String mName;

    FACTORY_TYPE(String name) {
      mName = name;
    }

    public String getFactoryName() {
      return mName;
    }
  }

  public IPersonDAO getPersonDAO() {
    return new MySQLPersonDAO();
  }

  public ILogDAO getLogDAO() {
    return new MySQLLogDAO();
  }

  public static DAOFactory getInstance() {
    return DAO_FACTORY;
  }

}
