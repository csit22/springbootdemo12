package com.example.crud.cassandra;

import java.util.List;

import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.CassandraUnit;
import org.cassandraunit.spring.CassandraUnitDependencyInjectionTestExecutionListener;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.example.crud.cassandra.model.UserRepository;
import com.example.crud.cassandra.model.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest({ "spring.data.cassandra.port=9142",
        "spring.data.cassandra.keyspace-name=keyspaceToCreate" })
@EnableAutoConfiguration
@ComponentScan
@ContextConfiguration
@TestExecutionListeners({ CassandraUnitDependencyInjectionTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class })
@CassandraDataSet(value = { "setupTables.cql" }, keyspace = "keyspaceToCreate")
@CassandraUnit
@EmbeddedCassandra(timeout = 100000L)
public class SpringCrudCassandraDemoApplicationTests {

	@Autowired
    UserRepository repo;
	@Test
	public void contextLoads() {
		
		Users user = new Users(1,"neha");
		repo.save(user);
		List<Users> users = repo.findAll();
		int actual = users.size();
		Assert.assertEquals(1,actual);
	}

}
