package com.assignment.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author shan
 * <p>
 * User repository
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
}
