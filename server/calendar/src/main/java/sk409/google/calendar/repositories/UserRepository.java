package sk409.google.calendar.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sk409.google.calendar.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);

}