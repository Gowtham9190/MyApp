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

package com.skillbridge.jira.util;

import com.skillbridge.jira.configuration.ApplicationProperties;
import org.apache.commons.lang3.StringUtils;

public class TestUtils {

    private TestUtils(){

    }

    public static String getUserName(final ApplicationProperties properties) {
        String userName = StringUtils.isNotEmpty(System.getProperty("user")) ? System.getProperty("user") :
                System.getProperty("u");
        return StringUtils.isEmpty(userName) ? properties.getUserName() : userName;
    }

    public static String getPassword(final ApplicationProperties properties) {
        String password = StringUtils.isNotEmpty(System.getProperty("password")) ? System.getProperty("password") :
                System.getProperty("p");
        return StringUtils.isEmpty(password) ? properties.getPassword() : password;
    }

    public static String getApplicationUrl(final ApplicationProperties properties) {
        String appUrl = System.getProperty("url");
        return StringUtils.isEmpty(appUrl) ? properties.getApplicationUrl() : appUrl;
    }
}
