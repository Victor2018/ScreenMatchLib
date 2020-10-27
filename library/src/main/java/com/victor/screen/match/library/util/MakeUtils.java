package com.victor.screen.match.library.util;

import android.util.Log;

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


    private static final String XML_BASE_DPI = "<string name=\"base_dpi\">%ddp</string>\r\n";
    private  static final int MAX_SIZE = 750;


    /**
     * 生成的文件名
     */
    private static final String XML_NAME = "dimens.xml";


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
        float dpValue;
        String temp;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(XML_HEADER);
            sb.append(XML_RESOURCE_START);

            temp = String.format(XML_BASE_DPI, swWidthDp);
            sb.append(temp);

            for (int i = 0; i <= MAX_SIZE; i++) {
                dpValue = px2dip((float) i,swWidthDp,designWidth);
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
     * 生成的目标文件夹
     * 只需传宽进来就行
     *
     * @param swWidthDp
     * @param buildDir 生成的目标文件夹
     */
    public static void makeAll(int designWidth, int swWidthDp, String buildDir) {
        try {
            if (swWidthDp <= 0) return;

            String folderName = "values-sw" + swWidthDp + "dp";

            File file = new File(buildDir + File.separator + folderName);
            if (file.exists()) {
                file.delete();
            }
            file.mkdirs();

            FileOutputStream fos = new FileOutputStream(file.getAbsolutePath() + File.separator + XML_NAME);
            fos.write(makeAllDimens(swWidthDp,designWidth).getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
