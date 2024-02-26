package com.amithchalana.fileuploadbackend.repository;

import com.amithchalana.fileuploadbackend.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
}
