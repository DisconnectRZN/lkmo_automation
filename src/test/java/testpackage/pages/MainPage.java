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

public class MainPage extends WebPage {

    ///////////////////////////////////////X-Path's\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @FindBy(xpath = "//a[@class='navbar-brand']") // Логотип Инвитро
    WebElementFacade InvitroLogo;

    @FindBy(xpath = "//span[@class='navbar-text']") // UserName авторизованного пользователя
    WebElementFacade UserName;

    @FindBy(xpath = "//i[@class='fa fa-door-open pointer']") // UserName авторизованного пользователя
    WebElementFacade ExitButton;

    @FindBy(xpath = "//h3") // Заголовок Медецинские офисы
    WebElementFacade TitleMedOffices;

    @FindBy(xpath = "//div[@class='table-filters-top']") // Фильтр поиска в системе ЛКМО
    WebElementFacade LKMOfilter;

    @FindBy(xpath = "//div[@id='OfficesTable']") // Таблица офисов
    WebElementFacade OfficesTable;

    @FindBy(xpath = "//input[@class='text-input search-input-text']") // Поле поиска по названию
    WebElementFacade SearchField;

    @FindBy(xpath = "//*[@data-id='AgglomerationId']") // Поле Агломерация
    WebElementFacade AgglomerationField;

    @FindBy(xpath = "//*[@class='dropdown-menu inner show']//*[contains(text(),'Автотесты')]") // Поле Агломерация - Автотесты
    WebElementFacade Agglomeration;

    @FindBy(xpath = "//div[@class='dropdown bootstrap-select form-control']//*[@id='AgglomerationId']//*[contains(text(),'Автотесты')]") // Поле Агломерация - Автотесты
    WebElementFacade AutoTestAgglomeration;

    @FindBy(xpath = "//button[@data-id='Status']") // Поле Статус
    WebElementFacade StatusField;

    @FindBy(xpath = "//*[@class='dropdown-menu inner show']//*[contains(text(),'Закрыт')]") // Поле Статус - Закрыт
    WebElementFacade Status;

    @FindBy(xpath = "//div[@class='dropdown bootstrap-select show-tick form-control show']//*[@id='Status']//*[contains(text(),'Закрыт')]") // Поле Статус - Закрыт
    WebElementFacade CloseStatus;

    @FindBy(xpath = "//button[@data-id='AssistentId']")  // Поле Менеджер/Ассистент
    WebElementFacade AssistentField;

    @FindBy(xpath = "//*[@class='dropdown-menu inner show']//*[contains(text(),'Пользователь Тестовый АРМПС2 Тестовый')]") // Поле Менеджер/Ассистент - Пользователь Тестовый АРМПС2 Тестовый
    WebElementFacade Assistent;

    @FindBy(xpath = "//div[@class='dropdown bootstrap-select show-tick form-control show']//*[@id='AssistentId']//*[contains(text(),'Пользователь Тестовый АРМПС2 Тестовый')]") // Поле Менеджер/Ассистент - Пользователь Тестовый АРМПС2 Тестовый
    WebElementFacade TestUserAssistent;

    @FindBy(xpath = "//button[@data-id='Country']") // Поле Страна
    WebElementFacade CountryField;

    @FindBy(xpath = "//*[@class='dropdown-menu show']//*[contains(text(),'Украина')]") // Поле Страна - Украина
    WebElementFacade Country;

    @FindBy(xpath = "//div[@class='dropdown bootstrap-select form-control']//*[@id='Country']//*[contains(text(),'Украина')]") // Поле Страна - Украина
    WebElementFacade UkraineCountry;

    @FindBy(xpath = "//button[@data-id='RegionId']") // Поле Регион
    WebElementFacade RegionField;

    @FindBy(xpath = "//*[@class='dropdown-menu inner show']//*[contains(text(),'Харьковская область')]") // Поле Регион - Харьковская область
    WebElementFacade Region;

    @FindBy(xpath = "//div[@class='dropdown bootstrap-select form-control']//*[@id='RegionId']//*[contains(text(),'Харьковская область')]") // Поле Регион - Харьковская область
    WebElementFacade KharkivRegion;

    @FindBy(xpath = "//button[@data-id='CityId']") // Поле Город
    WebElementFacade CityField;

    @FindBy(xpath = "//*[@class='dropdown-menu show']//*[contains(text(),'Харьков')]") // Поле Город - Харьков
    WebElementFacade City;

    @FindBy(xpath = "//div[@class='dropdown bootstrap-select form-control']//*[@id='CityId']//*[contains(text(),'Харьков')]") // Поле Город - Харьков
    WebElementFacade KharkivCity;

    @FindBy(xpath = "//tr[@class='table-row-first']") // Первая строка таблицы
    WebElementFacade FirstFieldAfterSearch;

    @FindBy(xpath = "//input[@id='smartSearchClear']") // Кнопка сбросить фильтр поиска
    WebElementFacade SearchClearButton;


