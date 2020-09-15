package testpackage.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import testpackage.pages.MainPage;

import java.util.concurrent.TimeUnit;

public class MainPageSteps {

    MainPage page;

    @Before()
    public void closeSafari() {
        System.out.println(System.getProperty("os.name"));
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Runtime.getRuntime().exec("killall Safari");
                System.out.println("Safari closed");
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Given("Открыть главную страницу сайта$")
    public void openPage() {

        int count = 0;
        while (count < 10) {
            try {
                page.maximize();
                page.open();
                //page.сlickYes_and_close_cookie(); //Этот метод только для Рязани включается в связи с определением местоположения
                WebDriver driver = page.getDriver();

                Cookie SubscribeApplet = new Cookie("subscr", "accepted");
                driver.manage().addCookie(SubscribeApplet);

                Cookie CookieApplet = new Cookie("WARNINGS[cookie]", "cookie");
                driver.manage().addCookie(CookieApplet);

                Cookie CityApplet = new Cookie("IS_USER_INSTALL", "1");
                driver.manage().addCookie(CityApplet);

                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
                driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);

                page.setDriver(driver);
                page.open();
                page.closeAttentionPopUp();
                page.closeWidget();
                page.waitForBurgerMenuClickable();
                break;
            } catch (WebDriverException e) {
                e.printStackTrace();
                count++;
                if (count == 10) {
                    throw e;
                }
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                //throw new Error("network server is slow..check internet connection");
            }
        }

        //page.Check_Subscribe_Applet();
        //page.AcceptCookie();

    }

