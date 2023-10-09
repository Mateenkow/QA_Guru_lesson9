package pages.components;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author mateenkov
 */

public class CalendarComponent {
    public void setDateBirth(String day, String month, String year) {
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--0" + day
                + ":not(.react-datepicker__day--outside-month)").click();
    }
}
