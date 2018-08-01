package com.victor.screen.match.library.util;

import com.victor.screen.match.library.data.DimenTypes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

public class MakeUtils {

    private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n";
    private static final String XML_RESOURCE_START = "<resources>\r\n";
    private static final String XML_RESOURCE_END = "</resources>\r\n";
    private static final String XML_DIMEN_TEMPLETE = "<dimen name=\"dp_%1$d\">%2$.2fdp</dimen>\r\n";
    private static final String XML_STRING_TEMPLETE = "<string name=\"app_name\">%s</string>\r\n";


    /**
     * 生成的适配目标的
     * 记录
     * 比如适配1080x720
     * 留作备份,方便以后扩展更正
     */
    private static final String XML_BASE_WIDTH = "<dimen name=\"base_width\">%dpx</dimen>\r\n";
    private static final String XML_BASE_HEIGHT = "<dimen name=\"base_height\">%dpx</dimen>\r\n";
    private static final String XML_BASE_DPI = "<dimen name=\"base_dpi\">%ddp</dimen>\r\n";

    /**
     * 生成的文件
     */
    private static final String XML_NAME = "dimens.xml";

    /**
     * 获取对应的Dpi级别
     *
     * @param screenDpi
     * @return
     */
    private static String getDpiLevel(int screenDpi) {
        String dpiLevel;
        if (screenDpi <= 120) {
            dpiLevel = "-ldpi";
        } else if (screenDpi <= 160) {
            dpiLevel = "-mdpi";
        } else if (screenDpi <= 240) {
            dpiLevel = "-hdpi";
        } else if (screenDpi <= 320) {
            dpiLevel = "-xhdpi";
        } else if (screenDpi <= 480) {
            dpiLevel = "-xxhdpi";
        } else if (screenDpi <= 640) {
            dpiLevel = "-xxxhdpi";
        } else {
            dpiLevel = "-xxxxhdpi";
        }
        return dpiLevel;
    }

    /**
     * 目标的px转换为相应的dp
     *
     * @param pxValue
     * @param px2dp
     * @param quality
     * @return
     */
    public static float px2dip(float pxValue, float px2dp, float quality) {
        float dpValue = px2dp * pxValue * quality;
        BigDecimal bigDecimal = new BigDecimal(dpValue);
        float finDp = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        return finDp;
    }

    /**
     * 生成所有的尺寸数据
     *
     * @param type
     * @param quality
     * @return
     */
    private static String makeAllDimens(DimenTypes type, float quality) {

        //一个像素点对应的dp值,基准为160dpi
        final float px2dp = (float) 160 / type.getDensityDpi();
        float dpValue;
        String temp;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(XML_HEADER);
            sb.append(XML_RESOURCE_START);
            //备份生成的相关信息
            temp = String.format(XML_BASE_WIDTH, type.getWidth());
            sb.append(temp);
            temp = String.format(XML_BASE_HEIGHT, type.getHeight());
            sb.append(temp);
            temp = String.format(XML_BASE_DPI, type.getDensityDpi());
            sb.append(temp);
            for (int i = 0; i <= 2560; i++) {
                dpValue = px2dip((float) i, px2dp, quality);
                temp = String.format(XML_DIMEN_TEMPLETE, i, dpValue);
                sb.append(temp);
            }
            sb.append(XML_RESOURCE_END);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 生成对应的String文件
     *
     * @param name
     * @return
     */
    private static String makeStrings(String name) {
        String temp;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(XML_HEADER);
            sb.append(XML_RESOURCE_START);
            temp = String.format(XML_STRING_TEMPLETE, name);
            sb.append(temp);
            sb.append(XML_RESOURCE_END);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 生成的目标文件夹
     * 只需传宽进来就行
     *
     * @param type     枚举类型
     * @param buildDir 生成的目标文件夹
     */
    public static void makeAll(int designWidth, DimenTypes type, String buildDir) {
        try {
            //生成规则
            String folderName = "values";
            if (type.getSwWidthDp() > 0) {
                //适配Android 3.2+
                if (type.getSwWidthDp() != 240) {
                    folderName = "values-sw" + type.getSwWidthDp() + "dp";
                }
                System.out.println("folderName = " + folderName);
            } else if (type.isExclude()) {
                //表示生成标准的values-mdpi values-hdpi 后面不跟分辨率
                //folderName = "values" + getDpiLevel(type.getDensityDpi());
                //暂不生成
                return;
            } else {
                //生成带分辨率的values-hdpi-1280x720
                //folderName = "values" + getDpiLevel(type.getDensityDpi()) + "-" + type.getHeight() + "x" + type.getWidth();
                //暂不生成
                return;
            }
            //生成目标目录
            File file = new File(buildDir + File.separator + folderName);
            if (!file.exists()) {
                file.mkdirs();
            }

            //生成values-xxdpi ...等文件
            FileOutputStream fos = new FileOutputStream(file.getAbsolutePath() + File.separator + XML_NAME);
            fos.write(makeAllDimens(type, (float) type.getWidth() / designWidth).getBytes());
            fos.flush();
            fos.close();

            //生成strings.xml文件
            /*FileOutputStream strFos = new FileOutputStream(file.getAbsolutePath() + File.separator + "strings.xml");
            strFos.write(makeStrings(folderName).getBytes());
            strFos.flush();
            strFos.close();*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
