package com.shail.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class OraclePersonDAO implements IPersonDAO {

  /* (non-Javadoc)
   * @see com.shail.model.IPersonDAP#addPerson(com.shail.model.Person)
   */
  @Override
  public void addPerson(final Person person) {
    Connection connection = Database.getInstance().getConnection();
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement =
          connection.prepareStatement("insert into person(name,password) values(?,?)");
      preparedStatement.setString(1, person.getName());
      preparedStatement.setString(2, person.getPassword());
      preparedStatement.executeUpdate();
      preparedStatement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  /* (non-Javadoc)
   * @see com.shail.model.IPersonDAP#getPerson(int)
   */
  @Override
  public Person getPerson(int id) {
    return null;
  }

  /* (non-Javadoc)
   * @see com.shail.model.IPersonDAP#getPeople()
   */
  @Override
  public List<Person> getPeople() throws SQLException {
    List<Person> people = new ArrayList<Person>();
    Connection conn = Database.getInstance().getConnection();

    String sql = "select id, name, password from people order by id";
    Statement selectStatement = conn.createStatement();

    ResultSet results = selectStatement.executeQuery(sql);

    while (results.next()) {
      int id = results.getInt("id");
      String name = results.getString("name");
      String password = results.getString("password");

      Person person = new Person(id, name, password);
      people.add(person);
    }

    results.close();
    selectStatement.close();

    return people;
  }

  /* (non-Javadoc)
   * @see com.shail.model.IPersonDAP#updatePerson(com.shail.model.Person)
   */
  @Override
  public int updatePerson(Person person) {
    Connection conn = Database.getInstance().getConnection();
    int updated = 0;
    PreparedStatement p;
    try {
      p = conn.prepareStatement("update people set name=?, password=? where id=?");
      p.setString(1, person.getName());
      p.setString(2, person.getPassword());
      p.setInt(3, person.getID());

      updated = p.executeUpdate();

      p.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return updated;

  }

  /* (non-Javadoc)
   * @see com.shail.model.IPersonDAP#deletePerson(int)
   */
  @Override
  public int deletePerson(int id) {
    Connection conn = Database.getInstance().getConnection();
    int updated = 0;
    PreparedStatement p;
    try {
      p = conn.prepareStatement("delete from people where id=?");
      p.setInt(1, id);

      updated = p.executeUpdate();

      p.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return updated;
  }

  /* (non-Javadoc)
   * @see com.shail.model.IPersonDAP#deleteAll()
   */
  @Override
  public int deleteAll() {
    Connection conn = Database.getInstance().getConnection();
    int updated = 0;
    PreparedStatement p;
    try {
      p = conn.prepareStatement("delete from people ");

      updated = p.executeUpdate();

      p.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return updated;
  }

}
