package biz.koona.gov_poll.repositories;

import biz.koona.gov_poll.entities.Opinion;
import biz.koona.gov_poll.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findUserByUsername(String username);
}