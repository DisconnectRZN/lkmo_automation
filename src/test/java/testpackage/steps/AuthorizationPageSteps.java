package testpackage.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import testpackage.pages.AuthorizationPage;

import java.util.concurrent.TimeUnit;

public class AuthorizationPageSteps {

    AuthorizationPage page;

    @Given("Открыть главную страницу сайта$")
    public void openPage() {
        page.open();
    }

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

    @When("^Проверка нажатия на кнопку входа в ЛКМО$")
    public void clickEnterButton() {
        page.clickEnterButton();
    }
}
