package com.github;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@Owner("sedlachekvs")
@Severity(SeverityLevel.BLOCKER)
@Feature("Домашняя работа в репозитории")
@Story("Просмотр домашней работы в репозитории")
public class SelenidListenerTests {

    @Test
    @DisplayName("Чистый Selenide (с Listener)")
    public void testGithubRepositories (){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("SpaceSmile");
        $(".header-search-input").submit();

        $(byText("Users")).click();
        $(linkText("SpaceSmile")).click();

        $(partialLinkText("Repositories")).click();
        $(withText("qa_guru_12_dz3")).click();
    }




}
