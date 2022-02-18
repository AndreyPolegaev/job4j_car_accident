package ru.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.Collection;
import java.util.List;

@Repository
public class AccidentJdbcTemplate {

    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Accident save(Accident accident) {
        jdbc.update("insert into accident (name) values (?)",
                accident.getName());
        return accident;
    }

    public List<Accident> getAllAccident() {
        return jdbc.query("select id, name from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    return accident;
                });
    }

    public Collection<Rule> getRules() {
        return jdbc.query("select id, name from rules",
                (rs, row) -> {
                    Rule rules = new Rule();
                    rules.setId(rs.getInt("id"));
                    rules.setName(rs.getString("name"));
                    return rules;
                });
    }

    public Collection<AccidentType> getTypes() {
        return jdbc.query("select id, name from accidenttype",
                (rs, row) -> {
                    AccidentType rules = new AccidentType();
                    rules.setId(rs.getInt("id"));
                    rules.setName(rs.getString("name"));
                    return rules;
                });
    }

    public Accident update(Accident accident) {
        jdbc.update("update accident set name = ?",
                accident.getName());
        return accident;
    }

    public Accident getAccidentById(int id) {
        Accident accident = null;
            accident = jdbc.queryForObject("select * from accident where id = ?", new Object[]{id}, Accident.class);
        return accident;
    }
}