    //////////////////////////////////////////////Исполняемый код\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void maximize() {  // Изменение размера окна под размер экрана
        getDriver().manage().window().maximize();
    }

    public void checkInvitroLogo() { // Проверка доступности логотипа INVITRO
        Assertions.assertThat(isElementEnabled(InvitroLogo))
                .as("Логотип INVITRO (ссылка на главную страницу) отображается")
                .isTrue();
    }

    public void checkUserName() { // Проверка доступности UserName в шапке
        Assertions.assertThat(isElementEnabled(UserName))
                .as("UserName авторизовавшегося пользователя отображается")
                .isTrue();
    }

    public void checkExitButton() { // Проверка доступности кнопки выхода из ЛКМО
        Assertions.assertThat(isElementEnabled(ExitButton))
                .as("Кнопка выхода из ЛКМО доступна и отображается")
                .isTrue();
        Click_Method(ExitButton);
    }

    public void checkLKMOfilter() { // Проверка доступности фильтра поиска МО
        Assertions.assertThat(isElementEnabled(LKMOfilter))
                .as("Фильтр поиска МО отображается")
                .isTrue();
    }

    public void checkOfficesTable() { // Проверка доступности таблицы МО
        Assertions.assertThat(isElementEnabled(OfficesTable))
                .as("Таблица МО доступна и отображается")
                .isTrue();
    }

    public void enterSearchField() { // Проверка поиска МО
        Assertions.assertThat(isElementDisplayed(SearchField))
                .as("Поле 'Поиска' не отображается")
                .isTrue();
        Enter_Text(SearchField, "Тестовый офис 2");
        Assertions.assertThat(element(SearchField).getValue())
                .as("В поле 'Поиска' введено другое значение")
                .isEqualTo("Тестовый офис 2");
        Actions actions = new Actions(getDriver());
        actions.sendKeys(SearchField, Keys.ENTER).perform();
        Assertions.assertThat(isElementDisplayed(FirstFieldAfterSearch))
                .as("Искомое МО не найдено")
                .isTrue();

    }

    public void checkSearchClearButton() { // Проверка доступности кнопки сброса поиска
        Assertions.assertThat(isElementEnabled(SearchClearButton))
                .as("Кнопка сбросить из ЛКМО доступна")
                .isTrue();
        SearchClearButton.waitUntilClickable();
        SearchClearButton.click();
        Assertions.assertThat(element(SearchField).getValue())
                .as("В поле 'Поиска' введено значение. Сброс фильтра не сработал")
                .isEmpty();
    }

    public void enterAgglomeration() { // Проверка поиска МО по Агломерации
        Assertions.assertThat(isElementDisplayed(AgglomerationField));
        AgglomerationField.waitUntilClickable();
        AgglomerationField.click();
        Assertions.assertThat(isElementDisplayed(Agglomeration))
                .as("В списке поля 'Агломерации' не найдена агломерация 'Автотесты'")
                .isTrue();
        Agglomeration.click();
        Assertions.assertThat(isElementDisplayed(AutoTestAgglomeration));
        Assertions.assertThat(isElementDisplayed(FirstFieldAfterSearch))
                .as("Искомое МО не найдено")
                .isTrue();
        SearchClearButton.click();

    }

    public void enterStatus() { // Проверка поиска МО по полю Статус
        Assertions.assertThat(isElementDisplayed(StatusField));
        StatusField.waitUntilClickable();
        StatusField.click();
        Assertions.assertThat(isElementDisplayed(Status))
                .as("В списке поля 'Статус' не найден статус 'Закрыт'")
                .isTrue();
        Status.click();
        Assertions.assertThat(isElementDisplayed(CloseStatus));
        Assertions.assertThat(isElementDisplayed(FirstFieldAfterSearch))
                .as("Искомое МО не найдено")
                .isTrue();
        SearchClearButton.click();

    }

    public void enterAssistent() { // Проверка поиска МО по полю Менеджер/Ассистент
        Assertions.assertThat(isElementDisplayed(AssistentField));
        AssistentField.waitUntilClickable();
        AssistentField.click();
        Assertions.assertThat(isElementDisplayed(Assistent))
                .as("В списке поля 'Менеджер/Ассистент' не найден Менеджер/Ассистент 'Пользователь Тестовый АРМПС2 Тестовый'")
                .isTrue();
        Assistent.click();
        Assertions.assertThat(isElementDisplayed(TestUserAssistent));
        Assertions.assertThat(isElementDisplayed(FirstFieldAfterSearch))
                .as("Искомое МО не найдено")
                .isTrue();
        SearchClearButton.click();

    }

    public void enterCountryRegionCity() { // Проверка поиска МО по полям Страна, Регион, Город
        Assertions.assertThat(isElementDisplayed(CountryField));
        CountryField.waitUntilClickable();
        CountryField.click();
        Assertions.assertThat(isElementDisplayed(Country))
                .as("В списке поля 'Страна' не найдена страна 'Украина'")
                .isTrue();
        Country.click();
        Assertions.assertThat(isElementDisplayed(UkraineCountry));
        Assertions.assertThat(isElementDisplayed(FirstFieldAfterSearch))
                .as("Искомое МО не найдено")
                .isTrue();
        Assertions.assertThat(isElementDisplayed(RegionField));
        RegionField.waitUntilClickable();
        RegionField.click();
        Assertions.assertThat(isElementDisplayed(Region))
                .as("В списке поля 'Регион' не найден регион 'Харьковская область'")
                .isTrue();
        Region.click();
        Assertions.assertThat(isElementDisplayed(KharkivRegion));
        Assertions.assertThat(isElementDisplayed(FirstFieldAfterSearch))
                .as("Искомое МО не найдено")
                .isTrue();
        Assertions.assertThat(isElementDisplayed(CityField));
        CityField.waitUntilClickable();
        CityField.click();
        Assertions.assertThat(isElementDisplayed(City))
                .as("В списке поля 'Город' не найдена город 'Харьков'")
                .isTrue();
        City.click();
        Assertions.assertThat(isElementDisplayed(KharkivCity));
        Assertions.assertThat(isElementDisplayed(FirstFieldAfterSearch))
                .as("Искомое МО не найдено")
                .isTrue();
    }

}
