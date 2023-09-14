package com.barabanov.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest extends TestBase{

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("BarabanovAG")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Ссылка на Test Case", url = "jira.example.com")
    @DisplayName("Создание Issue для авторизованого пользователя")
    public void testStaticLabels(){

    }

    @Test
    public void testDynamicLabels(){

    }
}