    @Given("Открыть главную страницу сайта с выбором города$")
    public void openPageWithCity() {

        int count = 0;
        while (count < 10) {
            try {
                page.maximize();
                page.open();
                //page.сlickYes_and_close_cookie(); //Этот метод только для Рязани включается в связи с определением местоположения
                WebDriver driver = page.getDriver();

                Cookie SubscribeApplet = new Cookie("subscr", "accepted");
                driver.manage().addCookie(SubscribeApplet);

                Cookie CookieApplet = new Cookie("WARNINGS[cookie]", "cookie");
                driver.manage().addCookie(CookieApplet);

                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
                driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);

                page.setDriver(driver);
                page.open();
                page.closeAttentionPopUp();
                page.waitForBurgerMenuClickable();
                break;
            } catch (WebDriverException e) {
                e.printStackTrace();
                count++;
                if (count == 10) {
                    throw e;
                }
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    @When("^Проверка отображения блока Header меню: Пациентам, Врачам, Франчайзинг, Корпоративным клиентам, Журналистам$")
    public void checkHeaderMenu() {
        page.checkHeaderMenu();
    }

    @When("Проверка отображения блока выбранного города")
    public void checkHeaderCity() {
        page.checkHeaderCity();
    }

    @When("^Проверка отображения pop-up выбора города$")
    public void checkHeaderChangeCityPopUp() {
        page.checkHeaderChangeCityPopUp();
    }

    @When("^Проверка отображения кнопки 'Входа в кабинет пацинета'$")
    public void checkHeaderEnterInLK() {
        page.checkHeaderEnterInLK();
    }

    @When("Проверка отображения логотипа ИНВИТРО")
    public void visibleInvitroLogo() {
        page.visibleInvitroLogo();
    }

    @When("Проверка отображения блока номеров телефона")
    public void checkHeaderPhoneBlock() {
        page.checkHeaderPhoneBlock();
    }

    @When("Проверка отображения Корзины")
    public void checkBasket() {
        page.checkBasket();
    }

    @When("Кликнуть Открыть бургер меню")
    public void сlickopenmainmenu() {
        page.сlickOpenMainMenu();
    }

    @When("Проверка отображения блока бургер меню")
    public void checkBurgerMenuBlock() {
        page.checkBurgerMenuBlock();
    }

    @When("Кликнуть Закрыть бургер меню")
    public void сlickclosemainmenu() {
        page.сlickCloseMainMenu();
    }

    @When("^Проверка блока основного меню: Анализы, Адреса, Акции, Выезд на дом, Запись к врачу, Медицинские услуги, Комплексные обследования$")
    public void checkMainMenuBlock() {
        page.checkMainMenuBlock();
    }

    @When("^Проверка отображения кнопки 'Получить результат анализов'$")
    public void checkGetTheTestResults() {
        page.checkGetTheTestResults();
    }

    @When("Проверка отображеня строки Поиска анализов")
    public void checkSearchInput() {
        page.checkSearchInput();
    }

    @When("Проверка отображеня кнопки Поиска анализов")
    public void checkSearchButton() {
        page.checkSearchButton();
    }

    @When("Проверка отображения слайдера с акциями")
    public void checkSlider() {
        page.checkSlider();
    }

    @When("^Проверка отображения блока 'Направления компании'$")
    public void checkDirectionsCompanyBlock() {
        page.checkDirectionsCompanyBlock();
    }

    @When("^Проверка отображения иконки Анализы блока 'Направления компании'$")
    public void visibleDirectionsAnalyzesIcon() {
        page.visibleDirectionsAnalyzesIcon();
    }

    @When("^Проверка отображения иконки Медицинские услуги блока 'Направления компании'$")
    public void visibleDirectionsMedicalServicesIcon() {
        page.visibleDirectionsMedicalServicesIcon();
    }

    @When("^Проверка отображения иконки Комплексные обследования блока 'Направления компании'$")
    public void visibleDirectionsComplexIcon() {
        page.visibleDirectionsComplexIcon();
    }

    @When("^Проверка отображения иконки Услуги врачей блока 'Направления компании'$")
    public void visibleDirectionsDoctorServicesIcon() {
        page.visibleDirectionsDoctorServicesIcon();
    }

    @When("Проверка отображения блока FAQ")
    public void checkFAQBlock() {
        page.checkFAQBlock();
    }

    @When("Проверка отображения блока Новости")
    public void checkNewsBlock() {
        page.checkNewsBlock();
    }

    @When("^Проверка отображения кнопки 'Все новости'$")
    public void checkAllNewsButton() {
        page.checkAllNewsButton();
    }

    @When("Проверка отображения блока Врачи и специалисты")
    public void checkDoctorsBlock() {
        page.checkDoctorsBlock();
    }

    @When("^Проверка отображения кнопки 'Все врачи'$")
    public void checkAllDoctorsButton() {
        page.checkAllDoctorsButton();
    }

    @When("Проверка отображения блока О компании")
    public void checkAboutCompanyBlock() {
        page.checkAboutCompanyBlock();
    }

    @When("Проверка отображения иконки Планета")
    public void visibleAboutCompanyPlanetIcon() {
        page.visibleAboutCompanyPlanetIcon();
    }

    @When("Проверка отображения иконки Микроскоп")
    public void visibleAboutCompanyMicroscopeIcon() {
        page.visibleAboutCompanyMicroscopeIcon();
    }

    @When("Проверка отображения иконки МО")
    public void visibleAboutCompanyMedicalOfficeIcon() {
        page.visibleAboutCompanyMedicalOfficeIcon();
    }

    @When("Проверка отображения фото врача")
    public void visibleAboutCompanyDoctorPhoto() {
        page.visibleAboutCompanyDoctorPhoto();
    }

    @When("Проверка отображения кнопки Наверх")
    public void checkUpButton() {
        page.checkUpButton();
    }

    @When("Проверка отображения блока Footer меню")
    public void checkFooterMenuBlock() {
        page.checkFooterMenuBlock();
    }

    @When("^Проверка отображения иконки Инвитро-Лауреат премии$")
    public void visiblePrizeWinnerIcon() {
        page.visiblePrizeWinnerIcon();
    }

    @When("Проверка отображения иконки Facebook")
    public void visibleIconFBinFooter() {
        page.visibleIconFBinFooter();
    }

    @When("Проверка отображения иконки Одноклассники")
    public void visibleIconOKinFooter() {
        page.visibleIconOKinFooter();
    }

    @When("Проверка отображения иконки ВКонтакте")
    public void visibleIconVKinFooter() {
        page.visibleIconVKinFooter();
    }

    @When("Проверка отображения иконки YouTube")
    public void visibleIconYoutubeInFooter() {
        page.visibleIconYoutubeInFooter();
    }

    @When("Проверка отображения иконки Instagram")
    public void visibleIconInstInFooter() {
        page.visibleIconInstInFooter();
    }

    @When("Проверка отображения блока Группа компаний ИНВИТРО")
    public void checkGroupOfCompaniesBlock() {
        page.checkGroupOfCompaniesBlock();
    }

    @When("Проверка отображения блока Лицензия компании")
    public void checkLicenseBlock() {
        page.checkLicenseBlock();
    }

    @When("Проверка отображения иконки карты МИР")
    public void visibleWorldIcon() {
        page.visibleWorldIcon();
    }

    @When("Проверка отображения иконки карты MasterCard")
    public void visibleMasterCardIcon() {
        page.visibleMasterCardIcon();
    }

    @When("Проверка отображения иконки карты VISA")
    public void visibleVisaIcon() {
        page.visibleVisaIcon();
    }

    @When("Проверка отображения иконки ограничения по возрасту")
    public void visibleAgeIcon() {
        page.visibleAgeIcon();
    }

    @When("Ввести код анализа в поле поиска (.*)")
    public void searchAnalises(String value) {
        page.Search(value);
    }

    @When("^Проверка отображения заголовка 'Количество найденных результатов'$")
    public void checkResultText() {
        page.checkResultText();
    }

    @When("^Проверка отображения заголовка 'Анализы'$")
    public void checkAnalyzesText() {
        page.checkAnalyzesText();
    }

    @When("Проверка отображения блока найденного анализа")
    public void checkResultAfterSearchPage() {
        page.checkResultAfterSearchPage();
    }

    @When("Пролистать страницу вниз")
    public void scrollPage() {
        page.evaluateJavascript("scroll(0,4000)");
    }

    @When("Пролистать страницу вверх")
    public void scrollPageUP() {
        page.evaluateJavascript("scroll(4000,0)");
    }

////////////////////////// Жесткая проверка кнопок на главной странице для Москвы\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @When("Проверка кнопки Анализы")
    public void checkAnalyzesBtn() {
        page.checkAnalyzesBtn();
    }

    @When("Проверка кнопки Адреса")
    public void checkAdressesBtnMP() {
        page.checkAdressesBtnMP();
    }

    @When("Проверка кнопки Акции")
    public void checkAqBtnMP() {
        page.checkAqBtnMP();
    }

    @When("Проверка кнопки Выезд на дом")
    public void checkVNDBtnMP() {
        page.checkVNDBtnMP();
    }

    @When("Проверка кнопки Запись к врачу")
    public void checkToDoctorBtnMP() {
        page.checkToDoctorBtnMP();
    }

    @When("Проверка кнопки Медицинские услуги")
    public void checkMedServBtnMP() {
        page.checkMedServBtnMP();
    }

    @When("Проверка кнопки Комплексные исследования")
    public void checkComplexResBtnMP() {
        page.checkComplexResBtnMP();
    }

    @Given("Открыть страницу сайта (.*)$")
    public void openPageByUrl(String url) {
        int count = 0;
        while (count < 10) {
            try {
                page.maximize();
                page.getDriver().get(url);
                //page.сlickYes_and_close_cookie(); //Этот метод только для Рязани включается в связи с определением местоположения
                WebDriver driver = page.getDriver();

                Cookie SubscribeApplet = new Cookie("subscr", "accepted");
                driver.manage().addCookie(SubscribeApplet);

                Cookie CookieApplet = new Cookie("WARNINGS[cookie]", "cookie");
                driver.manage().addCookie(CookieApplet);

                Cookie CityApplet = new Cookie("IS_USER_INSTALL", "1");
                driver.manage().addCookie(CityApplet);

                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
                driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);

                page.setDriver(driver);
                page.getDriver().get(url);
                page.closeAttentionPopUp();
                page.waitForBurgerMenuClickable();
                break;
            } catch (WebDriverException e) {
                e.printStackTrace();
                count++;
                if (count == 10) {
                    throw e;
                }
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                //throw new Error("network server is slow..check internet connection");
            }
        }
    }

    @Then("^Проверяю работу редиректа$")
    public void checkRedirect() {
        String urlBeforeRedirect = page.getDriver().getCurrentUrl();
        System.out.println(urlBeforeRedirect);
        page.getDriver().get(urlBeforeRedirect + "/check/redirect.php");
        page.getSlow5();
        Assertions.assertThat(page.getDriver().getCurrentUrl())
            .as("Редирект произошел на другой хостнейм")
            .isEqualTo(urlBeforeRedirect);
    }
}
