package fr.pompey.cda23016.webprojet.service;

import fr.pompey.cda23016.webprojet.model.Person;
import fr.pompey.cda23016.webprojet.repository.PersonRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getPerson(Integer id) {
        return personRepository.getPerson(id);
    }

    public Iterable<Person> getAllPersons() {
        return personRepository.getPersons();
    }

    public void detelePerson(final Integer id) {
        personRepository.deletePerson(id);
    }

    public Person savePerson(Person person) {
        Person saved;
        //System.out.println(person.toString());
        // Règle de gestion : Le nom de famille doit être mis en majuscule.
        person.setLastName(person.getLastName().toUpperCase());

        if(person.getId() == null) {
            // Si l'id est nul, alors c'est un nouvel employé.
            saved = personRepository.createPerson(person);
        } else {
            saved = personRepository.updatePerson(person);
        }
        return saved;
    }
}
