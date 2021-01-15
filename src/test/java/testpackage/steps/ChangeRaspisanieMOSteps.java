package testpackage.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import testpackage.pages.ChangeRaspisanieMOPage;

public class ChangeRaspisanieMOSteps {
    ChangeRaspisanieMOPage page;

    @When("^Проверка открытия поп-ап создания расписания работы для выбранного дня у найденного МО$")
    public void openRecord() { page.openRecord("05"); }

    @When("^Проверка элементов поп-апа и сохранение выбранного режима работы МО$")
    public void checkPopUpRaspisanie() { page.checkPopUpRaspisanie(); }

    @When("^Проверка открытия поп-ап редактирования расписания работы для выбранного дня у найденного МО$")
    public void openRecordTime() { page.openRecordTime("05"); }

    @When("^Проверка логов расписания ранее внесенных изменений$")
    public void changePopUp() { page.changePopUp(); }

    @When("^Проверка внесения изменений в режиме работы$")
    public void changeStartHours() { page.changeStartHours(); }

    @When("^Проверка удаления ранее созданного, измененного расписания МО на выбранный день$")
    public void clickDeleteButton() { page.clickDeleteButton(); }

}
