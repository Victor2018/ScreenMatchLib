package com.victor.screen.match.library.data;

public enum DimenTypes {

    //适配Android 3.2以上 values-wxxxdp
    PX_W1280X720_DEFAULT(1280, 720, 240, 240),      //values
    PX_W800X480_240(800, 480, 240, 320),    //values-w320dp
    PX_W1280X720(1280, 720, 320, 360),      //values-w360dp
    PX_W1280X768_320(1280, 768, 320, 384),  //values-w384dp
    PX_W1024x600(1024, 600, 240, 400),      //values-w400dp
    PX_W2560X1440_560(2560, 1440, 560, 411),    //values-w411dp
    PX_W854X480_160(854, 480, 160, 480),    //values-w480dp
    PX_W854X480(854, 480, 120, 640),        //values-w640dp
    PX_W1024x600_240(1024, 600, 240, 600),  //values-w600dp
    PX_W1800X1080(1800, 1080, 400, 432),    //values-w432dp
    PX_W2560X1440(2560, 1440, 320, 720),     //values-w640dp
    PX_W2048X1536(2048, 1536, 320, 768),     //values-w640dp
    PX_W2560X1600(2560, 1600, 320, 800),      //values-w640dp
    PX_W2560X1600_480(2560, 1600, 480, 533),  //values-w533dp

    //适配Android 3.2以下 values-mdpi values-hdpi ...
    /*PX_320X240(320, 240, 120, true),       //values-ldpi
    PX_400x240(400, 240, 120),       //values-ldpi
    PX_432x240(432, 240, 120),       //values-ldpi
    PX_640X480(640, 480, 240),       //values-hdpi
    PX_800X480_120(800, 480, 120),   //values-ldpi-800x480*/
    PX_480X320(480, 320, 160, true),       //values-mdpi
    PX_800X480_160(800, 480, 160),   //values-mdpi-800x480
    PX_800X480_240(800, 480, 240, true),   //values-hdpi-800x480

    PX_854X480_120(854, 480, 120),   //values-ldpi-854x480
    PX_854X480_160(854, 480, 160),   //values-mdpi-854x480
    PX_854X480_240(854, 480, 240),   //values-hdpi-854x480

    PX_960X540(960, 540, 240),       //values-hdpi-960x540
    PX_960X640(960, 640, 320),       //values-xhdpi-960x640

    PX_1024X600_160(1024, 600, 160),   //values-mdpi-1024x600
    PX_1024X600_240(1024, 600, 240),   //values-hdpi-1024x600

    PX_1280X720_160(1280, 720, 160),   //values-mdpi-1280x720
    PX_1280X720_240(1280, 720, 240),   //values-hdpi-1280x720
    PX_1280X720_320(1280, 720, 320, true),   //values-xhdpi

    PX_1280X768_320(1280, 768, 320),   //values-xhdpi-1280x768

    PX_1280X800_240(1280, 800, 160),   //values-mdpi-1280x800
    PX_1280X800_213(1280, 800, 213),   //values-hdpi-1280x800
    PX_1280X800_320(1280, 800, 320),   //values-xhdpi-1280x800

    //PX_1920X1080_420(1920, 1080, 420),  //values-xxhdpi-1920x1080   API 16中引进的
    PX_1920X1080_480(1920, 1080, 480, true),  //values-xxhdpi-1920x1080   API 16中引进的

    //PX_1920X1200_320(1920, 1200, 320),  //values-xhdpi-1920x1200
    PX_2560X1440_640(2560, 1440, 640, true);   //values-xxxhdpi-2560x1440

    /*PX_1800X1080(1800, 1080, 400),
    PX_1920X1200_320(1920, 1200, 320),
    PX_1920X1200_400(1920, 1200, 400),
    PX_1920X1152(1920, 1152, 480),
    PX_2048X1536(2048, 1536, 320),
    PX_2560X1440_640(2560, 1440, 640),   //values-xxxhdpi

    PX_2560X1600_320(2560, 1600, 320),
    PX_2560X1600(2560, 1600, 640);*/

    /**
     * 宽
     */
    private int width;

    /**
     * 高
     */
    private int height;

    /**
     * 显示的逻辑密度
     */
    private float density;

    /**
     * 屏幕密度表示为每英寸点数
     */
    private int densityDpi;

    /**
     * 屏幕最小宽度
     */
    private int swWidthDp;

    /**
     * 排除在外
     * 即生成values-xxhdpi等
     * 后面不跟分辨率
     */
    private boolean exclude;

    DimenTypes(int height, int width, int densityDpi) {
        this.width = width;
        this.height = height;
        this.densityDpi = densityDpi;
    }

    DimenTypes(int height, int width, int densityDpi, boolean exclude) {
        this.width = width;
        this.height = height;
        this.densityDpi = densityDpi;
        this.exclude = exclude;
    }

    DimenTypes(int height, int width, int densityDpi, int swWidthDp) {
        this.width = width;
        this.height = height;
        this.densityDpi = densityDpi;
        this.swWidthDp = swWidthDp;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public int getDensityDpi() {
        return densityDpi;
    }

    public void setDensityDpi(int densityDpi) {
        this.densityDpi = densityDpi;
    }

    public int getSwWidthDp() {
        return swWidthDp;
    }

    public void setSwWidthDp(int swWidthDp) {
        this.swWidthDp = swWidthDp;
    }

    public boolean isExclude() {
        return exclude;
    }

    public void setExclude(boolean exclude) {
        this.exclude = exclude;
    }
}
