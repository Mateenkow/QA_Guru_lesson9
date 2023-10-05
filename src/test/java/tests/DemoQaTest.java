package tests;

import data.UserData;
import driver.BaseTest;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

/**
 * @author mateenkov
 */

public class DemoQaTest extends BaseTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    UserData ud = new UserData();

    @Test
    void registrationFormTest() {
        registrationFormPage.openPage("Student Registration Form")
                .removeBanner()
                .setFirstName(ud.name)
                .setLastName(ud.lastName)
                .setGender(ud.gender)
                .setEmailUser(ud.email)
                .setNumberPhone(ud.phone)
                .setDateBirth(ud.day, ud.month, ud.year)
                .setSubject(ud.subjects)
                .setHobbies(ud.hobbies)
                .uploadPicture(ud.files)
                .setAddress(ud.address)
                .setState(ud.state)
                .setCity(ud.city)
                .pressSubmit();

        registrationFormPage.checkTitleTableAndTableResult("Thanks for submitting the form")
                .checkResults("Student Name", ud.name + " " + ud.lastName)
                .checkResults("Student Email", ud.email)
                .checkResults("Gender", ud.gender)
                .checkResults("Mobile", ud.phone)
                .checkResults("Date of Birth", ud.day + " " + ud.month + "," + ud.year)
                .checkResults("Subjects", ud.subjects)
                .checkResults("Hobbies", ud.hobbies)
                .checkResults("Picture", ud.files)
                .checkResults("Address", ud.address)
                .checkResults("State and City", ud.state + " " + ud.city);
    }
}