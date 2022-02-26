package ru.job4j.accident.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.accident.model.Accident;
import java.util.List;

public interface AccidentRepository extends JpaRepository<Accident, Integer> {

    @Query(value = "select distinct ac from Accident ac join fetch ac.type t join fetch ac.rules")
    List<Accident> getAllAccidentsWithInnerObject();

    @Modifying
    @Query(value = "update Accident a set a.name = ?1, a.text = ?2, a.address = ?3 where a.id = ?4")
    void update(String name, String text, String address, Integer id);
}
