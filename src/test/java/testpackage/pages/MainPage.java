package testpackage.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

@DefaultUrl("https://www.invitro.ru/")

public class MainPage extends WebPage {

    //////////////////////////////////////X-Path's\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    private By City_Applet = By.xpath("//div[@class='city__label']");

    private By Moscow_City = By.xpath("//div[@class='change-city-wrapper__left']//a[contains(text(), 'Москва')]");

    private By Yes_Btn = By.xpath("//button[@class='btn btn--narrow city__confirm-btn']");

    private By ChangeOtherCity = By.xpath("//a[@class='btn btn--narrow btn--empty city__change-btn']");//Выбрать другой

    private By HeaderMenu = By.xpath("//ul[@class='header-top-nav']");// Блок Header меню: Пациентам, Врачам, Франчайзинг, Корпоративным клиентам, Журналистам

    private By HeaderCity = By.xpath("//div[@class='city__label']");// Блок выбранного города в Header меню

    private By HeaderChangeCityPopUp = By.xpath("//div[@class='city__change']");// Pop-up выбора города(выпадашка)

    private By HeaderEnterInLK = By.xpath("//div[@class='header__login login']");// Кнопка 'Вход в кабинет пациента'



    private By HeaderPhoneBlock = By.xpath("//div[@class='header-phone']");// Блок номера телефонов

    private By Basket = By.xpath("//div[@class='header-cart__icon']");// Корзина



    private By BurgerMenuBlock = By.xpath("//div[@class='row row--wrap row--start']"); // Блок Бургер меню

    private By CloseMainMenu = By.xpath("//button[@class='header-menu__btn ripple header-menu__btn--open']"); // Закрытие меню бургер

    private By MainMenuBlock = By.xpath("//ul[@class='header-nav__list nav-scroller-content']");// Блок основного меню: Анализы, Адреса, Акции, Выезд на дом, Запись к врачу, Медицинские услуги, Комплексные обследования

    private By GetTheTestResults = By.xpath("//button[@class='header-nav__get-result popupBtn']");// Форма получить результат анализов

    private By SearchInput = By.xpath("//*[@class='search__input']");// Строка поиска анализов

    private By SearchButton = By.xpath("//button[@name='s']");// Кнопка поиска

    private By ResultText = By.xpath("//div[@class='search-page__subtitle search-page__subtitle--color']");// Текст Количество найденных результатов

    private By AnalyzesText = By.xpath("//h2[contains(text(),'Анализы')]");// Текст Анализы

    private By ResultAfterSearchPage = By.xpath("//div[@class='result-item show-block show-block--active']");// Результат поиска

    private By Slider = By.xpath("//div[@class='main-slider slider-numeric show-block-wrap show']");// Слайдер с акциями

    private By DirectionsCompanyBlock = By.xpath("//div[@class = 'directions show-block']");// Блок направления компании

    private By DirectionsAnalyzesIcon = By.xpath("//img[@src='/upload/iblock/2eb/2ebc320961fea4cd4e3228805fb08a04.svg']");// Иконка Анализы

    private By DirectionsMedicalServicesIcon = By.xpath("//img[@src='/upload/iblock/8f6/8f68bfb300d3971284432f4d87f33f23.svg']");// Иконка Медицинские услуги

    private By DirectionsComplexIcon = By.xpath("//img[@src='/upload/iblock/474/474f7a1d59d79400968ade24bcb88fcb.svg']");// Иконка Комплексные обследования

    private By DirectionsDoctorServicesIcon = By.xpath("//img[@src='/upload/iblock/2db/2db82380661e1e42a2174682975b03a9.png']");// Иконка Услуги врачей

    private By FAQBlock = By.xpath("//div[@class = 'container container--no-border']");// Блок статьи

    private By NewsBlock = By.xpath("//section[@class='side-slider side-slider--news show-block side-slider--news-lg']");// Блок Новости

    private By AllNewsButton = By.xpath("//div[@class='side-nav__block']//a[@class = 'btn btn--empty']");// Кнопка Все новости

