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

       List<Const> people = new ArrayList<>();
        try {
            String query = "SELECT * FROM music";
            statement = dbhan.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                Const consta = new Const();

                int id = resultSet.getInt("idmusic");
                consta.setMUSIC_ID(id);

                String name = resultSet.getString("TrackName");
                consta.setMUSIC_TRACKNAME(name);

                String lastname = resultSet.getString("Genre");
                consta.setMUSIC_GENRE(lastname);

                String mail = resultSet.getString("Duration");
                consta.setMUSIC_DURATION(mail);

                String location = resultSet.getString("Artist");
                consta.setMUSIC_ARTIST(location);

                people.add(consta);



                {
                  //  people.add(new Const(String.valueOf(id),name,lastname,mail,location));
                    //  peoples.add(consta);
                }
                // System.out.println(peoples);

                System.out.println("id: " + id + "| Track: " + name + "| Genre: " + lastname + "| Duration : " + mail + "| Artist: " + location);

            }



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return people;
    }

    public void save(Const person){
       jdbcTemplate.update("INSERT INTO music VALUES (idmusic,?, ?, ?, ?)", person.getMUSIC_TRACKNAME(),person.getMUSIC_GENRE(),person.getMUSIC_DURATION(),person.getMUSIC_ARTIST());
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
            PreparedStatement preparedStatement = dbhan.getConnection().prepareStatement("SELECT * FROM music WHERE idmusic = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            person = new Const();
            person.setMUSIC_ID(resultSet.getInt("idmusic"));
            person.setMUSIC_TRACKNAME(resultSet.getString("TrackName"));
            person.setMUSIC_GENRE(resultSet.getString("Genre"));
            person.setMUSIC_DURATION(resultSet.getString("Duration"));
            person.setMUSIC_ARTIST(resultSet.getString("Artist"));

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
                    dbhan.getConnection().prepareStatement("UPDATE music SET TrackName=?, Genre=?,Duration=?,Artist=? WHERE idmusic=?");


            preparedStatement.setString(1, updatePerson.getMUSIC_TRACKNAME());
            preparedStatement.setString(2, updatePerson.getMUSIC_GENRE());
            preparedStatement.setString(3, updatePerson.getMUSIC_DURATION());
            preparedStatement.setString(4, updatePerson.getMUSIC_ARTIST());

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
             preparedStatement = dbhan.getConnection().prepareStatement("DELETE FROM music WHERE idmusic=?");
             preparedStatement.setInt(1,id);
             preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

