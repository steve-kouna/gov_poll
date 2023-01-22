package biz.koona.gov_poll.repositories;

import biz.koona.gov_poll.entities.Attempts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttemptsRepository extends CrudRepository<Attempts, String> {
    Optional<Attempts> findAttemptsByUsername(String username);
}
