package testpackage.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import testpackage.pages.MainPage;

public class MainPageSteps {

    MainPage page;

    @When("^Проверить отображение логотипа Invitro$")
    public void checkInvitroLogo() { page.checkInvitroLogo(); }

    @When("^Проверить отображение UserName авторизованного пользователя$")
    public void checkUserName() { page.checkUserName(); }

    @When("^Проверить отображение фильтра поиска МО$")
    public void checkLKMOfilter() { page.checkLKMOfilter(); }

    @When("^Проверить доступность и отображение таблицы МО$")
    public void checkOfficesTable() { page.checkOfficesTable(); }

    @When("^Проверка поиска МО по его названию$")
    public void enterSearchField() { page.enterSearchField(); }

    @When("^Проверка поиска МО по его агломерации$")
    public void enterAgglomeration() { page.enterAgglomeration(); }

    @When("^Проверка поиска МО по его статусу$")
    public void enterStatus() { page.enterStatus(); }

    @When("^Проверка поиска МО по полю Менеджер/Ассистент$")
    public void enterAssistent() { page.enterAssistent(); }

    @When("^Проверка поиска МО по полям Страна, Регион, Город$")
    public void enterCountryRegionCity() { page.enterCountryRegionCity(); }

    @When("^Проверить доступности кнопки выхода из ЛКМО и ее нажатие$")
    public void checkExitButton() { page.checkExitButton(); }

    @When("^Проверить доступности кнопки Сброса фильтра поиска ее нажатие$")
    public void checkSearchClearButton() { page.checkSearchClearButton(); }

}
