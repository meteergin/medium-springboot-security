package com.meteergin.mediumspringbootsecurity.config;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.meteergin.mediumspringbootsecurity.entity.Employee;
import com.meteergin.mediumspringbootsecurity.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeService employeeService) {
        return args -> {
            List<Employee> employeeList = generateRandomEmployees(10);
            employeeService.saveAll(employeeList);
        };
    }

    private List<Employee> generateRandomEmployees(int numberOfEmployees) {
        List<Employee> employeeList = new ArrayList();
        Faker faker = null;
        Name name = null;

        for (int i = 0; i < numberOfEmployees; i++) {
            faker = Faker.instance();
            name = faker.name();

            String firstName = name.firstName();
            String lastName = name.lastName();

            Employee employee = Employee.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .birthDay(faker.date().birthday(20, 60))
                    .prefix(name.prefix())
                    .title(name.title())
                    .email(generateEmail(firstName, lastName))
                    .status(1)
                    .build();

            employeeList.add(employee);
        }

        LOGGER.info("******************************");
        LOGGER.info(numberOfEmployees + " test emplooyees were created.");
        LOGGER.info("******************************");

        return employeeList;
    }

    private String generateEmail(String firstName, String lastName) {
        String email = "";

        String[] splitedFirstName = firstName.toLowerCase().split(" ");
        String[] splitedLastName = lastName.toLowerCase().split(" ");

        for (String fn : splitedFirstName) {
            email += fn.concat(".");
        }

        for (String fn : splitedLastName) {
            email += fn.concat(".");
        }

        if (email.length() > 0) {
            email = email.substring(0, email.length() - 1);
        }

        return email.concat("@company.com");
    }
}
