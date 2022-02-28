package ru.job4j.accident.repository;


import org.springframework.data.repository.CrudRepository;
import ru.job4j.accident.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User getUserByUsername(String name);

    User getUserByPassword(String password);
}
