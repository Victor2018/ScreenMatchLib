package com.victor.screen.match.library.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

public class HarmoneyMakeUtils {
    private static final String JSON_START = "{\r\n";
    private static final String JSON_END = "}\r\n";
    private static final String JSON_ITEM_START = "\t\t{\r\n";
    private static final String JSON_ITEM_END = "\t\t},\r\n";
    private static final String JSON_ITEM_LAST_END = "\t\t}\r\n";
    private static final String ARRAY_START = "\t\"float\": [\r\n";
    private static final String ARRAY_END = "\t]\r\n";
    private static final String JSON_NAME_VP_TEMPLETE = "\t\t\t\"name\": \"vp_%1$d\",\r\n";
    private static final String JSON_NAME_FP_TEMPLETE = "\t\t\t\"name\": \"fp_%1$d\",\r\n";
    private static final String JSON_VALUE_VP_TEMPLETE = "\t\t\t\"value\": \"%1$.2fvp\"\r\n";
    private static final String JSON_VALUE_FP_TEMPLETE = "\t\t\t\"value\": \"%1$.2ffp\"\r\n";
    private static final int MAX_SIZE = 750;
    private static final String BASE_NAME_TEMPLETE = "\t\t\t\"name\": \"%s\",\n";
    private static final String BASE_VALUE_TEMPLETE = "\t\t\t\"value\": \"%dvp\"\n";


    /**
     * 生成的文件名
     */
    private static final String JSON_NAME = "design_vp.json";


    public static float px2dip(float pxValue, int sw,int designWidth) {
        float dpValue = (pxValue/(float)designWidth) * sw;
        BigDecimal bigDecimal = new BigDecimal(dpValue);
        float finDp = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        return finDp;
    }

    /**
     * 生成所有的尺寸数据
     *
     * @param swWidthDp
     * @return
     */
    private static String makeAllDimens(int swWidthDp, int designWidth) {
        float vpValue;
        String temp;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(JSON_START);
            sb.append(ARRAY_START);

            //添加base信息
            sb.append(JSON_ITEM_START);
            sb.append(String.format(BASE_NAME_TEMPLETE,getBaseName(swWidthDp)));
            sb.append(String.format(BASE_VALUE_TEMPLETE,swWidthDp));
            sb.append(JSON_ITEM_END);

            for (int i = 1; i <= MAX_SIZE; i++) {
                //添加fp
                sb.append(JSON_ITEM_START);
                sb.append(String.format(JSON_NAME_VP_TEMPLETE,i));

                vpValue = px2dip((float) i,swWidthDp,designWidth);
                System.err.println("vpValue = " + vpValue);
                temp = String.format(JSON_VALUE_VP_TEMPLETE, vpValue);
                sb.append(temp);

                sb.append(JSON_ITEM_END);

                //添加fp
                sb.append(JSON_ITEM_START);
                sb.append(String.format(JSON_NAME_FP_TEMPLETE,i));

                vpValue = px2dip((float) i,swWidthDp,designWidth);
                System.err.println("fpValue = " + vpValue);
                temp = String.format(JSON_VALUE_FP_TEMPLETE, vpValue);
                sb.append(temp);

                if (i == MAX_SIZE) {
                    sb.append(JSON_ITEM_LAST_END);
                } else {
                    sb.append(JSON_ITEM_END);
                }
            }

            sb.append(ARRAY_END);
            sb.append(JSON_END);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 生成的目标文件夹
     * 只需传宽进来就行
     *
     * @param swWidthDp
     * @param buildDir 生成的目标文件夹
     */
    public static void makeAll(int designWidth, int swWidthDp, String buildDir) {
        try {
            if (swWidthDp <= 0) return;

            File file = new File(buildDir);
            if (file.exists()) {
                file.delete();
            }
            file.mkdirs();

            String jsonFileName = "design_" + designWidth + "_" + swWidthDp + "_vp.json";

            FileOutputStream fos = new FileOutputStream(file.getAbsolutePath() + File.separator + jsonFileName);
            fos.write(makeAllDimens(swWidthDp,designWidth).getBytes());

            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getBaseName(int swWidthDp) {
        String baseName = null;
        switch (swWidthDp) {
            case 90: {
                baseName = "sdp_120dpi";
                break;
            }
            case 120: {
                baseName = "mdp_160dpi";
                break;
            }
            case 180: {
                baseName = "ldp_240dpi";
                break;
            }
            case 240: {
                baseName = "xhdpi_320dpi";
                break;
            }
            case 360: {
                baseName = "xxhdpi_480dpi";
                break;
            }
            case 480: {
                baseName = "xxxhdpi_640dpi";
                break;
            }
        }
        return baseName;
    }

}
