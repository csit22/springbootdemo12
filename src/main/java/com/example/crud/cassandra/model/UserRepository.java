package com.example.crud.cassandra.model;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserRepository extends CassandraRepository<Users,Integer>{

}
