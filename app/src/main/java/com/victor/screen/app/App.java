package com.victor.screen.app;

import android.app.Application;


/*
 * -----------------------------------------------------------------
 * Copyright (C) 2020-2030, by Victor, All rights reserved.
 * -----------------------------------------------------------------
 * File: App
 * Author: Victor
 * Date: 2020/9/14 10:52
 * Description:
 * -----------------------------------------------------------------
 */
public class App extends Application {
    private static App instance;

    public App() {
        instance = this;
    }

    public static App get() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}