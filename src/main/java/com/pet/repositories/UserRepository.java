package com.pet.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pet.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
}
