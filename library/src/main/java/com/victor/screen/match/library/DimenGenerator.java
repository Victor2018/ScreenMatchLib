package com.victor.screen.match.library;


import com.victor.screen.match.library.util.PhoneDimenTypes;
import com.victor.screen.match.library.util.TVDimenTypes;
import com.victor.screen.match.library.util.HarmoneyMakeUtils;
import com.victor.screen.match.library.util.MakeUtils;
import com.victor.screen.match.library.util.TvMakeUtils;


public class DimenGenerator {
    private static final Boolean isPhone = true;
    /**
     * 设计稿尺寸宽度
     */
    private static final int PHONE_DESIGN_WIDTH = 750;//750

    /**
     * 设计稿的高度
     */
    private static final int PHONE_DESIGN_HEIGHT = 1334;//1334

    //适配Android 3.2以上   大部分手机的sw值集中在300-450之间,平板的sw值集中在460-720之间
    private static final int DP_PHONE_SW_START = 320;
    private static final int DP_PHONE_SW_END = 560;


    private static int[] HARMONEY_SW = new int[]{
            90,//sdpi 120dpi
            120,//mdpi 160dpi
            180,//ldpi 240dpi
            240,//xhdpi 320dpi
            360,//xxhdpi 480dpi
            480,//xxxhdpi 640dpi
            750,//lpx
    };


    /**
     * TV设计稿尺寸宽度
     */
    private static final int TV_DESIGN_WIDTH = 1920;

    /**
     * TV设计稿的高度
     */
    private static final int TV_DESIGN_HEIGHT = 1080;


    public static void main(String[] args) {
        //求得最小宽度
        int smallestWidth = PHONE_DESIGN_WIDTH > PHONE_DESIGN_HEIGHT ? PHONE_DESIGN_HEIGHT : PHONE_DESIGN_WIDTH;

        //生成 android 常规Phone dimens.xml
        for (int i=DP_PHONE_SW_START;i<=DP_PHONE_SW_END;i+=10) {
            String folderName = "values-sw" + i + "dp";
            MakeUtils.makeAll(smallestWidth, i, "./library/src/main/res/",folderName);
        }
        //生成android Phone 默认dimens.xml
        String folderName = "values";
        MakeUtils.makeAll(smallestWidth, 360, "./library/src/main/res/",folderName);

        //生成 android 非常规Phone dimens.xml
        PhoneDimenTypes[] phoneValues = PhoneDimenTypes.values();
        for (PhoneDimenTypes value : phoneValues) {
            String otherFolderName = "values-sw" + value.swWidthDp + "dp";
            MakeUtils.makeAll(smallestWidth, value.swWidthDp, "./library/src/main/res/",otherFolderName);
        }

        for (int sw: HARMONEY_SW) {
            HarmoneyMakeUtils.makeAll(smallestWidth, sw, "./library/src/main/assets/");
        }

        if (!isPhone) {
            //生成 TV dimens.xml
            TVDimenTypes[] tvValues = TVDimenTypes.values();
            for (TVDimenTypes value : tvValues) {
                TvMakeUtils.makeTvAll(value.widthPx,value.heightPx,TV_DESIGN_WIDTH,TV_DESIGN_HEIGHT,"./library/src/main/res/");
            }
        }
    }

}
