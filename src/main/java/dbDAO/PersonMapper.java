package dbDAO;

import dbHandler.Const;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Const> {

    @Override
    public Const mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Const person = new Const();

        person.setMUSIC_ID(resultSet.getInt("idmusic"));
        person.setMUSIC_TRACKNAME(resultSet.getString("TrackName"));
        person.setMUSIC_GENRE(resultSet.getString("Genre"));
        person.setMUSIC_DURATION(resultSet.getString("Duration"));
        person.setMUSIC_ARTIST(resultSet.getString("Artist"));

        return person;

    }
}
