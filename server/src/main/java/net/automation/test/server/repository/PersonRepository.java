package net.automation.test.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.automation.test.server.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryCustom {

}
