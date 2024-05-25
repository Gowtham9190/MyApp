/*
 * Copyright (c) 2023 - 2024, SKILLBRIDGE. All Rights Reserved.
 *
 * This computer program is CONFIDENTIAL and a TRADE SECRET of SkillBridge.
 * The receipt or possession of this program does not convey any rights to use,
 * reproduce or disclose its contents in whole or in part, without the specific
 * written consent of SkillBridge. Any use, reproduction or disclosure of
 * this program without the express written consent of SkillBridge, is a
 * violation of the copyright laws and may subject you to criminal prosecution.
 */

package com.skillbridge.jira.poms;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class LoginPom extends AbstractPom {

    public LoginPom(WebDriver webDriver, NgWebDriver ngWebDriver){
        super(webDriver, ngWebDriver);
    }

    @FindBy(xpath = "//textarea[@title='Search']")
    private WebElement searchButton;

    public void clickOnSearchButton(){
        searchButton.click();
        waitForAngularRequestsToFinish();
    }

    public void enterTheKeywords(){
        searchButton.sendKeys("youtube");
        waitForAngularRequestsToFinish();
    }
}
