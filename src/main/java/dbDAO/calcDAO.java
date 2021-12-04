package dbDAO;

import Calc.Calculator;
import dbHandler.DbHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class calcDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public calcDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    private List<Calculator> calculator;


    private static Connection connection;
    DbHandler dbhan = new DbHandler();
    Statement statement;
    public Connection getConnection() {
        return connection;
    }

    public List<Calculator> calcMemory(){
        List<Calculator> calculator = new ArrayList<>();

        try {
            String query = "SELECT * FROM calc";
            statement = dbhan.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                Calculator calc = new Calculator();

                int id = resultSet.getInt("idn");
                calc.setIdn(id);

                Double firstNumber = resultSet.getDouble("firstNumber");
                calc.setFirstNumber(firstNumber);

                Double secondNumber = resultSet.getDouble("secondNumber");
                calc.setSecondNumber(secondNumber);

                Double result = resultSet.getDouble("result");
                calc.setResult(result);



                calculator.add(calc);



                {
                    //  people.add(new Const(String.valueOf(id),name,lastname,mail,location));
                    //  peoples.add(consta);
                }
                // System.out.println(peoples);

                System.out.println("id: " + id + "| First number: " + firstNumber + "| Second number: " + secondNumber + "| result " + result);

            }



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return calculator;
    }

    public Calculator show(int id){
        // return jdbcTemplate.query("SELECT * FROM users WHERE idusers=?", new Object[]{id},new BeanPropertyRowMapper<>(Const.class))
        //     .stream().findAny().orElse(null);
        Calculator mem = null;
        try {
            PreparedStatement preparedStatement = dbhan.getConnection().prepareStatement("SELECT * FROM calc WHERE idn = ?");
            preparedStatement.setDouble(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            mem = new Calculator();
            mem.setIdn(resultSet.getInt("idn"));
            mem.setFirstNumber(resultSet.getDouble("firstNumber"));
            mem.setSecondNumber(resultSet.getDouble("secondNumber"));
            mem.setResult(resultSet.getDouble("result"));


        } catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
        }
        return mem;
        // return people.stream().filter(Const -> Objects.equals(Const.getUSERS_ID(), String.valueOf(id))).findAny().orElse(null);
    }

    public void plus(double firstNumber, double secondNumber, Calculator calculator) {
        //  List<Calculator> calculator = new ArrayList<>();
        Calculator result = new Calculator();
        //try {

        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
        calculator.setResult(firstNumber + secondNumber);
        System.out.println("sdsadasd"+ calculator.getResult());
           /* result.setFirstNumber(firstNumber);
            result.setSecondNumber(secondNumber);*/


        // Calculator calc = new Calculator();

        //result.setResult(firstNumber + secondNumber);
        //calculator.add(result);

     //   System.out.println("zalupa^ " + result.getResult());
      /*  } catch (Exception e) {
            e.printStackTrace();
        }*/


        // System.out.println("vse ok" + result1);
        //   double result1 = result;


    }

    public void save(Calculator calculator){
        jdbcTemplate.update("INSERT INTO calc VALUES (idn,?, ?, ?)",calculator.getFirstNumber(),
                calculator.getSecondNumber(),calculator.getResult());
    }


}
