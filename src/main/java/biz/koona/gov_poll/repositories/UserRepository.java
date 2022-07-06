package biz.koona.gov_poll.repositories;

import biz.koona.gov_poll.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}