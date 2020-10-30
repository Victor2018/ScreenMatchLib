package com.victor.screen.match.library.util;

/*
 * -----------------------------------------------------------------
 * Copyright (C) 2020-2030, by Victor, All rights reserved.
 * -----------------------------------------------------------------
 * File: DimenTypes
 * Author: Victor
 * Date: 2020/10/30 11:05
 * Description:
 * -----------------------------------------------------------------
 */
public enum  DimenTypes {
    TV_1024_600(1024,600),  // values-1024x600
    TV_1280_672(1280,672),
    TV_1280_720(1280,720),
    TV_1280_736(1280,736),
    TV_1280_800(1280,800),
    TV_1366_768(1366,768),
    TV_1920_1080(1920,1080),
    TV_2048_1440(2048,1440),
    TV_2048_1536(2048,1536),
    TV_2560_1440(2560,1440),
    TV_2560_1600(2560,1600);

    /**
     * 屏幕最小宽度
     */
    public int widthPx;//单位px
    public int heightPx;//单位px

    DimenTypes(int widthPx,int heightPx) {
        this.widthPx = widthPx;
        this.heightPx = heightPx;
    }


}
