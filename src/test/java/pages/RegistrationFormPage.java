package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author mateenkov
 */

public class RegistrationFormPage {
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    CalendarComponent calendarComponent = new CalendarComponent();
    SelenideElement firstNameInput = $("#firstName"),
            lastnameInput = $("#lastName"),
            genderWrapper = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            emailInput = $("#userEmail"),
            titleForm = $(".practice-form-wrapper"),
            buttonSubmit = $("#submit"),
            subjectInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            inputAddress = $("#currentAddress"),
            selectState = $(byTagAndText("div", "Select State")),
            selectCity = $(byTagAndText("div", "Select City")),
            titleResultTable = $(".modal-header"),
            resultTable = $(".modal-body"),
            subjectDropDown = $(".subjects-auto-complete__menu"),
            hobbiesWrapper = $("#hobbiesWrapper");

    public RegistrationFormPage checkTitleTableAndTableResult(String value) {
        titleResultTable.shouldHave(Condition.exactText(value));
        resultTable.shouldBe(Condition.visible);

        return this;
    }

    public RegistrationFormPage openPage(String title) {
        open("/automation-practice-form");
        titleForm.shouldHave(Condition.text(title));

        return this;
    }

    public RegistrationFormPage removeBanner() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subjectInput.setValue(value);
        subjectDropDown.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setState(String state) {
        selectState.scrollTo().click();
        $(byTagAndText("div", state)).click();

        return this;
    }

    public RegistrationFormPage setCity(String city) {
        selectCity.scrollTo().click();
        $(byTagAndText("div", city)).click();

        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setAddress(String address) {
        inputAddress.setValue(address);

        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage pressSubmit() {
        buttonSubmit.scrollTo().click();

        return this;
    }

    public RegistrationFormPage setEmailUser(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastnameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderWrapper.$(byTagAndText("label", value)).click();

        return this;
    }

    public RegistrationFormPage setNumberPhone(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setDateBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDateBirth(day, month, year);

        return this;
    }

    public RegistrationFormPage checkResults(String key, String value) {
        resultTableComponent.checkResult(key, value);

        return this;
    }
}
