package com.barabanov.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest extends TestBase {

    @Test
    public void testIssueSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(baseUrl);

        $(".header-search-button").click();
        $("#query-builder-test").setValue("eroshenkoam/allure-example");
        $(".header-search-button").pressEnter();

        $$(".Box-sc-g0xbh4-0.bBwPjs.search-title").find(text("eroshenkoam/allure-example")).click();

        $("#issues-tab").click();
        $(".opened-by").shouldHave(text("#81"));
    }
}
