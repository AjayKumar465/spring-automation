package net.automation.test.server.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.automation.test.server.dto.PersonDTO;

public interface PersonService {

    Page<PersonDTO> findPersons(Pageable pageable);

    PersonDTO getPerson(Long id);

    void updatePerson(PersonDTO personDTO);

    void savePerson(PersonDTO personDTO);

    void deletePerson(Long id);

}
