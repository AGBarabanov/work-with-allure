package com.barabanov.tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open(baseUrl);
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo){
        $(".header-search-button").click();
        $("#query-builder-test").setValue(repo);
        $(".header-search-button").pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnLinkRepository(String repo){
        $$(".Box-sc-g0xbh4-0.bBwPjs.search-title").find(text(repo)).click();
    }

    @Step("Открываем таб Issues")
    public void openTabIssue(){
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {issue}")
    public void shouldSeeIssueWithNumber(int issue){
        $(".opened-by").shouldHave(text("#" + issue));
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
