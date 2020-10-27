package com.victor.screen.match.library;


import com.victor.screen.match.library.util.MakeUtils;


public class DimenGenerator {

    /**
     * 设计稿尺寸宽度
     */
    private static final int DESIGN_WIDTH = 750;

    /**
     * 设计稿的高度
     */
    private static final int DESIGN_HEIGHT = 1334;

    //适配Android 3.2以上   大部分手机的sw值集中在300-450之间,平板的sw值集中在460-720之间
    private static final int DP_SW_START = 300;
    private static final int DP_SW_END = 720;

    public static void main(String[] args) {
        //求得最小宽度
        int smallest = DESIGN_WIDTH>DESIGN_HEIGHT? DESIGN_HEIGHT:DESIGN_WIDTH;

        for (int i=DP_SW_START;i<=DP_SW_END;i+=10) {
            MakeUtils.makeAll(smallest, i, "./library/src/main/res/");
        }


    }

}
