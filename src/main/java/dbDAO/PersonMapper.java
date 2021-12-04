package dbDAO;

import dbHandler.Const;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Const> {

    @Override
    public Const mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Const person = new Const();

        person.setUSERS_ID(resultSet.getInt("idusers"));
        person.setUSER_FIRSTNAME(resultSet.getString("FirstName"));
        person.setUSER_LASTNAME(resultSet.getString("LastName"));
        person.setUSER_MAIL(resultSet.getString("UserMail"));
        person.setUSER_LOCATION(resultSet.getString("Location"));

        return person;

    }
}
