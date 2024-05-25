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
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class AbstractStepDef {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractStepDef.class);

    public AbstractStepDef(WebDriver webDriver, NgWebDriver ngWebDriver, ApplicationProperties applicationProperties) {
        this.webDriver = webDriver;
        this.ngWebDriver = ngWebDriver;
        this.applicationProperties = applicationProperties;
    }

    WebDriver webDriver;
    NgWebDriver ngWebDriver;
    ApplicationProperties applicationProperties;

    void waitForSecs(final int waitSecs) {
        try {
            TimeUnit.SECONDS.sleep(waitSecs);
        } catch (InterruptedException e) {
            LOG.error("Wait for seconds failed", e);
        }
    }
}
