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

package com.skillbridge.jira.configuration;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class WebDriversConfig {

    @Bean
    @Scope("cucumber-glue")
    public WebDriver webDriver(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/webdrivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--allow-running-insecure-content");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        return driver;
    }

    @Bean
    @Scope("cucumber-glue")
    public NgWebDriver ngWebDriver(WebDriver driver){
        return new NgWebDriver((ChromeDriver) driver).withRootSelector("\"app-root\"");
    }
}
