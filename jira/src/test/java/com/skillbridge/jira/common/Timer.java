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

package com.skillbridge.jira.common;

public class Timer {

    public Timer() {
        this.startMillis = System.currentTimeMillis();
    }

    public String elapsedMillis() {
        long millis = System.currentTimeMillis() - startMillis;
        return millis + " (" + formatReadable(millis) + ")";
    }

    private static String formatReadable(long millis) {
        if (millis < 1000) {
            return millis + "ms";
        }
        return millis + "s";
    }

    private final long startMillis;
}
