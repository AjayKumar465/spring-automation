package net.automation.test.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.automation.test.server.dto.PersonDTO;
import net.automation.test.server.model.Person;
import net.automation.test.server.repository.PersonRepository;



@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    final static Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    PersonRepository personRepository;



    @Override
    public Page<PersonDTO> findPersons(Pageable pageable) {
    	
        return personRepository.findAll(pageable).map(person -> {
        	PersonDTO pDTO = new PersonDTO();
        	BeanUtils.copyProperties(person, pDTO);
            return pDTO;	
        });
    }

    @Override
    public PersonDTO getPerson(Long id) {
        Person person = personRepository.getOne(id);
        if (person == null) {
            return null;
        } else {
        	PersonDTO pDTO = new PersonDTO();
        	BeanUtils.copyProperties(person, pDTO);
            return pDTO;
        }
    }

    @Override
    public void updatePerson(PersonDTO personDTO) {
        Person person = personRepository.findOne(personDTO.getId());
    	BeanUtils.copyProperties(personDTO, person);
    }

    @Override
    public void savePerson(PersonDTO personDTO) {
    	Person person = new Person();
    	BeanUtils.copyProperties(personDTO, person);
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.delete(id);
    }
}