    private By DoctorsBlock = By.xpath("//section[@class='side-slider side-slider--doctors side-slider--blocks show-block side-slider--blocks-lg show-block--active']");// Блок Врачи-специалисты

    private By AllDoctorsButton = By.xpath("//div[@class='column--side side-nav__block']//a[@class = 'btn btn--empty']");// Кнопка Все врачи

    private By AboutCompanyBlock = By.xpath("//div[@class='count__inner']");// Блок коротко о компании

    private By AboutCompanyPlanetIcon = By.xpath("//img[@src='/local/templates/invitro_main/src/image/content/count-block/icon-count-1.svg']");// Иконка Планета

    private By AboutCompanyMicroscopeIcon = By.xpath("//img[@src='/local/templates/invitro_main/src/image/content/count-block/icon-count-2.svg']");// Иконка Микроскоп

    private By AboutCompanyMedicalOfficeIcon = By.xpath("//img[@src='/local/templates/invitro_main/src/image/content/count-block/icon-count-3.svg']");// Иконка МО

    private By AboutCompanyDoctorPhoto = By.xpath("//img[@src='/local/templates/invitro_main/src/image/content/count-block/count-bg.png']");// Иконка МО

    private By UpButton = By.xpath("//button[@class='up-button']");// Кнопка Наверх

    private By FooterMenuBlock = By.xpath("//div[@class='row ft__row']");// Блок футтер меню

    private By PrizeWinnerIcon = By.xpath("//img[@src='/local/templates/invitro_main/src/image/icons/quality.svg']");// Иконка МО

    private By IconFBinFooter = By.xpath("//a[@class = 'ft-social__link ft-social__link--fb']");//footer иконка Facebook

    private By IconOKinFooter = By.xpath("//a[@class = 'ft-social__link ft-social__link--ok']");//footer иконка Одноклассники

    private By IconVKinFooter = By.xpath("//a[@class = 'ft-social__link ft-social__link--vk']");//footer иконка VK

    private By IconYoutubeInFooter = By.xpath("//a[@class = 'ft-social__link ft-social__link--youtube']");//footer иконка YouTube

    private By IconInstInFooter = By.xpath("//a[@class = 'ft-social__link ft-social__link--instagram']");//footer иконка Instagram

    private By GroupOfCompaniesBlock = By.xpath("//div[@class = 'ft-partners--wrap']");// Блок Группа компаний ИНВИТРО

    private By LicenseBlock = By.xpath("//div[@class='ft-bottom__col']");// Блок Лицензия компании

    private By WorldIcon = By.xpath("//img[@src='/local/templates/invitro_main/src/image/content/footer/mir.svg']");// Иконка Мир

    private By MasterCardIcon = By.xpath("//img[@src='/local/templates/invitro_main/src/image/content/footer/mc.svg']");// Иконка MasterCard

    private By VisaIcon = By.xpath("//img[@src='/local/templates/invitro_main/src/image/content/footer/visa.svg']");// Иконка Visa

    private By AgeIcon = By.xpath("//div[@class='ft-age__wrapper']/*");// Иконка Планета

    private By AttentionPopUp = By.xpath("//div[@class='attention--header--item item--new']");

    private By AttentionPopUpClose = By.xpath("//div[@class='close-block']");
    ////////////////////////////////////////////////Кнопки главной страницы\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    private By CheckCity = By.xpath("//span[@class='city__name city__btn city__name--label']");

    private By AnalyzesBtnMP = By.xpath("//a[@class='header-nav__link'][text() = 'Анализы']");

    private By AdressesBtnMP = By.xpath("//a[@class='header-nav__link'][text() = 'Адреса']");

    private By AqBtnMP = By.xpath("//a[@class='header-nav__link'][text() = 'Акции']");

    private By VNDBtnMP = By.xpath("//a[@class='header-nav__link'][text() = 'Выезд на дом']");

    private By ToDoctorBtnMP = By.xpath("//a[@class='header-nav__link'][text() = 'Запись к врачу']");

    private By MedServBtnMP = By.xpath("//a[@class='header-nav__link'][text() = 'Медицинские услуги']");

