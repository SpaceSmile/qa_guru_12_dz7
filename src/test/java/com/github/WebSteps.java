package com.github;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем пользователя {user}")
    public void searchUser(String user) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(user);
        $(".header-search-input").submit();
    }

    @Step("Переходим в профиль пользователя {user}")
    public void clickUser(String user, String tabGit){
        $(byText(tabGit)).click();
        $(linkText(user)).click();
    }

    @Step("Кликаем на таб Repositories {user}")
    public void clickRepositories(String repo) {
        $(partialLinkText(repo)).click();
    }

    @Step("Проверяем что существует домашнее задание {userDomRab}")
    public void searchUserDomRab (String userDomRab){
        $(withText(userDomRab)).click();
    }
}
