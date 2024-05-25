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
import com.skillbridge.jira.common.Timer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AbstractPom {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractPom.class);

    public AbstractPom(WebDriver webDriver, NgWebDriver ngWebDriver) {
        this.ngWebDriver = ngWebDriver;
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected NgWebDriver ngWebDriver;
    protected WebDriver webDriver;

    public WebElement waitForElementVisibility(By by) {
        return waitForElementVisibility(by, 5);
    }

    public void waitForAngularRequestsToFinish() {
        Timer timer = new Timer();
        try {
            ngWebDriver.waitForAngularRequestsToFinish();
        } finally {
            StackTraceElement priorMethod = Thread.currentThread().getStackTrace()[1];
            LOG.info("wait for angular requests. class: {}. method: {}, line number: {}, completed in, {}",
                    this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    priorMethod.getLineNumber(), timer.elapsedMillis());
        }
    }

    public WebElement waitForElementVisibility(By by, long timeOutInSeconds) {
        Timer timer = new Timer();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeOutInSeconds));
        WebElement webElement;
        try {
            webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } finally {
            StackTraceElement priorMethod = Thread.currentThread().getStackTrace()[1];
            LOG.info("wait for angular requests. class: {}. method: {}, line number: {}, completed in, {}",
                    this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    priorMethod.getLineNumber(), timer.elapsedMillis());
        }
        return webElement;
    }

    protected void waitForSecs(final int waitSecs) {
        try {
            TimeUnit.SECONDS.sleep(waitSecs);
        } catch (InterruptedException e) {
            LOG.warn("Wait for seconds failed", e);
            throw new RuntimeException(e);
        }
    }
}
