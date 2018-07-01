package me.mike.aims.service;

import me.mike.aims.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Michael Keith
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void create() {
        // TODO
    }
}
