package br.com.mysite.peopleregister.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
