package testpackage.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

//@DefaultUrl("https://new-lkmo.invitro.ru/")

public class AuthorizationPage extends WebPage {

    ///////////////////////////////////////X-Path's\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @FindBy(xpath = "//div[@class='panel-body']") // Блок Авторизации
    WebElementFacade AuthorizationBlock;

    @FindBy(xpath = "//input[@id='Username']") // Поле ввода Логина
    WebElementFacade UserNameField;

    @FindBy(xpath = "//input[@id='Password']") // Поле ввода Пароля
    WebElementFacade PasswordField;

    @FindBy(xpath = "//input[@id='RememberLogin']") // Чекбокс запомнить логин
    WebElementFacade CheckBoxRememberLogin;

    @FindBy(xpath = "//button[@class='btn btn-primary']") // Кнопка входа
    WebElementFacade EnterButton;

    @FindBy(xpath = "//button[@class='btn btn-default']") // Кнопка отмены
    WebElementFacade CancelButton;

    @FindBys({@FindBy(xpath = "//div[@class='panel-body']")})
    List<WebElementFacade> ssfsfsdf;

    //////////////////////////////////////////////Исполняемый код\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

/*    public MainPage Search(String search) {
        find(SearchInput).sendKeys(search);
        find(SearchButton).waitUntilClickable().click();
        waitABit(5000);

        return this;
    }*/

    public void maximize() {  // Изменение размера окна под размер экрана
        getDriver().manage().window().maximize();
    }

    public void checkAuthorizationBlock() { // Проверка на доступность блока авторизации в ЛКМО
        Assertions.assertThat(isElementEnabled(AuthorizationBlock))
                .as("Блок авторизации в ЛКМО не отображается")
                .isTrue();
    }

    public void enterUserNameField() { // Проверка ввода логина в поле 'Логин'
        Assertions.assertThat(isElementDisplayed(UserNameField))
                .as("Поле 'Логин' не отображается")
                .isTrue();
        Enter_Text(UserNameField, "testarm");
        Assertions.assertThat(element(UserNameField).getValue())
                .as("В поле 'Логин' введено другое значение")
                .isEqualTo("testarm");
    }

    public void enterPasswordField() { // Проверка ввода пароля в поле 'Пароль'
        Assertions.assertThat(isElementDisplayed(PasswordField))
                .as("Поле 'Пароль' не отображается")
                .isTrue();
        Enter_Text(PasswordField, "Nouser1");
        Assertions.assertThat(element(PasswordField).getValue())
                .as("В поле 'Пароль' введено другое значение")
                .isEqualTo("Nouser1");
    }

    public void checkCheckBoxRememberLogin() { // Проверка на доступность чекбокса 'Запомнить меня'
        Assertions.assertThat(isElementEnabled(CheckBoxRememberLogin))
                .as("Чекбокс 'Запомнить меня' не отображается")
                .isTrue();
    }

    public void clickEnterButton() { // Проверка нажатия на кнопку входа в ЛКМО
        Click_Method(EnterButton);
    }

    public void checkCancelButton() { // Проверка на доступность кнопки 'Отмена'
        Assertions.assertThat(isElementDisplayed(CancelButton))
                .as("Кнопка 'Отмена' не отображается")
                .isTrue();
    }


}