    private By ComplexResBtnMP = By.xpath("//a[@class='header-nav__link'][text() = 'Комплексные обследования']");

    private By AppCookie = By.xpath("//button[contains(@class,'attention-close-button')]");

    /////////////////////////////////////////////////////Подписка\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    private By Sub_Applet = By.xpath("//div[@class = 'subscription']");

    private By Sub_Title = By.xpath("//h4[@class = 'subscription__title']");

    private By Sub_Email_Title = By.xpath("//h4[@class = 'subscription__field-title']");

    private By Sub_Email_Field = By.xpath("//input[@class = 'subscription__field-input input']");

    private By Sub_Sub_Btn = By.xpath("//a[@class = 'subscription__accept-btn btn-icon btn-icon--fill']");

    private By Sub_Cls_Btn = By.xpath("//a[@class = 'subscription__close-btn']");

    //////////////////////////////////////////////Исполняемый код\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public MainPage Search(String search) {
        find(SearchInput).sendKeys(search);
        find(SearchButton).waitUntilClickable().click();
        waitABit(5000);

        return this;
    }

    public void maximize() {      // развернуть окно
        getDriver().manage().window().maximize();
    }

    public void checkResultText() {
        Check_Visible_Element(ResultText);
    }

    public void checkAnalyzesText() {
        Check_Enabled_Element(AnalyzesText);
    }

    public void checkResultAfterSearchPage() {
        Check_Enabled_Element(ResultAfterSearchPage);
    }

    public void checkHeaderMenu() {
        Check_Enabled_Element(HeaderMenu);
    }

    public void checkHeaderCity() {
        Check_Enabled_Element(HeaderCity);
    }

    public void checkHeaderChangeCityPopUp() {
        Check_Enabled_Element(HeaderChangeCityPopUp);
    }

    public void checkHeaderEnterInLK() {
        Check_Enabled_Element(HeaderEnterInLK);
    }

    public void visibleInvitroLogo() {
        Check_Visible_Element(InvitroLogo);
    }

    public void checkHeaderPhoneBlock() {
        Check_Enabled_Element(HeaderPhoneBlock);
    }

    public void checkBasket() {
        Check_Enabled_Element(Basket);
    }

    public void сlickOpenMainMenu() {
        Click_Method(OpenMainMenu);
//        WebElementFacade element = element(OpenMainMenu).withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible();
//        element.click();
//        waitABit(2000);
        element(InvitroLogo).waitUntilVisible();
    }

    public void checkBurgerMenuBlock() {
        Check_Enabled_Element(BurgerMenuBlock);
    }

    public void сlickCloseMainMenu() {
        Click_Method(CloseMainMenu);
    }

    public void checkMainMenuBlock() {
        Check_Enabled_Element(MainMenuBlock);
    }

    public void checkGetTheTestResults() {
        Check_Enabled_Element(GetTheTestResults);
    }

    public void checkSearchInput() {
        Check_Enabled_Element(SearchInput);
    }

    public void checkSearchButton() {
        Check_Enabled_Element(SearchButton);
    }

    public void checkSlider() {
        Check_Enabled_Element(Slider);
    }

    public void checkDirectionsCompanyBlock() {
        Check_Enabled_Element(DirectionsCompanyBlock);
    }

    public void visibleDirectionsAnalyzesIcon() {
        Check_Visible_Element(DirectionsAnalyzesIcon);
    }

    public void visibleDirectionsMedicalServicesIcon() {
        Check_Visible_Element(DirectionsMedicalServicesIcon);
    }

    public void visibleDirectionsComplexIcon() {
        Check_Visible_Element(DirectionsComplexIcon);
    }

    public void visibleDirectionsDoctorServicesIcon() {
        Check_Visible_Element(DirectionsDoctorServicesIcon);
    }

    public void checkFAQBlock() {
        Check_Enabled_Element(FAQBlock);
    }

    public void checkNewsBlock() {
        Check_Enabled_Element(NewsBlock);
    }

    public void checkAllNewsButton() {
        Check_Enabled_Element(AllNewsButton);
    }

    public void checkDoctorsBlock() {
        Check_Enabled_Element(DoctorsBlock);
    }

    public void сlickYes_and_close_cookie() {
        element(CheckCity).waitUntilVisible();
        if (element(CheckCity).getText().equals("Москва")) {
            if (element(Yes_Btn).isVisible()) {
                getSlow5();
                element(Yes_Btn).waitUntilClickable().click();
            } else {
                getSlow5();
                Click_Method(ChangeOtherCity);
/*               getSlow5();
                element(Yes_Btn).waitUntilClickable().click();*/
            }
        } else {
            getSlow5();
            try {
                element(ChangeOtherCity).waitUntilVisible();
                getSlow5();
                Click_Method(ChangeOtherCity);
                getSlow5();
                Click_Method(Moscow_City);
            } catch (WebDriverException e) {
                getSlow5();
//               Click_Method(City_Applet);
                element(CheckCity).waitUntilClickable().click();
                getSlow5();
//               Click_Method(ChangeOtherCity);
                element(ChangeOtherCity).waitUntilVisible().waitUntilClickable().click();
                getSlow5();
                Click_Method(Moscow_City);
            }
//            if (element(ChangeOtherCity).isVisible()) {
//               getSlow5();
//               Click_Method(ChangeOtherCity);
//               getSlow5();
//               Click_Method(Moscow_City);
//            } else {
//               getSlow5();
////               Click_Method(City_Applet);
//                element(CheckCity).waitUntilClickable().click();
//               getSlow5();
////               Click_Method(ChangeOtherCity);
//                element(ChangeOtherCity).waitUntilVisible().waitUntilClickable().click();
//               getSlow5();
//               Click_Method(Moscow_City);
//            }
/*            if (element(Yes_Btn).isVisible()){
               getSlow5();
                element(Yes_Btn).waitUntilClickable().click();
            } else {
               Click_Method(ChangeOtherCity);
               getSlow5();
                element(Yes_Btn).waitUntilClickable().click();
            }*/
        }
    }

    public void checkAllDoctorsButton() {
        Check_Enabled_Element(AllDoctorsButton);
    }

    public void checkAboutCompanyBlock() {
        Check_Enabled_Element(AboutCompanyBlock);
    }

    public void visibleAboutCompanyPlanetIcon() {
        Check_Visible_Element(AboutCompanyPlanetIcon);
    }

    public void visibleAboutCompanyMicroscopeIcon() {
        Check_Visible_Element(AboutCompanyMicroscopeIcon);
    }

    public void visibleAboutCompanyMedicalOfficeIcon() {
        Check_Visible_Element(AboutCompanyMedicalOfficeIcon);
    }

    public void visibleAboutCompanyDoctorPhoto() {
        Check_Visible_Element(AboutCompanyDoctorPhoto);
    }

    public void checkUpButton() {
        Check_Enabled_Element(UpButton);
    }

    public void checkFooterMenuBlock() {
        Check_Enabled_Element(FooterMenuBlock);
    }

    public void visiblePrizeWinnerIcon() {
        Check_Visible_Element(PrizeWinnerIcon);
    }

    public void visibleIconFBinFooter() {
        Check_Visible_Element(IconFBinFooter);
    }

    public void visibleIconOKinFooter() {
        Check_Visible_Element(IconOKinFooter);
    }

    public void visibleIconVKinFooter() {
        Check_Visible_Element(IconVKinFooter);
    }

    public void visibleIconYoutubeInFooter() {
        Check_Visible_Element(IconYoutubeInFooter);
    }

    public void visibleIconInstInFooter() {
        Check_Visible_Element(IconInstInFooter);
    }

    public void checkGroupOfCompaniesBlock() {
        Check_Enabled_Element(GroupOfCompaniesBlock);
    }

    public void checkLicenseBlock() {
        Check_Enabled_Element(LicenseBlock);
    }

    public void visibleWorldIcon() {
        Check_Visible_Element(WorldIcon);
    }

    public void visibleMasterCardIcon() {
        Check_Visible_Element(MasterCardIcon);
    }

    public void visibleVisaIcon() {
        Check_Visible_Element(VisaIcon);
    }

    public void visibleAgeIcon() {
        Check_Visible_Element(AgeIcon);
    }

    ///////////////////////////////////////////////Жесткая проверка кнопок города Москва\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void checkAnalyzesBtn() {
        if (find(CheckCity).getText().equals("Москва")) {
            if (isElementVisible(AnalyzesBtnMP)) {
                System.out.println("Кнопка отображается");
            } else {
                assert (false) : ("Кнопка не отображается");
            }
        } else {
            assert (false) : ("Был выбран город " + find(CheckCity).getText() + ", вместо Москвы");
        }
    }

    public void checkAdressesBtnMP() {
        if (find(CheckCity).getText().equals("Москва")) {
            if (isElementVisible(AdressesBtnMP)) {
                System.out.println("Кнопка отображается");
            } else {
                assert (false) : ("Кнопка не отображается");
            }
        } else {
            assert (false) : ("Был выбран город " + find(CheckCity).getText() + ", вместо Москвы");
        }
    }

    public void checkAqBtnMP() {
        if (find(CheckCity).getText().equals("Москва")) {
            if (isElementVisible(AqBtnMP)) {
                System.out.println("Кнопка отображается");
            } else {
                assert (false) : ("Кнопка не отображается");
            }
        } else {
            assert (false) : ("Был выбран город " + find(CheckCity).getText() + ", вместо Москвы");
        }
    }

    public void checkVNDBtnMP() {
        if (find(CheckCity).getText().equals("Москва")) {
            if (isElementVisible(VNDBtnMP)) {
                System.out.println("Кнопка отображается");
            } else {
                assert (false) : ("Кнопка не отображается");
            }
        } else {
            assert (false) : ("Был выбран город " + find(CheckCity).getText() + ", вместо Москвы");
        }
    }

    public void checkToDoctorBtnMP() {
        if (find(CheckCity).getText().equals("Москва")) {
            if (isElementVisible(ToDoctorBtnMP)) {
                System.out.println("Кнопка отображается");
            } else {
                assert (false) : ("Кнопка не отображается");
            }
        } else {
            assert (false) : ("Был выбран город " + find(CheckCity).getText() + ", вместо Москвы");
        }
    }

    public void checkMedServBtnMP() {
        if (find(CheckCity).getText().equals("Москва")) {
            if (isElementVisible(MedServBtnMP)) {
                System.out.println("Кнопка отображается");
            } else {
                assert (false) : ("Кнопка не отображается");
            }
        } else {
            assert (false) : ("Был выбран город " + find(CheckCity).getText() + ", вместо Москвы");
        }
    }

    public void checkComplexResBtnMP() {
        if (find(CheckCity).getText().equals("Москва")) {
            if (isElementVisible(ComplexResBtnMP)) {
                System.out.println("Кнопка отображается");
            } else {
                assert (false) : ("Кнопка не отображается");
            }
        } else {
            assert (false) : ("Был выбран город " + find(CheckCity).getText() + ", вместо Москвы");
        }
    }

    public void AcceptCookie() {
        if (find(AppCookie).isVisible()) {
            find(AppCookie).waitUntilClickable().click();
        }
    }

    ////////////////////////////////////////Проверка наличия Сабскрайба\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void Check_Subscribe_Applet() {
        boolean checksubscribe = isElementVisible(Sub_Applet);
        if (checksubscribe) {
            //help.Verify_Text(Sub_Title, "Хочешь быть в курсе акций, спецпредложений и новинок в медицине? подпишись на рассылку!");
            //help.Verify_Text(Sub_Email_Title, "E-mail");
            Check_Visible_Element(Sub_Email_Field);
            Check_Visible_Element(Sub_Sub_Btn);
            Check_Visible_Element(Sub_Cls_Btn);
            Enter_Text(Sub_Email_Field, "sapfierus@mail.ru");
            Click_Method(Sub_Sub_Btn);
            //help.Click_Method(Sub_Cls_Btn);
        } else {
            System.out.println("Элемента пока ещё нет");
            //assert (false) : ("Нет блока подписки :(");
        }
    }
}



