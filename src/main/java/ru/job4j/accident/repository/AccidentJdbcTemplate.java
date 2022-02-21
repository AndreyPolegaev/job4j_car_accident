//package ru.job4j.accident.repository;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import ru.job4j.accident.model.Accident;
//import ru.job4j.accident.model.AccidentType;
//import ru.job4j.accident.model.Rule;
//
//import java.util.*;
//
////@Repository
//public class AccidentJdbcTemplate {
//
//    private final JdbcTemplate jdbc;
//
//    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
//        this.jdbc = jdbc;
//    }
//
//    public Accident save(Accident accident) {
//        jdbc.update("insert into accident (name) values (?)",
//                accident.getName());
//        return accident;
//    }
//
//    public List<Accident> getAllAccident() {
//        Set<Integer> rules = new HashSet<>();
//        List<Accident> accidents = jdbc.query("select a.id, a.name, a.text, a.address, t.id as typeId, t.name as typeName, " +
//                        "ar.rules_id as rulesId " +
//                        "from accident a join accidenttype t on a.type_id = t.id " +
//                        "join accident_rules ar on a.id = ar.accident_id ",
//                (rs, row) -> {
//                    Accident accident = new Accident();
//                    accident.setId(rs.getInt("id"));
//                    accident.setName(rs.getString("name"));
//                    accident.setText(rs.getString("text"));
//                    accident.setAddress(rs.getString("address"));
//                    accident.setType(AccidentType.of(rs.getInt("typeId"), rs.getString("typeName")));
//                    rules.add(rs.getInt("rulesId"));
//                    return accident;
//                });
//
//        List<Rule> rsl = new ArrayList<>();
//        rules.forEach(el -> rsl.add(getRulesById(el)));
//        return null;
//    }
//
//    public Rule getRulesById(int id) {
//        Rule rule = new Rule();
//        jdbc.queryForObject("select * from rules where id = ?", (rs, row) -> {
//            rule.setId(rs.getInt("id"));
//            rule.setName(rs.getString("name"));
//            return rule;
//        }, id);
//        return Rule.of(-1, "Unknown Rule");
//    }
//
//    public Collection<Rule> getRules() {
//        return jdbc.query("select id, name from rules",
//                (rs, row) -> {
//                    Rule rules = new Rule();
//                    rules.setId(rs.getInt("id"));
//                    rules.setName(rs.getString("name"));
//                    return rules;
//                });
//    }
//
//    public Collection<AccidentType> getTypes() {
//        return jdbc.query("select id, name from accidenttype",
//                (rs, row) -> {
//                    AccidentType rules = new AccidentType();
//                    rules.setId(rs.getInt("id"));
//                    rules.setName(rs.getString("name"));
//                    return rules;
//                });
//    }
//
//    public Accident update(Accident accident) {
//        jdbc.update("update accident set name = ?", accident.getName());
//        return accident;
//    }
//
//    public Accident getAccidentById(int id) {
//        Accident accident = null;
//        accident = jdbc.queryForObject("select * from accident where id = ?", new Object[]{id}, Accident.class);
//        return accident;
//    }
//}
