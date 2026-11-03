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
public enum PhoneDimenTypes {
    SW_347(347),  // values-sw347dp
    SW_352(352),  // values-sw352dp
    SW_369(369),  // values-sw369dp
    SW_373(373),  // values-sw373dp
    SW_384(384),  // values-sw384dp
    SW_391(391),  // values-sw391dp
    SW_392(392),  // values-sw392dp
    SW_393(393),  // values-sw393dp
    SW_411(411),  // values-sw411dp
    SW_423(423),  // values-sw423dp
    SW_432(432),  // values-sw432dp
    SW_533(533);  // values-sw533dp

    /**
     * 屏幕最小宽度
     */
    public int swWidthDp;

    PhoneDimenTypes(int swWidthDp) {
        this.swWidthDp = swWidthDp;
    }

}
