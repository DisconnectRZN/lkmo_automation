package testpackage.pages;

import com.google.j2objc.annotations.Weak;
import net.serenitybdd.core.pages.WebElementFacade;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ChangeRaspisanieMOPage extends WebPage {

    ///////////////////////////////////////X-Path's\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @FindBy(xpath = "//td[@class='fc-day-top fc-mon fc-past']//span[@class='fc-day-number'][contains(text(),'11')]") // День календаря
    WebElementFacade CalendarDay;

    @FindBys({@FindBy(xpath = "//td[contains(@class,'fc-day ')]")})
    List<WebElementFacade> calendar;

    @FindBys({@FindBy(xpath = "//td[contains(@class,'fc-event-container')]")})
    List<WebElementFacade> TimeWork;

    By addRecordPath = By.xpath("./a");

    @FindBy(xpath = "//div[@class='modal-content']") // Поп-апе расписания
    WebElementFacade PopUpRaspisanie;

    @FindBy(xpath = "//button[@type='button'][@class='btn btn-outline-invitro']") // Кнопка сохранить на поп-апе расписания
    WebElementFacade SaveButton;

    @FindBy(xpath = "//select[@id='StartHours']") // Выбор времени начала работы МО
    WebElementFacade StartHours;

    @FindBy(xpath = "//select[@id='StartHours']//option[@value='15']") // Выбор времени начала работы МО
    WebElementFacade NewStartHours;

    @FindBy(xpath = "//select[@id='EndHours']//option[@value='16']") // Выбор времени начала работы МО
    WebElementFacade NewEndHours;

    @FindBy(xpath = "//select[@id='EndHours']") // Выбор времени окончания работы МО
    WebElementFacade EndHours;

    @FindBy(xpath = "//button[@class='btn btn-outline-invitro btn-danger']") // Кнопка удалить созданное расписание
    WebElementFacade DeleteButton;

    @FindBy(xpath = "//div[@class='jconfirm-box jconfirm-hilight-shake jconfirm-default jconfirm-type-animated']") // Поп ап подтвреждения удаления созданного расписания МО
    WebElementFacade PopUpAfterDeleteButton;

    @FindBy(xpath = "//div[@class='fc-content']") // Плитка расписания на день (Режим работы)
    WebElementFacade RaspisanieNaDen;

    @FindBy(xpath = "//button[@class='btn btn-blue']") // Кнопка ОК, после сохранения расписания
    WebElementFacade ButtonOk;

    @FindBy(xpath = "//button[@class='btn btn-outline-invitro']") // Кнопка Изменить элемент
    WebElementFacade ButtonChangeElement;

    @FindBy(xpath = "//div[@class='float-left']") // Лог ранее внесенных изменений
    WebElementFacade LogIzmeneniy;


    By weekPath = By.xpath("./ancestor::div[contains(@class,'fc-week')]");

    By daysInWeekPath = By.xpath(".//td[contains(@class,'fc-day ')]");

    By recordsPath = By.xpath("./div[@class='fc-content-skeleton']//tbody//td");

    By recordByttonPath = By.xpath("./a");

    //////////////////////////////////////////////Исполняемый код\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public List<WebElementFacade> getCurrentMonth() { // Проверка доступности колендаря и отображение каждого дня месяца
        List<WebElementFacade> result = new ArrayList<>();
        boolean currentMonth = false;
        for (WebElementFacade day : calendar) {
            if (!currentMonth && day.getAttribute("data-date").endsWith("01")) {
                currentMonth = true;
                result.add(day);
            } else if (currentMonth && day.getAttribute("data-date").endsWith("01")) {
                break;
            } else {
                result.add(day);
            }
        }
        return result;
    }

    public void openRecord(String day) { // Проверка доступности колендаря и отображение каждого дня месяца и открытие поп-апа добавления расписания
        for (WebElementFacade calendarDay : getCurrentMonth()) {
            if (calendarDay.getAttribute("data-date").endsWith(day)) {
                WebElementFacade addRecord = calendarDay.findBy(addRecordPath);
                addRecord.click();
                break;
            }

        }
    }

    public void checkPopUpRaspisanie() { // Проверка доступности поп-апа добавления расписания и сохранение стандартного режима работы
        Assertions.assertThat(isElementEnabled(PopUpRaspisanie))
                .as("Поп-ап открылся для создания или редактирования расписания")
                .isTrue();
        Assertions.assertThat(isElementEnabled(StartHours))
                .as("Дроплист выбора веремени начала работы отображается и доступно для просмотра")
                .isTrue();
        Assertions.assertThat(isElementEnabled(EndHours))
                .as("Дроплист выбора веремени окончания работы отображается и доступно для просмотра")
                .isTrue();
        Click_Method(SaveButton);
        Click_Method(ButtonOk);
        Assertions.assertThat(isElementEnabled(RaspisanieNaDen))
                .as("Плитка режим работы за день отображается")
                .isTrue();

    }


    public void openRecordTime(String day) { // Проверка доступности колендаря и отображение каждого дня месяца и открытие поп-апа добавления расписания
        for (WebElementFacade calendarDay : getCurrentMonth()) {
            if (calendarDay.getAttribute("data-date").endsWith(day)) {
                WebElementFacade week = weekByDay(calendarDay);
                int dayIndex = indexOfDayInWeek(week, day);
                WebElementFacade record = recordByIndex(week,dayIndex);
                record.click();
                break;
            }

        }
    }


    public WebElementFacade weekByDay(WebElementFacade day) {
        return day.findBy(weekPath);
    }

    public int indexOfDayInWeek(WebElementFacade week, String day) {
        List<WebElementFacade> daysOfWeek = week.thenFindAll(daysInWeekPath);
        for (int i = 0; i < daysOfWeek.size(); i++) {
            WebElementFacade dayInWeek = daysOfWeek.get(i);
            if (dayInWeek.getAttribute("data-date").endsWith(day)) {
                return i;
            }
        }
        Assert.fail("Не удалось найти день " + day + " в неделе календаря");
        return -1;
    }

    public WebElementFacade recordByIndex(WebElementFacade week, int dayIndex) {
        List<WebElementFacade> recordsOfWeek = week.thenFindAll(recordsPath);
        return recordsOfWeek.get(dayIndex).find(recordByttonPath);
    }

    public void changePopUpRaspisanie() {  // Проверка доступности расписания услуги у найденного МО
        Assertions.assertThat(isElementEnabled(PopUpRaspisanie))
                .as("Поп-ап открылся для создания или редактирования расписания")
                .isTrue();

    }
    public void changePopUp() {  // Проверка лога ранее весенных изменений
        Assertions.assertThat(isElementEnabled(LogIzmeneniy))
                .as("Лог ранее внесенных изменений отображается на поп-апе распиания")
                .isTrue();
        Click_Method(ButtonChangeElement);

    }

    public void changeStartHours() {  // Изменение время начала и время окончания работы МО
             Click_Method(StartHours);
             Click_Method(NewStartHours);
             Click_Method(EndHours);
             Click_Method(NewEndHours);
             Click_Method(ButtonChangeElement);
             Click_Method(ButtonOk);

    }

    public void clickDeleteButton() {  // Удаление ранее созданного расписания на выбранный день
        Click_Method(ButtonChangeElement);
        Click_Method(DeleteButton);
        Assertions.assertThat(isElementEnabled(PopUpAfterDeleteButton))
                .as("Поп ап подтверждения удаления ранее созданного, измененного расписания МО, отображается")
                .isTrue();
        Click_Method(ButtonOk);


    }
}
