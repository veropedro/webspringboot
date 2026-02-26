package fr.pompey.cda23016.webprojet;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import fr.pompey.cda23016.webprojet.model.Person;
import fr.pompey.cda23016.webprojet.repository.PersonRepository;
import fr.pompey.cda23016.webprojet.service.PersonService;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonControllerIT {

    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private PersonService personService;

    @Test
    @Epic("Gestion des personnes")
    @Feature("Récupération de personnes")
    public void getPersonTest() {
        Person person1 = new Person();
        person1.setId(1);
        person1.setFirstName("John");
        person1.setLastName("Doe");

        Person person2 = new Person();
        person2.setId(2);
        person2.setFirstName("Mary");
        person2.setLastName("Doe");

        when(personRepository.getPersons()).thenReturn(Arrays.asList(person1, person2));
        // verifie que ma méthode est appelé 1 fois

        // appel de la méthode
        Iterable<Person> result = personService.getAllPersons();

        verify(personRepository, times(1)).getPersons();
        // contrôle du résultat
        assertThat(result.iterator().next().getFirstName().contains("John"));
        assertThat(result.iterator().next().getFirstName().contains("Mary"));
    }

}
