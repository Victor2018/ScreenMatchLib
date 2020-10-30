package com.victor.screen.match.library.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

public class TvMakeUtils {
    private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n";
    private static final String XML_RESOURCE_START = "<resources>\r\n";
    private static final String XML_RESOURCE_END = "</resources>\r\n";
    private static final String XML_W_DIMEN_TEMPLETE = "<dimen name=\"w_%1$d\">%2$.2fpx</dimen>\r\n";
    private static final String XML_H_DIMEN_TEMPLETE = "<dimen name=\"h_%1$d\">%2$.2fpx</dimen>\r\n";


    /**
     * 生成的文件名
     */
    private static final String W_XML_NAME = "w_dimens.xml";
    private static final String H_XML_NAME = "h_dimens.xml";


    public static float calcuPx(int px,int designPx, float pxValue) {
        float wPx = (pxValue/(float)designPx) * px;
        BigDecimal bigDecimal = new BigDecimal(wPx);
        float finWpx = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        return finWpx;
    }

    /**
     * 生成所有的尺寸数据
     *
     * @param widthPx
     * @return
     */
    private static String makeWDimens(int widthPx, int designWidth) {
        String temp;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(XML_HEADER);
            sb.append(XML_RESOURCE_START);

            for (int i = 0; i <= designWidth; i++) {
                temp = String.format(XML_W_DIMEN_TEMPLETE, i, calcuPx(widthPx,designWidth,(float)i));
                sb.append(temp);
            }

            sb.append(XML_RESOURCE_END);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    private static String makeHDimens(int heightPx, int designHeight) {
        String temp;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(XML_HEADER);
            sb.append(XML_RESOURCE_START);

            for (int i = 0; i <= designHeight; i++) {
                temp = String.format(XML_H_DIMEN_TEMPLETE, i, calcuPx(heightPx,designHeight,(float)i));
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
     * @param widthPx
     * @param buildDir 生成的目标文件夹
     */
    public static void makeTvAll(int widthPx,int heightPx,int designWidth, int designHeight,String buildDir) {
        try {
            if (widthPx <= 0) return;
            if (heightPx <= 0) return;

            String folderName = "values-" + widthPx + "x" + heightPx;
            File file = new File(buildDir + File.separator + folderName);
            if (file.exists()) {
                file.delete();
            }
            file.mkdirs();


            //width
            FileOutputStream fos = new FileOutputStream(file.getAbsolutePath() + File.separator + W_XML_NAME);
            fos.write(makeWDimens(widthPx,designWidth).getBytes());
            fos.flush();
            fos.close();

            //height
            fos = new FileOutputStream(file.getAbsolutePath() + File.separator + H_XML_NAME);
            fos.write(makeHDimens(heightPx,designHeight).getBytes());
            fos.flush();
            fos.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
