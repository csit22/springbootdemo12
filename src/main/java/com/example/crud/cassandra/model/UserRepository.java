package com.example.crud.cassandra.model;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Component;
import com.example.crud.cassandra.model.User;
@Component
public interface UserRepository extends CassandraRepository<User,Integer>{

}
