package testpackage.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import testpackage.pages.AuthorizationPage;

public class AuthorizationPageSteps {

    AuthorizationPage page;

    @Given("Открыть главную страницу сайта$")
    public void openPage() { page.open(); }

    @Given("Открыть главную страницу сайта RMS$")
    public void openRmsPage() {
        page.setDefaultBaseUrl("http://testarm@invitro.ru:Nouser1@10.10.10.222:50505");
        page.open(); }

    @When("^Проверить отображение блока авторизации в ЛКМО$")
    public void checkAuthorizationBlock() { page.checkAuthorizationBlock(); }

    @When("^Проверить отображения и ввода логина в поле 'Логин'$")
    public void enterUserNameField() {
        page.enterUserNameField();
    }

    @When("^Проверить отображения и ввода пароля в поле 'Пароль'$")
    public void enterPasswordField() {
        page.enterPasswordField();
    }

    @When("^Проверка на доступность чекбокса 'Запомнить меня'$")
    public void checkCheckBoxRememberLogin() {
        page.checkCheckBoxRememberLogin();
    }

    @When("^Проверка отображения кнопки 'Отмена'$")
    public void checkCancelButton() {
        page.checkCancelButton();
    }

    @When("^Проверка ввода Логина и Пароля и входа в ЛКМО$")
    public void enterLoginPasswordField() { page.enterLoginPasswordField(); }

    @When("^Проверка некорректного ввода Логина и Пароля$")
    public void enterIncorrectLoginPassword() {
        page.enterIncorrectLoginPassword();
    }

    @When("^Проверка нажатия на кнопку входа в ЛКМО$")
    public void clickEnterButton() { page.clickEnterButton(); }
}
