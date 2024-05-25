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

package com.skillbridge.jira.stepdefs;

import com.paulhammant.ngwebdriver.NgWebDriver;
import com.skillbridge.jira.configuration.ApplicationProperties;
import com.skillbridge.jira.poms.LoginPom;
import com.skillbridge.jira.util.TestUtils;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginStepDef extends AbstractStepDef {

    private static final Logger LOG = LoggerFactory.getLogger(LoginStepDef.class);

    public LoginStepDef(WebDriver webDriver, NgWebDriver ngWebDriver, ApplicationProperties applicationProperties,
                        LoginPom loginPom) {
        super(webDriver, ngWebDriver, applicationProperties);
        this.loginPom = loginPom;
    }

    private final LoginPom loginPom;

    @Given("^Will go to google home page$")
    public void navigateToGooglePage() {
        String appUrl = TestUtils.getApplicationUrl(applicationProperties);
        webDriver.get(appUrl);
        waitForSecs(20);
        loginPom.clickOnSearchButton();
    }

    @Given("^Click on the search button$")
    public void clickOnSearchButton() {
        loginPom.clickOnSearchButton();
    }

    @Given("^Enter text youtube$")
    public void enterTheKeywordInSearchBar(){
        loginPom.enterTheKeywords();
    }
}
