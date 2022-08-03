package com.victor.screen.match.library;


import com.victor.screen.match.library.util.DimenTypes;
import com.victor.screen.match.library.util.MakeUtils;
import com.victor.screen.match.library.util.TvMakeUtils;


public class DimenGenerator {
    private static final Boolean isPhone = false;
    /**
     * 设计稿尺寸宽度
     */
    private static final int PHONE_DESIGN_WIDTH = 750;//750

    /**
     * 设计稿的高度
     */
    private static final int PHONE_DESIGN_HEIGHT = 1334;//1334

    //适配Android 3.2以上   大部分手机的sw值集中在300-450之间,平板的sw值集中在460-720之间
    private static final int DP_PHONE_SW_START = 300;
    private static final int DP_PHONE_SW_END = 720;


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
        //生成 Phone dimens.xml
        for (int i=DP_PHONE_SW_START;i<=DP_PHONE_SW_END;i+=10) {
            MakeUtils.makeAll(smallestWidth, i, "./library/src/main/res/");
        }

        if (!isPhone) {
            //生成 TV dimens.xml
            DimenTypes[] values = DimenTypes.values();
            for (DimenTypes value : values) {
                TvMakeUtils.makeTvAll(value.widthPx,value.heightPx,TV_DESIGN_WIDTH,TV_DESIGN_HEIGHT,"./library/src/main/res/");
            }

        }
    }

}
