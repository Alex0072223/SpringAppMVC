package dbDAO;

import Calc.Calculator;
import dbHandler.Const;
import dbHandler.DbHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Component
public class dbDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public dbDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    private static Connection connection;
     private List<Const> people;

    DbHandler dbhan = new DbHandler();
    Statement statement;

   /* public void SingUp (double a, double b, double c) {
        Calculator cc = new Calculator();

        String insert = "INSERT INTO `msw`.`calc`" + "(" + cc.getA() + "," + cc.getB() + "," + cc.getC()+ ")"
                +"VALUES(?,?,?)";
        try {
            PreparedStatement prSr = getConnection().prepareStatement(insert);
            prSr.setString(2, String.valueOf(a));
            prSr.setString(3, String.valueOf(b));
            prSr.setString(4, String.valueOf(c));


            prSr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/


    public Connection getConnection() {
        return connection;
    }

    public List<Const> index(){
      //  return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(Const.class));

       List<Const> people = new ArrayList<>();
        try {
            String query = "SELECT * FROM users";
            statement = dbhan.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                Const consta = new Const();

                int id = resultSet.getInt("idusers");
                consta.setUSERS_ID(id);

                String name = resultSet.getString("FirstName");
                consta.setUSER_FIRSTNAME(name);

                String lastname = resultSet.getString("LastName");
                consta.setUSER_LASTNAME(lastname);

                String mail = resultSet.getString("UserMail");
                consta.setUSER_MAIL(mail);

                String location = resultSet.getString("Location");
                consta.setUSER_LOCATION(location);

                people.add(consta);



                {
                  //  people.add(new Const(String.valueOf(id),name,lastname,mail,location));
                    //  peoples.add(consta);
                }
                // System.out.println(peoples);

                System.out.println("id: " + id + "| Name: " + name + "| Last Name: " + lastname + "| email: " + mail + "| Location: " + location);

            }



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return people;
    }

    public void save(Const person){
       jdbcTemplate.update("INSERT INTO users VALUES (idusers,?, ?, ?, ?)", person.getUSER_FIRSTNAME(),person.getUSER_LASTNAME(),person.getUSER_MAIL(),person.getUSER_LOCATION());
       /* try {
            PreparedStatement preparedStatement = dbhan.getConnection().prepareStatement("INSERT INTO users VALUES (1,?,?,?,?)");

            preparedStatement.setString(1, person.getUSER_FIRSTNAME());
            preparedStatement.setString(2, person.getUSER_LASTNAME());
            preparedStatement.setString(3, person.getUSER_MAIL());
            preparedStatement.setString(4, person.getUSER_LOCATION());


            preparedStatement.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
        }*/
    }

    public Const show(int id){
       // return jdbcTemplate.query("SELECT * FROM users WHERE idusers=?", new Object[]{id},new BeanPropertyRowMapper<>(Const.class))
           //     .stream().findAny().orElse(null);
        Const person = null;
        try {
            PreparedStatement preparedStatement = dbhan.getConnection().prepareStatement("SELECT * FROM users WHERE idusers = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            person = new Const();
            person.setUSERS_ID(resultSet.getInt("idusers"));
            person.setUSER_FIRSTNAME(resultSet.getString("FirstName"));
            person.setUSER_LASTNAME(resultSet.getString("LastName"));
            person.setUSER_MAIL(resultSet.getString("UserMail"));
            person.setUSER_LOCATION(resultSet.getString("Location"));

        } catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
        }
        return person;
       // return people.stream().filter(Const -> Objects.equals(Const.getUSERS_ID(), String.valueOf(id))).findAny().orElse(null);
    }

    public void update(int id, Const updatePerson){
       // jdbcTemplate.update("UPDATE users SET FirstName=?, LastName=?, UserMail=?,Location=? WHERE idusers=?", updatePerson.getUSER_FIRSTNAME(),updatePerson.getUSER_LASTNAME(),updatePerson.getUSER_MAIL(),updatePerson.getUSER_LOCATION(), id);
        try {
            PreparedStatement preparedStatement =
                    dbhan.getConnection().prepareStatement("UPDATE users SET FirstName=?, LastName=?,UserMail=?,Location=? WHERE idusers=?");


            preparedStatement.setString(1, updatePerson.getUSER_FIRSTNAME());
            preparedStatement.setString(2, updatePerson.getUSER_LASTNAME());
            preparedStatement.setString(3, updatePerson.getUSER_MAIL());
            preparedStatement.setString(4, updatePerson.getUSER_LOCATION());

            preparedStatement.setInt(5,id);

            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        // Const personToBeUpdated = show(id);

       // personToBeUpdated.getUSER_FIRSTNAME(updatePerson.getUSER_FIRSTNAME());
    }

    public void delete(int id){
        //jdbcTemplate.update("DELETE FROM users WHERE idusers=?",id);

        PreparedStatement preparedStatement = null;

        try {
             preparedStatement = dbhan.getConnection().prepareStatement("DELETE FROM users WHERE idusers=?");
             preparedStatement.setInt(1,id);
             preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

