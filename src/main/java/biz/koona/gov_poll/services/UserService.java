package biz.koona.gov_poll.services;

import biz.koona.gov_poll.entities.User;
import biz.koona.gov_poll.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUpdate(User user){
        return userRepository.save(user);
    }

    public User readOne(String id) {
        return userRepository.findById(id).get();
    }

    public Iterable<User> readAll() {
        return userRepository.findAll();
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
