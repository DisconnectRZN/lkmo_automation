package testpackage.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import testpackage.pages.MOdetailedPage;

public class MOdetailedPageSteps {
    MOdetailedPage page;

    @When("^Проверка отображения расписания на неделю у найденного МО$")
    public void checkTableWeek() { page.checkTableWeek(); }

    @When("^Проверка перехода к детальной информации найденного МО$")
    public void checkTestMO() { page.checkTestMO(); }


    @When("^Проверка отображения расписания на неделю внутри найденного МО$")
    public void checkMOWeek() { page.checkMOWeek(); }

    @When("^Проверка отображения услуги на неделю у найденного МО$")
    public void checkServiceTableWeek() { page.checkServiceTableWeek(); }


    @When("^Проверка отображения ссылки Расписание МО на месяц и перехода по ней$")
    public void checkMOTableMonth() { page.checkMOTableMonth(); }


    @When("^Проверка отображения Расписание услуги на месяц и перехода по ней$")
    public void checkServiceTableMonth() { page.checkServiceTableMonth(); }

    @When("^Проверка доступности заголовка открытого расписания МО$")
    public void checkHeading() { page.checkHeading(); }

    @When("^Проверка доступности блока выбора месяца в расписании МО$")
    public void checkMonthChangeBlock() { page.checkMonthChangeBlock(); }

    @When("^Проверка доступности кнопки выбора предыдущего месяца, у выбранного МО$")
    public void checkMonthChangeLeftButton() { page.checkMonthChangeLeftButton(); }

    @When("^Проверка отображения выбранного месяца, выбранного МО$")
    public void checkMonthEnterAfterChange() { page.checkMonthEnterAfterChange(); }

    @When("^Проверка доступности кнопки выбора следующего месяца, у выбранного МО$")
    public void checkMonthChangeRightButton() { page.checkMonthChangeRightButton(); }

    @When("^Проверка доступности календаря ранее выбранного МО$")
    public void checkScheduleCalendar() { page.checkScheduleCalendar(); }

    @When("^Проверка доступности кнопки открытия поп-апа календаря, у выбранного МО$")
    public void checkCalendarButton() { page.checkCalendarButton(); }

    @When("^Проверка доступности календаря поп-апа, у выбранного МО$")
    public void checkPopApCalendar() { page.checkPopApCalendar(); }

    @When("^Проверка доступности кнопки возврата к предпросмотру МО$")
    public void checkBackButton() { page.checkBackButton(); }

    @When("^Проверка доступности заголовка открытого расписания услуги в МО$")
    public void checkHeadingUsl() { page.checkHeadingUsl(); }

    @When("^Проверка доступности блока выбора месяца в расписании услуги в МО$")
    public void checkMonthChangeBlockUsl() { page.checkMonthChangeBlockUsl(); }

    @When("^Проверка доступности кнопки выбора предыдущего месяца, у услуги, выбранного МО$")
    public void checkMonthChangeLeftButtonUsl() { page.checkMonthChangeLeftButtonUsl(); }

    @When("^Проверка отображения выбранного месяца, у услуги, выбранного МО$")
    public void checkMonthEnterAfterChangeUsl() { page.checkMonthEnterAfterChangeUsl(); }

    @When("^Проверка доступности кнопки выбора следующего месяца, у услуги, выбранного МО$")
    public void checkMonthChangeRightButtonUsl() { page.checkMonthChangeRightButtonUsl(); }

    @When("^Проверка доступности календаря ранее услуги у выбранного МО$")
    public void checkScheduleCalendarUsl() { page.checkScheduleCalendarUsl(); }

    @When("^Проверка доступности кнопки открытия поп-апа календаря, усулги, у выбранного МО$")
    public void checkCalendarButtonUsl() { page.checkCalendarButtonUsl(); }

    @When("^Проверка доступности календаря поп-апа, у усулги, выбранного МО$")
    public void checkPopApCalendarUsl() { page.checkPopApCalendarUsl(); }


}
