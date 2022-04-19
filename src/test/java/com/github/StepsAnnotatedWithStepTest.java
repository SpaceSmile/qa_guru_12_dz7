package com.github;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("sedlachekvs")
@Severity(SeverityLevel.BLOCKER)
@Feature("Домашняя работа в репозитории")
@Story("Просмотр домашней работы в репозитории")
public class StepsAnnotatedWithStepTest {
    String
            userName = "SpaceSmile",
            tabGitSearch = "Users",
            tabGitUser = "Repositories",
            userDz = "qa_guru_12_dz3";
    @Test
    @DisplayName("Шаги с аннотацией @Step")
    public void testGithubRepositories (){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchUser(userName);
        steps.clickUser(userName, tabGitSearch);
        steps.clickRepositories(tabGitUser);
        steps.searchUserDomRab(userDz);
    }

}
