package com.tutorial.test.service;

import com.tutorial.test.data.Person;
import com.tutorial.test.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get("not found");
        });
    }

    @Test
    void testGetPersonSuccess() {
        // Menambahkan Behavior ke Mock Object
        Mockito.when(personRepository.selectById("ibad"))
                .thenReturn(new Person("ibad", "Ibad Nurhamim"));

        var person = personService.get("ibad");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("ibad", person.getId());
        Assertions.assertEquals("Ibad Nurhamim", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        var person = personService.register("Ibad");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Ibad", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "Ibad"));
    }
}

/*
* NOTE :
* Setiap melakukan Mocking Object disarankan selalu melakukan verifikasi
* */