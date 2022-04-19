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
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@Owner("sedlachekvs")
@Severity(SeverityLevel.BLOCKER)
@Feature("Домашняя работа в репозитории")
@Story("Просмотр домашней работы в репозитории")
public class LambdaStepsViaStepTests {
    String
        userName = "SpaceSmile",
        tabGitSearch = "Users",
        tabGitUser = "Repositories",
        userDz = "qa_guru_12_dz3";

    @Test
    @DisplayName("Лямбда шаги через step (name, () -> {})")
    public void testGithubRepositories () {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем пользователя " + userName, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(userName);
            $(".header-search-input").submit();
        });
        step("Переходим в профиль пользователя " + userName, () -> {
            $(byText(tabGitSearch)).click();
            $(linkText(userName)).click();
        });
        step("Кликаем на таб Repositories " + userName, () -> {
            $(partialLinkText(tabGitUser)).click();
        });
        step("Проверяем что существует домашнее задание " + userDz, () -> {
            $(withText(userDz)).click();
        });
    }
}
