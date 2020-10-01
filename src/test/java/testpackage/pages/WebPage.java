package testpackage.pages;

import static java.time.temporal.ChronoUnit.SECONDS;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class WebPage extends PageObject {

    private By EnRuVer = By.xpath("//a[@class='switch-lang__icon']");

    @FindBy(xpath = "//div[contains(@class,'attention--header--list')]")
    private WebElementFacade popUpList; // Список уведомлений

    By showAllWarnings = By.xpath(".//button[text()='Показать всё']"); // Показать все предупреждения

    By notificationCloseButtonsPath = By.xpath("//div[@class='close-block']/*[1]"); // Все кнопки закрытия уведомлений

//    @FindBys({@FindBy(xpath = "//div[@class='close-block']")}) // Все кнопки закрытия уведомлений
//    private List<WebElementFacade> notificationCloseButtons;

    By errorPage = By.xpath("//div[@class='empty-page__title']"); // Пустая страница

    private By LowerHeaderMenu = By.xpath("//div[@class='header-bottom']"); // Нижнее меню в шапке сайта (Анализы, Адреса, Акции, Выезд на дом, Запись к врачу и т.д.)

    private By LowerHeaderMenuElements = By.xpath("//a[@class='header-nav__link']"); // Все кнопки с ссылками нижнего меню в шапке сайта (Анализы, Адреса, Акции, Выезд на дом, Запись к врачу и т.д.)

    private By LowerHeaderMenuLeftScroll = By.xpath("//button[@class='nav-scroller-btn nav-scroller-btn--left active']"); // Скролл влево нижнего меню в шапке сайта

    private By LowerHeaderMenuRightScroll = By.xpath("//button[@class='nav-scroller-btn nav-scroller-btn--right active']"); // Скролл вправо нижнего меню в шапке сайта

    private By UpperHeaderMenu = By.xpath("//div[@class='header-top']"); // Верхнее меню в шапке сайта (Пациентам, Врачам, Франчайзинг и т.д.)

    private By UpperHeaderMenuElements = By.xpath("//li[@class='header-top-nav__item']/a"); // Все кнопки с ссылками верхнего меню в шапке сайта (Пациентам, Врачам, Франчайзинг и т.д.)

    private By BurgerMenuField = By.xpath("//div[@class='header-menu header-menu--active']"); // Все поле бургер-меню

    public By AllBurgerMenuElements = By.xpath("//a[contains(@class,'header-menu__link')]"); // Все кнопки с ссылками в бургер-меню

    By PageHeader = By.xpath("//div[contains(@class,'title-block')]/h1"); // Заголовок страницы (h1)

    By PageBottom = By.xpath("//div[@class='ft-bottom__pay']"); // Нижняя часть страницы страницы

    private By SideBarField = By.xpath("//div[contains(@class,'row')]/div[contains(@class,'side-bar')]"); // Все поле левого меню

    private By SideBarMenuItems = By.xpath("//li[contains(@class,'side-bar')]/a[1]"); // Все кнопки с ссылками левого меню

    private By SideBarMenuActiveItem = By.xpath("//li[contains(@class,'side-bar__link--open') or contains(@class,'side-bar__items--active')]/a |" +
            "//a[contains(@class,'side-bar__link--open') or contains(@class,'side-bar__items--active')]"); // Активный элемент левого меню

    private By SideBarMenuItemsIcon = By.xpath("./img");  // Иконка левого меню

    By InvitroLogo = By.xpath("//img[@src='/local/templates/invitro_main/src/image/elements/main-logo.svg']"); // Логотип INVITRO в шапке сайта

    By OpenMainMenu = By.xpath("//button[@class='header-menu__btn ripple']"); // Открытие бургер-меню

    private By EndOfPage = By.xpath("//div[@class='ft-bottom']/p"); // Блок все права защищены внизу страницы

    private By fotoPage = By.xpath("//body/img"); // Страница фотографии

    private By Bread = By.xpath("//ul[@class = 'bread-crumbs__list']");// Хлебные крошки

    private By Current_City = By.xpath("//span[@class='city__name city__btn city__name--label']"); // Текущий город

    private By closeWidgetButton = By.xpath("//div[@class='monitoring_widget']//img"); // Кнопка закрытия виджета Covid

    private By FooterMenuElements = By.xpath("//div[@class='ft__col']//a"); // Все кнопки с текстом и ссылками подвала сайта

    private By allHeadingNamesPopUp = By.xpath("//div[@class='mfp-content']//label[@class='label']"); // Заголовки полей в поп-апах

    @FindBy(xpath = "//div[contains(@class,'city__label')]/span[2]") // Выбранный город в шапке сайта
    WebElementFacade headerCityName;

    /////////////////////////////////////////////////Методы\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void waitForBurgerMenuClickable() { // Метод ожидания, пока кнопка, раскрывающая бургер-меню, станет доступна
        element(OpenMainMenu).waitUntilClickable();
    }

    public void clickOnBurgerMenuElement(String text) { // Метод клика по кнопке с ссылкой в бургер-меню
        find(BurgerMenuField).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
        List<WebElementFacade> burgerMenuItems = findAll(AllBurgerMenuElements);
        for (WebElementFacade element : burgerMenuItems) {
            if (normalize(element.getText()).equals(text)) {
                element.click();
                waitABit(2000);
                find(PageHeader).withTimeoutOf(120, TimeUnit.SECONDS).waitUntilVisible();
                find(PageBottom).withTimeoutOf(240, TimeUnit.SECONDS).waitUntilVisible();
                waitABit(2000);
                return;
            }
        }
        Assertions.fail("В бургер-меню не найден пункт меню " + text);
    }

    public void Click_Method(By by) { // Метод клика по элементу
        WebElementFacade element = element(by).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        scrollTo(by);
        element.click();
        waitABit(2000);
    }

    public void Click_Method(WebElementFacade element) { // Метод клика по элементу
        element.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        scrollTo(element);
        element.click();
        waitABit(2000);
    }

    public void Check_Enabled_Element(By test) { // Метод проверки доступности элемента
        WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        Assertions.assertThat(element.isEnabled()).as(test.toString() + " not enabled").isTrue();
    }

    public void Verify_Text(By test, String text) { // Метод проверки текста
        WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        Assertions.assertThat(normalize(element.getText()))
                .as("Текст " + test.toString() + " не совпадает")
                .isEqualTo(text);
    }

    public void Verify_Text(By test, String text, String message) {
        WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        Assertions.assertThat(normalize(element.getText()))
                .as(message)
                .isEqualTo(text);
    }

    public void Enter_Text(By test, String test1) { // Метод ввода текста
        WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        element.sendKeys(test1);
    }

    public void Enter_Text(WebElementFacade element, String test1) { // Метод ввода текста
        element.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        element.sendKeys(test1);
    }

    public void Check_Visible_Element(By test) { // Метод проверки видимости элемента (1 часть)
        WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        Assertions.assertThat(element.isDisplayed()).as(test.toString() + " not visible").isTrue();
    }

    public void Check_Visible_Element(By test, String message) { // Метод проверки видимости элемента (2 часть)
        WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        Assertions.assertThat(element.isDisplayed()).as(message).isTrue();
    }

    public boolean isElementDisplayed(By test) { // Метод проверки отображения элемента на экране (1 часть)
        try {
            WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
            return element.isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebElementFacade test) { // Метод проверки отображения элемента на экране (1 часть)
        try {
            WebElementFacade element = test.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
            return element.isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }

    public boolean isElementEnabled(By test) { // Метод проверки доступности элемента на экране (1 часть)
        try {
            WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
            return element.isEnabled();
        } catch (WebDriverException e) {
            return false;
        }
    }

    public boolean isElementEnabled(WebElementFacade test) { // Метод проверки доступности элемента на экране (2 часть)
        try {
            WebElementFacade element = test.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
            return element.isEnabled();
        } catch (WebDriverException e) {
            return false;
        }
    }

    public void returnToPrvPage() { // Метод возвращает на предыдущю страницу
        getDriver().navigate().back();
    }

    public void getSlow() { // Притормаживает выполнение на 10 секунд
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSlow2() { // Метод пвритормаживает выполнение на 2 секунды
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSlow5() { // Метод притормаживает выполнение на 5 секунд
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Check_EN_RU_URL(By EnRuButton, String En_URL, String Ru_URL) { // Метод проверяет правильность урла при смене языка сайта
        Click_Method(EnRuButton);
        waitABit(5000);
        Assertions.assertThat(getDriver().getCurrentUrl())
                .as("Переход был выполнен на - " + getDriver().getCurrentUrl() + ". Url не содержит " + En_URL)
                .contains(En_URL);
        Click_Method(EnRuButton);
        waitABit(5000);
        Assertions.assertThat(getDriver().getCurrentUrl())
                .as("Переход был выполнен на - " + getDriver().getCurrentUrl() + ". Url не содержит " + Ru_URL)
                .contains(Ru_URL).doesNotContain(En_URL);
    }

    public void scrollTo(By test) { // Скролл к нужному элементу
        WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        getSlow2();
    }

    public void scrollTo(WebElementFacade element) { // Скролл к нужному элементу
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        getSlow2();
    }

    public void randomClick(By test) { // Метод кликающий на случайный элемент из списка
        List<WebElementFacade> massive = findAll(test);
        int random_number = new Random().nextInt(massive.size());
        Click_Method(massive.get(random_number));
    }

    public void randomClick(List<WebElementFacade> test) { // Метод кликающий на случайный элемент из списка (2 часть)
        int random_number = new Random().nextInt(test.size());
        Click_Method(test.get(random_number));
    }

    public void Massive_Cycle_Check(By for_massive, By for_condition) {
        List<WebElementFacade> massive = findAll(for_massive);
        for (int i = 0; i < massive.size(); i++) {
            massive = findAll(for_massive);
            if (!find(for_condition).isVisible()) {
                Assertions.assertThat(find(for_condition).isVisible())
                        .as("В разделе: '" + massive.get(i).getText() + "' нет врачей. раздел не должен отображаться").isEqualTo(!find(for_condition).isVisible());
            }
            int w_e_f_l = massive.get(i).toString().length();
            String xpath_from_mass = massive.get(i).toString();
            String xpath = xpath_from_mass.substring(xpath_from_mass.indexOf("//"), w_e_f_l - 1);
            By random_analyz = By.xpath(xpath);
            Click_Method(random_analyz);
        }
    }

    public void goToImageURL(By scrAttrib) { // Открывает картинку по прямому урлу
        String URL = find(scrAttrib).getAttribute("src");
        String currentWindow = getDriver().getWindowHandle();
        ((JavascriptExecutor) getDriver()).executeScript("window.open();");
        for (String tab : getDriver().getWindowHandles()) {
            if (!tab.equals(currentWindow)) {
                getDriver().switchTo().window(tab);
                break;
            }
        }
        getDriver().get(URL);
        System.out.println("Полный УРЛ = " + URL);
        try {
            Assertions.assertThat(find(errorPage).isVisible()).isFalse();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        getDriver().close();
        getDriver().switchTo().window(currentWindow);
    }

    public boolean isImageOpened(By scrAttrib) {
        WebElementFacade imgElement = element(scrAttrib);
        return isImageOpened(imgElement);
    }

    public boolean isImageOpened(WebElementFacade img) {
        String URL = img.getAttribute("src");
        String currentWindow = getDriver().getWindowHandle();
        ((JavascriptExecutor) getDriver()).executeScript("window.open();");
        for (String tab : getDriver().getWindowHandles()) {
            if (!tab.equals(currentWindow)) {
                getDriver().switchTo().window(tab);
                break;
            }
        }
        getDriver().get(URL);
        System.out.println("Полный УРЛ = " + URL);
        boolean not404;
        setImplicitTimeout(5, SECONDS);
        try {
            find(errorPage).withTimeoutOf(5, TimeUnit.SECONDS).waitUntilVisible();
            not404 = false;
        } catch (WebDriverException e) {
            not404 = true;
        }
        for (String windowHandles : getDriver().getWindowHandles()) {
            if (!windowHandles.equals(currentWindow)) {
                getDriver().close();
            }
        }
        getDriver().switchTo().window(currentWindow);
        resetImplicitTimeout();
        return not404;
    }

    String normalize(String text) { // Нормализует текст по регистру и пробелам
        return text
                .replaceAll("\n", " ")
                .replaceAll("\t", " ")
                .replaceAll("\r", " ")
                .replaceAll("  *", " ").trim();
    }

    public void checkPageHeadline(String text) { // Метод проверяет отображение и содержание заголовка страницы
        Check_Visible_Element(PageHeader);
        Verify_Text(PageHeader, text, "Заголовок станицы содержит неверный текст");
    }

    public String getPageHeadline() { // Метод проверяет отображение и получает текст заголовка страницы
        Check_Visible_Element(PageHeader);
        return normalize(find(PageHeader).getText());
    }

    public List<String> getSideBarMenuItems() { // Метод получает список всех элементов левого меню, проверяет их отображение на экране и нормализует текст
        find(SideBarField).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
        List<WebElementFacade> sideBarMenuElements = findAll(SideBarMenuItems);
        List<String> result = new ArrayList<>();
        for (WebElementFacade element : sideBarMenuElements) {
            if (element.isDisplayed()) {
                result.add(normalize(element.getText()));
            }
        }
        return result;
    }

    public String getActiveSideBarMenuItem() { // Метод получает активный элемент левого меню
        find(SideBarField).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
        List<WebElementFacade> activeItems = findAll(SideBarMenuActiveItem);
        Assertions.assertThat(activeItems.size())
                .as("В меню нет активных пунктов или активно больше одного пункта: "
                        + activeItems.stream().map(WebElementFacade::getText).collect(Collectors.toList()))
                .isEqualTo(1);
        Check_Visible_Element(SideBarMenuActiveItem);
        return normalize(element(SideBarMenuActiveItem).getText());
    }

    private void scrollToEnd() {
        scrollTo(EndOfPage);
    }

    public void clickOnSideMenuButton(String menuName) { // Метод нажимает на элемент левого меню
        find(SideBarField).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
        List<WebElementFacade> sideBarMenuElements = findAll(SideBarMenuItems);
        for (WebElementFacade element : sideBarMenuElements) {
            if (element.isDisplayed() && normalize(element.getText()).equals(menuName)) {
//                scrollTo(element);
//                element.click();
                scrollTo(element);
                Actions actions = new Actions(getDriver());
                actions.moveToElement(element, -(int) (element.getSize().width * 0.30), 0).click().perform();
                waitABit(2000);
                find(PageHeader).withTimeoutOf(60, TimeUnit.SECONDS).waitUntilVisible();
                find(PageBottom).withTimeoutOf(240, TimeUnit.SECONDS).waitUntilVisible();
                waitABit(2000);
                return;
            }
        }
        Assert.fail("Не найден видимый пункт меню " + menuName);
    }

    public WebElementFacade getMenuElementByName(String menuName) {
        List<WebElementFacade> sideBarMenuElements = findAll(SideBarMenuItems);
        for (WebElementFacade element : sideBarMenuElements) {
            if (element.isDisplayed() && normalize(element.getText()).equals(menuName)) {
                return element;
            }
        }
        Assert.fail("Не найден пункт меню " + menuName);
        return null;
    }

    public void clickOnOpenAreaOfSideMenuElement(WebElementFacade element) {
        scrollTo(element);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element, (int) (element.getSize().width * 0.45), 0).click().perform();
    }

    private void moveToViewport(WebElementFacade element) {
        scrollTo(By.xpath("//body"));
        boolean inViewport = (Boolean) ((JavascriptExecutor) getDriver()).executeScript(
                "var elem = arguments[0],                 " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            "
                , element);
        while (!inViewport) {
            Actions actions = new Actions(getDriver());
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            inViewport = (Boolean) ((JavascriptExecutor) getDriver()).executeScript(
                    "var elem = arguments[0],                 " +
                            "  box = elem.getBoundingClientRect(),    " +
                            "  cx = box.left + box.width / 2,         " +
                            "  cy = box.top + box.height / 2,         " +
                            "  e = document.elementFromPoint(cx, cy); " +
                            "for (; e; e = e.parentElement) {         " +
                            "  if (e === elem)                        " +
                            "    return true;                         " +
                            "}                                        " +
                            "return false;                            "
                    , element);
        }
    }

    public void actionClick(WebElementFacade element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).click().perform();
    }

    public void clickOnOpenSideMenuElement(String menuName) {
        find(SideBarField).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
        List<WebElementFacade> sideBarMenuElements = findAll(SideBarMenuItems);
        for (WebElementFacade element : sideBarMenuElements) {
            if (element.isDisplayed() && normalize(element.getText()).equals(menuName)) {
                clickOnOpenAreaOfSideMenuElement(element/*.findBy(By.xpath("."))*/);
                waitABit(3000);
                return;
            }
        }
        Assert.fail("Не найден видимый пункт меню " + menuName);
    }

    public void Check_Bread() { // Метод проверяет отображение хлебных крошек
        Assertions.assertThat(isElementDisplayed(Bread))
                .as("Хлебные крошки не отображаются")
                .isTrue();
    }

    public String getBreadValue() { // Метод получает значения в хлебных крошках
        return element(Bread).getText();
    }

    public List<String> getActiveSideBarMenuItems() {
        List<String> result = new ArrayList<>();
        find(SideBarField).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
        List<WebElementFacade> activeItems = findAll(SideBarMenuActiveItem);
        for (WebElementFacade element : activeItems) {
            if (isElementDisplayed(element)) {
                result.add(element.getText());
            }
        }
        return result;
    }

    public String getBrowser() {
        return ((RemoteWebDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()).getCapabilities().getBrowserName();
    }

    public Long getY(WebElementFacade element) {
        String script =
                "var rect = arguments[0].getBoundingClientRect()," +
                        "scrollTop = window.pageYOffset || document.documentElement.scrollTop;" +
                        "return rect.top + scrollTop;";
        return (long) ((JavascriptExecutor) getDriver()).executeScript(script, element);
    }

    public Long getX(WebElementFacade element) {
        String script =
                "var rect = arguments[0].getBoundingClientRect()," +
                        "scrollLeft = window.pageXOffset || document.documentElement.scrollLeft;" +
                        "return rect.left + scrollLeft;";
        if (getBrowser().equals("Safari")) {
            return (long) ((JavascriptExecutor) getDriver()).executeScript(script, element);
        }
        return Math.round((Double) ((JavascriptExecutor) getDriver()).executeScript(script, element));
    }

    public void closeAttentionPopUp(int timeout) {
        try {
            popUpList.withTimeoutOf(timeout, TimeUnit.SECONDS).waitUntilVisible();
            try {
                popUpList.findBy(showAllWarnings).waitUntilVisible().click();
                waitABit(1000);
            } catch (WebDriverException ignore) {
            }
            List<WebElementFacade> notificationCloseButtons = findAll(notificationCloseButtonsPath);
            System.out.println(notificationCloseButtons.size());
            for (WebElementFacade closeButton : notificationCloseButtons) {
                try {
                    actionClick(closeButton);
//                    closeButton.click();
                    waitABit(2000);
                } catch (WebDriverException ignore) {
                }
            }
        } catch (WebDriverException ignore) {
        }
    }

    public void closeWidget() { // Метод закрытия виджета
        try {
            find(closeWidgetButton).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
            Click_Method(closeWidgetButton);
            waitABit(1000);
        } catch (WebDriverException ignore) {
        }
    }

    public void clickOnLowerHeaderMenu(String menuName) { // Метод проверяет и кликает на стрелку нижнего меню шапки сайта (актуально, при маленькой ширине экрана)
        find(LowerHeaderMenu).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
        List<WebElementFacade> menuElements = findAll(LowerHeaderMenuElements);
        for (WebElementFacade element : menuElements) {
            if (element.isDisplayed() && element.getText().equalsIgnoreCase(menuName)) {
                element.click();
                waitABit(3000);
                return;
            }
        }
        while (isElementDisplayed(LowerHeaderMenuLeftScroll)) {
            Click_Method(LowerHeaderMenuLeftScroll);
        }
        while (isElementDisplayed(LowerHeaderMenuRightScroll)) {
            menuElements = findAll(LowerHeaderMenuElements);
            for (WebElementFacade element : menuElements) {
                if (element.isDisplayed() && element.getText().equalsIgnoreCase(menuName)) {
                    element.click();
                    waitABit(3000);
                    return;
                }
            }
            Click_Method(LowerHeaderMenuRightScroll);
        }

        Assert.fail("Не найден видимый пункт меню " + menuName);
    }

    public List<String> getLowerHeaderMenu() {
        find(LowerHeaderMenu).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
        Set<String> menu = new TreeSet<>();
        while (isElementDisplayed(LowerHeaderMenuLeftScroll)) {
            Click_Method(LowerHeaderMenuLeftScroll);
        }
        List<WebElementFacade> menuElements;
        while (isElementDisplayed(LowerHeaderMenuRightScroll)) {
            menuElements = findAll(LowerHeaderMenuElements);
            for (WebElementFacade element : menuElements) {
                if (element.isDisplayed()) {
                    menu.add(normalize(element.getText()).toUpperCase());
                }
            }
            Click_Method(LowerHeaderMenuRightScroll);
        }
        menuElements = findAll(LowerHeaderMenuElements);
        for (WebElementFacade element : menuElements) {
            if (element.isDisplayed()) {
                menu.add(normalize(element.getText()).toUpperCase());
            }
        }
        return new ArrayList<>(menu);
    }

    public List<String> getUpperHeaderMenu() { // Метод проверяет содержание верхнего меню шапки сайта
        List<WebElementFacade> UpperMenuElements = findAll(UpperHeaderMenuElements);
        List<String> result = new ArrayList<>();
        for (WebElementFacade element : UpperMenuElements) {
            if (element.isDisplayed()) {
                result.add(normalize(element.getText()));
            }
        }
        return result;
    }

    public void clickOnUpperHeaderMenu(String menuName) { // Метод кликает на кнопку-ссылку верхнего меню шапки сайта
        find(UpperHeaderMenu).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
        List<WebElementFacade> menuElements = findAll(UpperHeaderMenuElements);
        for (WebElementFacade element : menuElements) {
            if (element.isDisplayed() && element.getText().equals(menuName)) {
                element.click();
                waitABit(3000);
                return;
            }
        }
        Assert.fail("Не найден видимый пункт меню " + menuName);
    }

    public void jsClick(WebElementFacade webElement) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", webElement);
    }

    public void checkIconsForSideMenuItems(List<String> menuItemsForCheck) { // Метод проверки кнопок с ссылками левого меню и отображения иконок в них
        Assertions.assertThat(getSideBarMenuItems())
                .as("В меню видны не все пункты")
                .containsAll(menuItemsForCheck);
        List<WebElementFacade> sideBarMenuElements = findAll(SideBarMenuItems);
        for (WebElementFacade element : sideBarMenuElements) {
            if (element.isDisplayed() && menuItemsForCheck.contains(normalize(element.getText()))) {
                WebElementFacade icon = element.then(SideBarMenuItemsIcon);
                Assertions.assertThat(isElementDisplayed(icon))
                        .as("Иконка пункта " + normalize(element.getText()) + " не отображается")
                        .isTrue();
                Assertions.assertThat(isImageOpened(icon))
                        .as("Иконка пункта " + normalize(element.getText()) + " не открывается")
                        .isTrue();
            }
        }
    }

    public String getCurrentCity() { // Метод проверки отображения текущего выбранного города в шапке сайта
        Assertions.assertThat(isElementDisplayed(Current_City))
                .as("Текущий город не отображается")
                .isTrue();
        return normalize(find(Current_City).getText());
    }

    public void switchLanguage() { // Метод смены языка сайта EN/RU
        Click_Method(EnRuVer);
    }

    public void returnToPreviousPage() { // Метод возвращения на предыдущую страницу
        getDriver().navigate().back();
    }

    public void clickElementInFooter(String text) { // Метод клика по кнопке с ссылкой в подвале сайта
        find(FooterMenuElements).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
        List<WebElementFacade> footerMenuItems = findAll(FooterMenuElements);
        for (WebElementFacade element : footerMenuItems) {
            if (normalize(element.getText()).equals(text)) {
                element.click();
                waitABit(2000);
                return;
            }
        }
        Assertions.fail("В футер-меню не найден пункт меню " + text);
    }

    public List<String> getAllHeadingNamesPopUp() { // Метод проверяет содержание заголовков полей поп-апа
        List<WebElementFacade> PopUpElements = findAll(allHeadingNamesPopUp);
        List<String> result = new ArrayList<>();
        for (WebElementFacade element : PopUpElements) {
            if (element.isDisplayed()) {
                result.add(normalize(element.getText()));
            }
        }
        return result;
    }

    public void checkFileLink(WebElementFacade element) { // Проверка открытия ссылки в новом окне
        WebDriver driver = getDriver();
        int windowsCount = driver.getWindowHandles().size(); // Получаем кол-во открытых окон в браузере
        element.click(); // Находим нужный элемент и кликаем по нему
        waitABit(5000);
        String currentWindow = driver.getWindowHandle(); // Запоминаем id текущего открытого окна (вторая вкладка)
        Set<String> allWindows = driver.getWindowHandles(); // Собираем id всех открытых окон в браузере
        Assertions.assertThat(allWindows.size())
                .as("Новая вкладка с документом не открылась, переход по ссылке не был осуществлен")
                .isEqualTo(windowsCount + 1); // Проверяем, что в браузере открыто на одно окно больше
        for (String window : allWindows) { // Для каждого открытого окна проверяем
            if (!currentWindow.equals(window)) { // Если id текущего открытого окна НЕ ровно id в списке всех окон, то
                driver.switchTo().window(window); // осуществляем переход на изначально открытое окно (на вторую вкладку)
                break;
            }
        }
        Assertions.assertThat(isElementDisplayed(errorPage)) // Проверка на 404
                .as("Открылась страница 404")
                .isFalse();
        driver.close(); // Закрываем вторую вкладку
        driver.switchTo().window(currentWindow); // Переходим на первую вкладку
    }

    public String getCustomProperty() {
        String customProperty;
        try {
            customProperty = System.getProperty("customproperty").toLowerCase();
        } catch (NullPointerException e) {
            customProperty = "";
        }
        return customProperty;
    }

    public void checkHeaderCity(String value) { // Проверка что выбран указанный город
        Assertions.assertThat(headerCityName.getText())
                .as("Выбран город " + headerCityName.getText() + " вместо " + value)
                .isEqualToIgnoringWhitespace(value);
    }

    public void assertElementIsDisplayed(WebElementFacade element, String description) { // Проверка что элемент отображается
        Assertions.assertThat(isElementDisplayed(element))
                .as(description)
                .isTrue();
    }

    public void assertImageIsOpened(WebElementFacade element, String description) { // Проверка что изображение открывается
        Assertions.assertThat(isImageOpened(element))
                .as(description)
                .isTrue();
    }

    public void assertTextIsNotBlank(WebElementFacade element, String description) { // Проверка что в блоке есть текст (используется WebElementFacade)
        Assertions.assertThat(element.getText())
                .as(description)
                .isNotBlank();
    }

    public void assertTextIsNotBlank(String element, String description) { // Проверка что в блоке есть текст (используется String)
        Assertions.assertThat(element)
                .as(description)
                .isNotBlank();
    }
}