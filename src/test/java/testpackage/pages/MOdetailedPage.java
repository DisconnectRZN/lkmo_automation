package testpackage.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class MOdetailedPage extends WebPage {

    ///////////////////////////////////////X-Path's\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @FindBy(xpath = "//table[@class='schedule-table-week']") // Таблица расписания найденного МО в предпросмотре
    WebElementFacade TableWeek;

    @FindBy(xpath = "//a[@class='font-black font-12']") // Найденное МО
    WebElementFacade TestMO;

    @FindBy(xpath = "//div[@id='SpecificOfficeWrapper']") // Таблица расписания найденного МО
    WebElementFacade MOWeek;

    @FindBy(xpath = "//div[@id='ServicesWrapper']//*[@class='table']") // Таблица расписания услуги у найденного МО
    WebElementFacade ServiceTableWeek;

    @FindBy(xpath = "//div[@id='SpecificOfficeWrapper']//div[@class='pt-sm']//*[contains(text(),'Расписание на месяц')]") // Ссылка расписание МО на месяц
    WebElementFacade MOTableMonth;

    @FindBy(xpath = "//div[@id='ServicesWrapper']//*[@class='pt-sm']") // Ссылка расписание услуги на месяц
    WebElementFacade ServiceTableMonth;

    @FindBy(xpath = "//div[@class='breadcrumb-item']") // Ссылка к детальной информации МО
    WebElementFacade BackButton;

    @FindBy(xpath = "//h3") // Заголовок
    WebElementFacade Heading;

    @FindBy(xpath = "//div[@class='fc-left']") // Блок выбора месяца
    WebElementFacade MonthChangeBlock;

    @FindBy(xpath = "//button[@class='fc-prevBtn-button fc-button fc-state-default']") // Кнопка влево, блока смены месяца
    WebElementFacade MonthChangeLeftButton;

    @FindBy(xpath = "//button[@class='fc-nextBtn-button fc-button fc-state-default']") // Кнопка вправо, блока смены месяца
    WebElementFacade MonthChangeRightButton;

    @FindBy(xpath = "//h2") // Название выбранного месяца
    WebElementFacade MonthEnterAfterChange;

    @FindBy(xpath = "//div[@class='fc-view-container']") // Календарь расписания
    WebElementFacade ScheduleCalendar;

    @FindBy(xpath = "//button[@class='fc-dateIco-button fc-button fc-state-default fc-corner-left fc-corner-right']") // Кнопка календаря расписания
    WebElementFacade CalendarButton;

    @FindBy(xpath = "//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom']") // ПопАп календаря расписания
    WebElementFacade PopApCalendar;

    //////////////////////////////////////////////Исполняемый код\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void checkTableWeek() { // Проверка доступности расписания МО в предпросмотре
        Assertions.assertThat(isElementEnabled(TableWeek))
                .as("Расписания на неделю у найденного МО, отображается")
                .isTrue();
    }

    public void checkMOWeek() {  // Проверка доступности расписания МО в детальнйо информации МО
        Assertions.assertThat(isElementEnabled(MOWeek))
                .as("Расписания на неделю внутри МО, отображается")
                .isTrue();
    }

    public void checkTestMO() { // Проверка доступности МО и перехода к детальной информации МО
        Assertions.assertThat(isElementEnabled(TestMO))
                .as("МО открылось для детального просмотра")
                .isTrue();
        Click_Method(TestMO);
    }

    public void checkServiceTableWeek() {  // Проверка доступности расписания услуги у найденного МО
        Assertions.assertThat(isElementEnabled(ServiceTableWeek))
                .as("Расписания услуги на неделю внутри МО, отображается")
                .isTrue();
    }

    public void checkMOTableMonth() { // Проверка доступности расписания МО на месяц и перехода к детальной информации
        Assertions.assertThat(isElementEnabled(MOTableMonth))
                .as("Расписание МО на месяц доступно и открылось для детального просмотра")
                .isTrue();
        Click_Method(MOTableMonth);
    }

    public void checkServiceTableMonth() { // Проверка доступности расписания услуги МО и перехода к детальной информации
        Assertions.assertThat(isElementEnabled(ServiceTableMonth))
                .as("Расписание услуги на месяц доступно и открылось для детального просмотра")
                .isTrue();
        Click_Method(ServiceTableMonth);
    }

    public void checkHeading() { // Проверка доступности заголовка открытого расписания МО
        Assertions.assertThat(isElementEnabled(Heading))
                .as("Заголовок открытого расписания МО, отображается")
                .isTrue();
    }
    public void checkMonthChangeBlock() { // Проверка доступности блока выбора месяца в расписании МО
        Assertions.assertThat(isElementEnabled(MonthChangeBlock))
                .as("Блок выбора месяца в расписании МО, отображается")
                .isTrue();
    }
    public void checkMonthChangeLeftButton() { // Проверка доступности кнопки выбора предыдущего месяца, у выбранного МО
        Assertions.assertThat(isElementEnabled(MonthChangeLeftButton))
                .as("Кнопка выбора расписания за предыдущий месяц, отображается. Отрабатывает корректно")
                .isTrue();
        Click_Method(MonthChangeLeftButton);
    }
    public void checkMonthEnterAfterChange() { // Проверка отображения выбранного месяца, выбранного МО
        Assertions.assertThat(isElementEnabled(MonthEnterAfterChange))
                .as("Выбранный месяц МО у найденного МО, отображается")
                .isTrue();
    }

    public void checkMonthChangeRightButton() { // Проверка доступности кнопки выбоара следующего месяца, у выбранного МО
        Assertions.assertThat(isElementEnabled(MonthChangeRightButton))
                .as("Кнопка выбора расписания за следующий месяц, отображается. Отрабатывает корректно")
                .isTrue();
        Click_Method(MonthChangeRightButton);
    }

    public void checkScheduleCalendar() { // Проверка доступности календаря ранее выбранного МО
        Assertions.assertThat(isElementEnabled(ScheduleCalendar))
                .as("Месечный календарь у найденного МО, отображается")
                .isTrue();
    }

    public void checkCalendarButton() { // Проверка доступности кнопки открытия поп-апа календаря, у выбранного МО
        Assertions.assertThat(isElementEnabled(CalendarButton))
                .as("Кнопка открытия поп-апа календаря, отображается. Отрабатывает поп-ап корректно")
                .isTrue();
        Click_Method(CalendarButton);
    }

    public void checkPopApCalendar() { // Проверка доступности календаря поп-апа, у выбранного МО
        Assertions.assertThat(isElementEnabled(PopApCalendar))
                .as("Кальендарь поп-апа на месяц у найденного МО, отображается")
                .isTrue();
    }

    public void checkBackButton() { // Проверка доступности кнопки возврата к предпросмотру МО
        Assertions.assertThat(isElementEnabled(BackButton))
                .as("Кнопка возврата к форме предпросмотра МО, отображается. Возврат проходит корректно")
                .isTrue();
        Click_Method(BackButton);
    }
}
