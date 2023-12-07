package pl.sak.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
// TODO do przeniesienia: notatka o mikroserwisach Uber
// Stworz mikroserwisy do zarzadzania klientami, kierowcami i przejazdami a'la Uber
// Jeden mikroserwis bedzie obslugiwal klientow,
// Drugi obslugiwal kierowcow
// Trzeci moze ich spinac - cos na zasadzie centralnego serwera przyjmujacego zapytania o przejazdy od klientow, wysylajacego
// te zapytania do dostepnych kierowcow, ktorzy moga ale nie musza zaakceptowac przejazd (w jakims ograniczonym czasie)
// po czym potwierdzenie wraca do klienta z informacja ze kierowca jedzie w jego kierunku
// Mikroserwisy spinac bedziemy za pomoca tzw netflix eureka - poczytaj o Discovery Server/Discovery Client
// zapytania o przejazdy powinny byc transportowane za pomoca tzw message brokera - do twojego wyboru:
// Apache Kafka, RabbitMQ, ActiveMQ
// poczytaj o Feign i pomysl gdzie go uzyc w powyzszym

// po zaimplementowaniu powyzszego kolejnym krokiem bedzie stworzenie kolejnego mikroserwisu tzw API Gateway,
// bedzie on zbieral wszystkie endpointy z istniejacych mikroserwisow i odpowiednio przekazywal je (przez tzw routing)
// do odpowiednich mikroserwisow. Mikroserwis ten moze (ale nie musi) zawierac w sobie security - najlepiej na bazie JWT
// nie musi, bo ewentualnie mozna stworzyc osobny mikroserwis do autentykacji - twoj wybor

// oczywiscie w ramach powyzszego powinienes zastosowac wszystko co juz poznales :) czyli testy, walidacje, liquibase i tym podobne

// TODO poczytaj o wzorcach projektowych - factory, strategy, Domain Driven Design, Test Driven Design, fasady itp i sprobuj ktores zaimplementowac:
// https://refactoring.guru/design-patterns/java