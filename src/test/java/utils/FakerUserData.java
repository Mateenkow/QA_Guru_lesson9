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
        String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"};
        return faker.options().option(days);
    }

    public String getMonth() {
        String[] month = {"August", "September", "October", "November", "December", "January",
                "February", "March", "April", "May", "June", "July"};
        return (faker.options().option(month));
    }

    public String getYear() {
        return String.valueOf((faker.number().numberBetween(1940, 2005)));
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
        String result;
        switch (value) {
            case "NCR": {
                String[] arrayNCR = {"Delhi", "Gurgaon", "Noida"};
                result = faker.options().option(arrayNCR);
                break;
            }
            case "Uttar Pradesh": {
                String[] arrayUttar = {"Agra", "Lucknow", "Merrut"};
                result = faker.options().option(arrayUttar);
                break;
            }
            case "Haryana": {
                String[] arrayHaryana = {"Karnal", "Panipat"};
                result = faker.options().option(arrayHaryana);
                break;
            }
            case "Rajasthan": {
                String[] arrayRajasthan = {"Jaipur", "Jaiselmer"};
                result = faker.options().option(arrayRajasthan);
                break;
            }
            default: result = "Not found";
        };
        return result;
    }
}
