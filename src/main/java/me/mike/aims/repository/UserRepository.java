package me.mike.aims.repository;

import me.mike.aims.model.entity.User;
import me.mike.aims.model.search.UserSearchRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Michael Keith
 */
public interface UserRepository {
    User create(User user);
    User readById(UUID id);
    Optional<User> findByUsername(String username);
    List<User> search(UserSearchRequest searchRequest);
    User update(User user);
}
