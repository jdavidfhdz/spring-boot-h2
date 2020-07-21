package mx.wepi.springbooth2.dao;

import org.springframework.data.repository.CrudRepository;

import mx.wepi.springbooth2.dto.User;

//Repository to save the user in a H2 DB
public interface UserRepository extends CrudRepository<User, Integer> {
}
