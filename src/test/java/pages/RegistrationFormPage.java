package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Проверка результаттов заполнения формы")
    public RegistrationFormPage checkTitleTableAndTableResult(String value) {
        titleResultTable.shouldHave(Condition.exactText(value));
        resultTable.shouldBe(Condition.visible);

        return this;
    }

    @Step("Открыть страницу")
    public RegistrationFormPage openPage(String title) {
        open("/automation-practice-form");
        titleForm.shouldHave(Condition.text(title));

        return this;
    }

    @Step("Удалить рекламный банер")
    public RegistrationFormPage removeBanner() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("Заполнить поле тема")
    public RegistrationFormPage setSubject(String value) {
        subjectInput.setValue(value);
        subjectDropDown.$(byText(value)).click();

        return this;
    }

    @Step("Выбрать штат")
    public RegistrationFormPage setState(String state) {
        selectState.scrollTo().click();
        $(byTagAndText("div", state)).click();

        return this;
    }

    @Step("Выбрать город")
    public RegistrationFormPage setCity(String city) {
        selectCity.scrollTo().click();
        $(byTagAndText("div", city)).click();

        return this;
    }

    @Step("Загрузить изображение")
    public RegistrationFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    @Step("Заполнить поле адрес")
    public RegistrationFormPage setAddress(String address) {
        inputAddress.setValue(address);

        return this;
    }

    @Step("Выбрать хобби")
    public RegistrationFormPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Нажать кнопку подтвердить")
    public RegistrationFormPage pressSubmit() {
        buttonSubmit.scrollTo().click();

        return this;
    }
    @Step("Заполнить поле email")
    public RegistrationFormPage setEmailUser(String value) {
        emailInput.setValue(value);

        return this;
    }
    @Step("Заполнить поле Имя")
    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    @Step("Заполнить поле Фамилия")
    public RegistrationFormPage setLastName(String value) {
        lastnameInput.setValue(value);

        return this;
    }
    @Step("Выбрать гендер")
    public RegistrationFormPage setGender(String value) {
        genderWrapper.$(byTagAndText("label", value)).click();

        return this;
    }
    @Step("Заполнить поле номер телефона")
    public RegistrationFormPage setNumberPhone(String value) {
        numberInput.setValue(value);

        return this;
    }
    @Step("Задать дату рождения")
    public RegistrationFormPage setDateBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDateBirth(day, month, year);

        return this;
    }
    @Step("Проверка результата")
    public RegistrationFormPage checkResults(String key, String value) {
        resultTableComponent.checkResult(key, value);
        return this;
    }
}
