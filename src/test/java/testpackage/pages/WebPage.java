package testpackage.pages;

import static java.time.temporal.ChronoUnit.SECONDS;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class WebPage extends PageObject {

    private By EnRuVer = By.xpath("//a[@class='switch-lang__icon']");

    @FindBy(xpath = "//div[contains(@class,'attention--header--list')]")
    private WebElementFacade popUpList; // Список уведомлений

    By showAllWarnings = By.xpath(".//button[text()='Показать всё']"); // Показать все предупреждения

    By notificationCloseButtonsPath = By.xpath("//div[@class='close-block']/*[1]"); // Все кнопки закрытия уведомлений

//    @FindBys({@FindBy(xpath = "//div[@class='close-block']")})
//    private List<WebElementFacade> notificationCloseButtons; // Все кнопки закрытия уведомлений

    By errorPage = By.xpath("//div[@class='empty-page__title']"); // Пустая страница

    private By LowerHeaderMenu = By.xpath("//div[@class='header-bottom']"); //нижнее хеадер меню

    private By LowerHeaderMenuElements = By.xpath("//a[@class='header-nav__link']"); //все элементы нижнего хеадер меню

    private By LowerHeaderMenuLeftScroll = By.xpath("//button[@class='nav-scroller-btn nav-scroller-btn--left active']"); //скролл в лево нижнего хеадер меню

    private By LowerHeaderMenuRightScroll = By.xpath("//button[@class='nav-scroller-btn nav-scroller-btn--right active']"); //скролл в право нижнего хеадер меню

    private By UpperHeaderMenu = By.xpath("//div[@class='header-top']"); //верхнее хеадер меню

    private By UpperHeaderMenuElements = By.xpath("//li[@class='header-top-nav__item']/a"); //все элементы верхнего хеадер меню

    private By BurgerMenuField = By.xpath("//div[@class='header-menu header-menu--active']"); //поле бургер меню

    private By AllBurgerMenuElements = By.xpath("//a[contains(@class,'header-menu__link')]"); //все элементы бургер меню

    By PageHeader = By.xpath("//div[contains(@class,'title-block')]/h1"); //заголовок страницы

    private By SideBarField = By.xpath("//div[contains(@class,'row')]/div[contains(@class,'side-bar')]"); //поле левого меню

    private By SideBarMenuItems = By.xpath("//li[contains(@class,'side-bar')]/a"); //все элементы левого меню

    private By SideBarMenuActiveItem = By.xpath("//li[contains(@class,'side-bar__link--open') or contains(@class,'side-bar__items--active')]/a |" +
            "//a[contains(@class,'side-bar__link--open') or contains(@class,'side-bar__items--active')]"); //активный элемент левого меню

    private By SideBarMenuItemsIcon = By.xpath("./img"); // иконка левого меню.

    By InvitroLogo = By.xpath("//img[@src='/local/templates/invitro_main/src/image/elements/main-logo.svg']");// Логотип Инвитро

    By OpenMainMenu = By.xpath("//button[@class='header-menu__btn ripple']");// Открытие меню бургер

    private By EndOfPage = By.xpath("//p[@class='']"); //Блок все права защищены внизу страницы

    private By fotoPage = By.xpath("//body/img"); //Старница фотографии

    private By Bread = By.xpath("//ul[@class = 'bread-crumbs__list']");// Хлебные крошки

    private By Current_City = By.xpath("//span[@class='city__name city__btn city__name--label']"); // Текущий город

    private By closeWidgetButton = By.xpath("//div[@class='monitoring_widget']//img"); //кнопка закрытия виджета.

    public void waitForBurgerMenuClickable() {
        element(OpenMainMenu).waitUntilClickable();
    }

    public void clickOnBurgerMenuElement(String text) {
        find(BurgerMenuField).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
        List<WebElementFacade> bugerMenuItems = findAll(AllBurgerMenuElements);
        for (WebElementFacade element : bugerMenuItems) {
            if (normalize(element.getText()).equals(text)) {
                element.click();
                waitABit(2000);
                find(PageHeader).withTimeoutOf(120, TimeUnit.SECONDS).waitUntilVisible();
                waitABit(2000);
                return;
            }
        }
        Assertions.fail("В бургер меню не найден пункт меню " + text);
    }

    public void Click_Method(By by) { //Метод клика по элементу
        WebElementFacade element = element(by).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        scrollTo(by);
        element.click();
        waitABit(2000);
    }

    public void Check_Enabled_Element(By test) {
        WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        Assertions.assertThat(element.isEnabled()).as(test.toString() + " not enabled").isTrue();
    }

    public void Verify_Text(By test, String text) {
        WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        Assertions.assertThat(normalize(element.getText()))
                .as("Text for " + test.toString() + " not equal")
                .isEqualTo(text);
    }

    public void Verify_Text(By test, String text, String message) {
        WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        Assertions.assertThat(normalize(element.getText())).as(message).isEqualTo(text);
    }

    public void Enter_Text(By test, String test1) {
        WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        element.sendKeys(test1);
    }

    public void Check_Visible_Element(By test) {
        WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        Assertions.assertThat(element.isDisplayed()).as(test.toString() + " not visible").isTrue();
    }

    public void Check_Visible_Element(By test, String message) {
        WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        Assertions.assertThat(element.isDisplayed()).as(message).isTrue();
    }

    public boolean isElementDisplayed(By test) {
        try {
            WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
            return element.isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebElementFacade test) {
        try {
            WebElementFacade element = test.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
            return element.isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }

    public boolean isElementEnabled(By test) {
        try {
            WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
            return element.isEnabled();
        } catch (WebDriverException e) {
            return false;
        }
    }

    public boolean isElementEnabled(WebElementFacade test) {
        try {
            WebElementFacade element = test.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
            return element.isEnabled();
        } catch (WebDriverException e) {
            return false;
        }
    }

    public void returnToPrvPage() {
        getDriver().navigate().back();
    }

    public void getSlow() { //Притормаживает выполнение на 1 секунду
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSlow2() { //Притормаживает выполнение на 1 секунду
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSlow5() { //Притормаживает выполнение на 1 секунду
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Check_EN_RU_URL(By EnRuButton, String En_URL, String Ru_URL) {
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

    public void scrollTo(By test) { // Скролл к блоку 'Найдено результатов'
        WebElementFacade element = find(test).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(element).perform();
        } else {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        }
        getSlow2();
    }

    public void scrollTo(WebElementFacade element) { // Скролл к блоку 'Найдено результатов'
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(element).perform();
        } else {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        }
        getSlow2();
    }

    public void Random_Click(By test) {
        List<WebElementFacade> massive = findAll(test);
        int count = massive.size();
        int random_number = (int) (Math.random() * count);
        int w_e_f_l = massive.get(random_number).toString().length();
        String xpath_from_mass = massive.get(random_number).toString();
        String xpath = xpath_from_mass.substring(xpath_from_mass.indexOf("//"), w_e_f_l - 1);
        By random_analyz = By.xpath(xpath);
        Click_Method(random_analyz);
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

    public void goToImageURL(By scrAttrib) {
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

    String normalize(String text) {
        return text
                .replaceAll("\n", " ")
                .replaceAll("\t", " ")
                .replaceAll("\r", " ")
                .replaceAll("  *", " ").trim();
    }

    public void checkPageHeadline(String text) {
        Check_Visible_Element(PageHeader);
        Verify_Text(PageHeader, text, "Заголовок станицы содержит неверный текст");
    }

    public String getPageHeadline() {
        Check_Visible_Element(PageHeader);
        return normalize(find(PageHeader).getText());
    }

    public List<String> getSideBarMenuItems() {
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

    public String getActiveSideBarMenuItem() {
        find(SideBarField).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
        List<WebElementFacade> ativeItems = findAll(SideBarMenuActiveItem);
        Assertions.assertThat(ativeItems.size())
                .as("В меню нет активных пунктов или активно больше одного пункта: "
                        + ativeItems.stream().map(WebElementFacade::getText).collect(Collectors.toList()))
                .isEqualTo(1);
        Check_Visible_Element(SideBarMenuActiveItem);
        return normalize(element(SideBarMenuActiveItem).getText());
    }

    private void scrollToEnd() {
        scrollTo(EndOfPage);
    }

    public void clickOnSideMenuButton(String menuName) {
        find(SideBarField).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
        List<WebElementFacade> sideBarMenuElements = findAll(SideBarMenuItems);
        for (WebElementFacade element : sideBarMenuElements) {
            if (element.isDisplayed() && normalize(element.getText()).equals(menuName)) {
                element.click();
                waitABit(2000);
                find(PageHeader).withTimeoutOf(60, TimeUnit.SECONDS).waitUntilVisible();
                waitABit(2000);
                return;
            }
        }
        Assert.fail("Не найден видимый пункт меню " + menuName);
    }

    public void clickOnOpenAreaOfSideMenuElement(WebElementFacade element) {
        scrollTo(element);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element, (int) (element.getSize().width * 0.45), 0).click().perform();
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
                clickOnOpenAreaOfSideMenuElement(element.findBy(By.xpath(".")));
                waitABit(3000);
                return;
            }
        }
        Assert.fail("Не найден видимый пункт меню " + menuName);
    }

    public void Check_Bread() {
        Assertions.assertThat(isElementDisplayed(Bread))
                .as("Хлебные крошки не отображаются")
                .isTrue();
    }

    public String getBreadValue() {
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

    public void closeAttentionPopUp() {
        try {
            popUpList.withTimeoutOf(60, TimeUnit.SECONDS).waitUntilVisible();
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

    public void closeWidget() {
        try {
            find(closeWidgetButton).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilVisible();
            Click_Method(closeWidgetButton);
            waitABit(1000);
        } catch (WebDriverException ignore) {
        }
    }

    public void clickOnLowerHeaderMenu(String menuName) {
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

    public void clickOnUpperHeaderMenu(String menuName) {
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

    public void checkIconsForSideMenuItems(List<String> menuItemsForCheck) {
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

    public String getCurrentCity() {
        Assertions.assertThat(isElementDisplayed(Current_City))
                .as("Текущий город не отображается")
                .isTrue();
        return normalize(find(Current_City).getText());
    }

    public void switchLanguage() {
        Click_Method(EnRuVer);
    }

    public void returnToPreviousPage() {
        getDriver().navigate().back();
    }
}