package fr.pompey.cda23016.webprojet.repository;

import fr.pompey.cda23016.webprojet.config.CustomProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

    @Slf4j
    @Component
    public class WebClientFlux {

//        @Autowired
//        private CustomProperties properties;

//        private final WebClient webClient;
//
//        public PersonRepository(CustomProperties properties) {
//            this.properties = properties;
//            this.webClient = WebClient.builder()
//                    .baseUrl(properties.getUrlAPI())
//                    .build();
//        }
//
//        public Flux<Person> getPersons() {
//            return webClient.get()
//                    .uri("/persons")
//                    .retrieve()
//                    .bodyToFlux(Person.class)
//                    .doOnNext(person -> log.debug("Get Persons call - received person"));
//        }
//
//        public Mono<Person> getPerson(int id) {
//            return webClient.get()
//                    .uri("/person/{id}", id)
//                    .retrieve()
//                    .bodyToMono(Person.class)
//                    .doOnNext(person -> log.debug("Get Person call - received person with id: {}", id));
//        }
//
//        public Mono<Person> createPerson(Person person) {
//            return webClient.post()
//                    .uri("/person")
//                    .body(BodyInserters.fromValue(person))
//                    .retrieve()
//                    .bodyToMono(Person.class)
//                    .doOnNext(p -> log.debug("Create Person call - created person with id: {}", p.getId()));
//        }
//
//        public Mono<Person> updatePerson(Person person) {
//            return webClient.put()
//                    .uri("/person/{id}", person.getId())
//                    .body(BodyInserters.fromValue(person))
//                    .retrieve()
//                    .bodyToMono(Person.class)
//                    .doOnNext(p -> log.debug("Update Person call - updated person with id: {}", p.getId()));
//        }
//
//        public Mono<Void> deletePerson(int id) {
//            return webClient.delete()
//                    .uri("/person/{id}", id)
//                    .retrieve()
//                    .bodyToMono(Void.class)
//                    .doOnSuccess(aVoid -> log.debug("Delete Person call - deleted person with id: {}", id));
//        }
    }



