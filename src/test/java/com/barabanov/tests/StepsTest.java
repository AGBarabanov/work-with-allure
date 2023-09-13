package com.barabanov.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class StepsTest extends TestBase {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 81;

    @Test
    public void testLambdaStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open(baseUrl);
        });
        step("Ищем репозиторий " + REPOSITORY,()->{
            $(".header-search-button").click();
            $("#query-builder-test").setValue(REPOSITORY);
            $(".header-search-button").pressEnter();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $$(".Box-sc-g0xbh4-0.bBwPjs.search-title").find(text(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () ->{
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + ISSUE, () -> {
            $(".opened-by").shouldHave(text("#" + ISSUE));
        } );
    }

    @Test
    public void testAnnotatedStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnLinkRepository(REPOSITORY);
        steps.openTabIssue();
        steps.shouldSeeIssueWithNumber(ISSUE);
    }
}
