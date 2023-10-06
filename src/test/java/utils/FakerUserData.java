package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

/**
 * @author mateenkov
 */

public class FakerUserData {
    Faker faker = new Faker(new Locale("en"));

    public String getName() {
        return (faker.name().firstName());
    }

    public String getLastName() {
        return (faker.name().lastName());
    }

    public String getGender() {
        String[] gender = {"Male", "Female", "Other"};
        return (faker.options().option(gender));
    }

    public String getEmail() {
        return (faker.internet().emailAddress());
    }

    public String getPhone() {
        return (faker.phoneNumber().subscriberNumber(10));
    }

    public String getDay() {
        return String.valueOf((faker.number().numberBetween(1, 28)));
    }

    public String getMonth() {
        String[] month = {"August", "September", "October", "November", "December", "January",
                "February", "March", "April", "May", "June", "July"};
        return (faker.options().option(month));
    }

    public String getYear() {
        return String.valueOf((faker.number().numberBetween(1946, 2005)));
    }

    public String getSubjects() {
        String[] subjects = {"Physics", "English", "Commerce"};
        return (faker.options().option(subjects));
    }

    public String getHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return (faker.options().option(hobbies));
    }

    public String getFiles() {
        String[] files = {"file1", "file2", "file3"};
        return (faker.options().option(files));
    }

    public String getAddress() {
        return (faker.address().fullAddress());
    }

    public String getState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(state);
    }

    public String getCity(String value) {
        return switch (value) {
            case ("NCR") -> {
                String[] arrayNCR = {"Delhi", "Gurgaon", "Noida"};
                yield faker.options().option(arrayNCR);
            }
            case ("Uttar Pradesh") -> {
                String[] arrayUttar = {"Agra", "Lucknow", "Merrut"};
                yield faker.options().option(arrayUttar);
            }
            case ("Haryana") -> {
                String[] arrayHaryana = {"Karnal", "Panipat"};
                yield faker.options().option(arrayHaryana);
            }
            case ("Rajasthan") -> {
                String[] arrayRajasthan = {"Jaipur", "Jaiselmer"};
                yield faker.options().option(arrayRajasthan);
            }
            default -> "Not found";
        };
    }
}
