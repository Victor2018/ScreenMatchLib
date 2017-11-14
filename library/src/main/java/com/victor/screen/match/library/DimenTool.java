package com.victor.screen.match.library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by victor on 2017/11/3.
 */

public class DimenTool {
    //默认dimension 屏幕 dp值 ,defaultDp
    public final static int defaultDp = 400;

    public static void main(String[] args) {
        makeBaseXml(720,1280,240,0.64,"./library/src/main/res/values/dimens.xml");
        makeBaseXml(480,800,240,0.43,"./library/src/main/res/values-w320dp/dimens.xml");
        makeBaseXml(720,1280,320,0.48,"./library/src/main/res/values-w360dp/dimens.xml");
        makeBaseXml(768,1280,320,0.51,"./library/src/main/res/values-w384dp/dimens.xml");
        makeBaseXml(600,1024,240,0.53,"./library/src/main/res/values-w400dp/dimens.xml");
        makeBaseXml(1440,2560,560,0.55,"./library/src/main/res/values-w411dp/dimens.xml");
        makeBaseXml(1080,1800,400,0.58,"./library/src/main/res/values-w432dp/dimens.xml");
        makeBaseXml(480,854,160,0.64,"./library/src/main/res/values-w480dp/dimens.xml");
        makeBaseXml(1600,2560,480,0.71,"./library/src/main/res/values-w533dp/dimens.xml");
        makeBaseXml(1200,1920,320,0.80,"./library/src/main/res/values-w600dp/dimens.xml");
        makeBaseXml(480,854,120,0.85,"./library/src/main/res/values-w640dp/dimens.xml");
        makeBaseXml(1440,2560,320,0.96,"./library/src/main/res/values-w720dp/dimens.xml");
        makeBaseXml(1536,2049,320,1.02,"./library/src/main/res/values-w768dp/dimens.xml");
        makeBaseXml(1600,2560,320,1.07,"./library/src/main/res/values-w800dp/dimens.xml");
//        davn();
    }

    /**
     * @param width
     * @param height
     * @param dp
     * @param value
     * width*height dp    value
     * 720*1280    240dp  0.64dp
     * 480*800     240dp  0.43dp     values-w320dp
     * 720*1280    320dp  0.48dp     values-w360dp
     * 768*1280    320dp  0.51dp     values-w384dp
     * 600*1024    240dp  0.53dp     values-w400dp
     * 1440*2560   560dp  0.55dp     values-w411dp
     * 1080*1800   400dp  0.58dp     values-w432dp
     * 480*854     160dp  0.64dp     values-w480dp
     * 1600*2560   480dp  0.71dp     values-w533dp
     * 1200*1920   320dp  0.80dp     values-w600dp
     * 480*854     120dp  0.85dp     values-w640dp
     * 1440*2560   320dp  0.96dp     values-w720dp
     * 1536*2049   320dp  1.02dp     values-w768dp
     * 1600*2560   320dp  1.07dp     values-w800dp
     */
    public static void makeBaseXml (int width,int height,int dp,double value,String path) {
        File file = new File(path);
        Make(file);
        StringBuilder baseXml = new StringBuilder();
        baseXml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n");
        baseXml.append("<resources>\r\n");

        String head = "\t<dimen name=\"base_width\">"+ width +"px</dimen>\r\n" +
                "\t<dimen name=\"base_heigth\">"+ height +"px</dimen>\r\n" +
                "\t<dimen name=\"base_dpi\">"+ dp +"dp</dimen>\r";
        baseXml.append(head);

        String start = "\t<dimen name=\"dp_";
        String content = "\">";
        String end = "</dimen>";

        for (int i=0;i<=2560;i++) {
            baseXml.append(start);
            baseXml.append(i);
            baseXml.append(content);
            baseXml.append(String.format("%.2f",value*i) + "dp");
            baseXml.append(end);
            baseXml.append("\r\n");
        }

        baseXml.append("</resources>\r\n");
        writeFile(file,baseXml.toString());
    }

    public static void davn() {
        //以此文件夹下的dimens.xml文件内容为初始值参照
        File file = new File("./app/src/main/res/values/dimens.xml");

        BufferedReader reader = null;
        StringBuilder sw240 = new StringBuilder();
        StringBuilder sw320 = new StringBuilder();
        StringBuilder sw360 = new StringBuilder();
        StringBuilder sw384 = new StringBuilder();
        StringBuilder sw400 = new StringBuilder();
        StringBuilder sw411 = new StringBuilder();
        StringBuilder sw432 = new StringBuilder();
        StringBuilder sw480 = new StringBuilder();
        StringBuilder sw533 = new StringBuilder();
        StringBuilder sw600 = new StringBuilder();
        StringBuilder sw640 = new StringBuilder();
        StringBuilder sw720 = new StringBuilder();
        StringBuilder sw768 = new StringBuilder();
        StringBuilder sw800 = new StringBuilder();
        StringBuilder sw820 = new StringBuilder();
        StringBuilder sw1280 = new StringBuilder();
        StringBuilder sw1920 = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {

                if (tempString.contains("</dimen>")) {
                    //tempString = tempString.replaceAll(" ", "");

                    String start = tempString.substring(0, tempString.indexOf(">") + 1);

                    String end = tempString.substring(tempString.lastIndexOf("<") - 2);
                    //截取<dimen></dimen>标签内的内容，从>右括号开始，到左括号减2，取得配置的数字
                    Double num = Double.parseDouble
                            (tempString.substring(tempString.indexOf(">") + 1,
                                    tempString.indexOf("</dimen>") - 2));
                    // TODO: 2017/3/28 更改比例乘积

                    //根据不同的尺寸，计算新的值，拼接新的字符串，并且结尾处换行。

                    sw240.append(start).append(String.format("%.2f", num *defaultDp/240)).append(end).append("\r\n");
                    sw320.append(start).append(String.format("%.2f", num *defaultDp/320)).append(end).append("\r\n");
                    sw360.append(start).append(String.format("%.2f", num * defaultDp/360)).append(end).append("\r\n");
                    sw384.append(start).append(String.format("%.2f", num * defaultDp/384)).append(end).append("\r\n");
                    sw400.append(start).append(String.format("%.2f", num * defaultDp/400)).append(end).append("\r\n");
                    sw411.append(start).append(String.format("%.2f", num * defaultDp/411)).append(end).append("\r\n");
                    sw432.append(start).append(String.format("%.2f", num * defaultDp/432)).append(end).append("\r\n");
                    sw480.append(start).append(String.format("%.2f", num * defaultDp/480)).append(end).append("\r\n");
                    sw533.append(start).append(String.format("%.2f", num * defaultDp/533)).append(end).append("\r\n");
                    sw600.append(start).append(String.format("%.2f", num * defaultDp/600)).append(end).append("\r\n");
                    sw640.append(start).append(String.format("%.2f", num * defaultDp/640)).append(end).append("\r\n");
                    sw720.append(start).append(String.format("%.2f", num * defaultDp/720)).append(end).append("\r\n");
                    sw768.append(start).append(String.format("%.2f", num * defaultDp/768)).append(end).append("\r\n");
                    sw800.append(start).append(String.format("%.2f", num * defaultDp/800)).append(end).append("\r\n");
                    sw820.append(start).append(String.format("%.2f", num * defaultDp/820)).append(end).append("\r\n");
                    sw1280.append(start).append(String.format("%.2f", num * defaultDp/1280)).append(end).append("\r\n");
                    sw1920.append(start).append(String.format("%.2f", num * defaultDp/1920)).append(end).append("\r\n");


                } else {
                    sw240.append(tempString).append("");
                    sw320.append(tempString).append("");
                    sw360.append(tempString).append("");
                    sw384.append(tempString).append("");
                    sw400.append(tempString).append("");
                    sw411.append(tempString).append("");
                    sw432.append(tempString).append("");
                    sw480.append(tempString).append("");
                    sw533.append(tempString).append("");
                    sw600.append(tempString).append("");
                    sw640.append(tempString).append("");
                    sw720.append(tempString).append("");
                    sw768.append(tempString).append("");
                    sw800.append(tempString).append("");
                    sw820.append(tempString).append("");
                    sw1280.append(tempString).append("");
                    sw1920.append(tempString).append("");
                }
            }

            reader.close();
            System.out.println("<!--  sw240 -->");
            System.out.println(sw240);

            System.out.println("<!--  sw320 -->");
            System.out.println(sw320);

            System.out.println("<!--  sw360 -->");
            System.out.println(sw360);

            System.out.println("<!--  SW384 -->");
            System.out.println(sw384);

            System.out.println("<!--  sw400 -->");
            System.out.println(sw400);

            System.out.println("<!--  sw411 -->");
            System.out.println(sw411);

            System.out.println("<!--  sw432 -->");
            System.out.println(sw432);

            System.out.println("<!--  sw480 -->");
            System.out.println(sw480);

            System.out.println("<!--  sw533 -->");
            System.out.println(sw533);

            System.out.println("<!--  sw600 -->");
            System.out.println(sw600);

            System.out.println("<!--  sw640 -->");
            System.out.println(sw640);

            System.out.println("<!--  sw720 -->");
            System.out.println(sw720);

            System.out.println("<!--  sw768 -->");
            System.out.println(sw768);

            System.out.println("<!--  sw800 -->");
            System.out.println(sw800);

            System.out.println("<!--  sw820 -->");
            System.out.println(sw820);

            System.out.println("<!--  sw1280 -->");
            System.out.println(sw1280);

            System.out.println("<!--  sw1920 -->");
            System.out.println(sw1920);

        // E:\Worke\XutilsPeractic\app\src\main\res\values-w820dp

        // String sw240file = “./app/src/main/res/values-sw240dp-land/dimens.xml”;
        // String sw480file = “./app/src/main/res/values-sw480dp-land/dimens.xml”;
        // String sw600file = “./app/src/main/res/values-sw600dp-land/dimens.xml”;
        // String sw720file = “./app/src/main/res/values-sw720dp-land/dimens.xml”;
        // String sw800file = “values-sw800dp-land/dimens.xml”;

            //直接指定文件夹路径，以及文件名及格式。上来就是干！
            File w240 = new File("./app/src/main/res/values-w240dp/dimens.xml");
            File w320 = new File("./app/src/main/res/values-w320dp/dimens.xml");
            File w360 = new File("./app/src/main/res/values-w360dp/dimens.xml");
            File w384 = new File("./app/src/main/res/values-w384dp/dimens.xml");
            File w400 = new File("./app/src/main/res/values-w400dp/dimens.xml");
            File w411 = new File("./app/src/main/res/values-w411dp/dimens.xml");
            File w432 = new File("./app/src/main/res/values-w432dp/dimens.xml");
            File w480 = new File("./app/src/main/res/values-w480dp/dimens.xml");
            File w533 = new File("./app/src/main/res/values-w533dp/dimens.xml");
            File w600 = new File("./app/src/main/res/values-w600dp/dimens.xml");
            File w640 = new File("./app/src/main/res/values-w640dp/dimens.xml");
            File w720 = new File("./app/src/main/res/values-w720dp/dimens.xml");
            File w768 = new File("./app/src/main/res/values-w768dp/dimens.xml");
            File w800 = new File("./app/src/main/res/values-w800dp/dimens.xml");
            File w820 = new File("./app/src/main/res/values-w820dp/dimens.xml");
            File w1280 = new File("./app/src/main/res/values-w1280dp/dimens.xml");
            File w1920 = new File("./app/src/main/res/values-w1920dp/dimens.xml");

            Make(w240);
            Make(w320);
            Make(w360);
            Make(w384);
            Make(w400);
            Make(w411);
            Make(w432);
            Make(w480);
            Make(w533);
            Make(w600);
            Make(w640);
            Make(w720);
            Make(w768);
            Make(w800);
            Make(w820);
            Make(w1280);
            Make(w1920);

            //将新的内容，写入到指定的文件中去
            writeFile(w240, sw240.toString());
            writeFile(w320, sw320.toString());
            writeFile(w360, sw360.toString());
            writeFile(w384, sw384.toString());
            writeFile(w400, sw400.toString());
            writeFile(w411, sw411.toString());
            writeFile(w432, sw432.toString());
            writeFile(w480, sw480.toString());
            writeFile(w533, sw480.toString());
            writeFile(w600, sw600.toString());
            writeFile(w640, sw640.toString());
            writeFile(w720, sw720.toString());
            writeFile(w768, sw768.toString());
            writeFile(w800, sw800.toString());
            writeFile(w820, sw820.toString());
            writeFile(w1280, sw1280.toString());
            writeFile(w1920, sw1920.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

        }

    }


    /**
     * 写入方法
     */

    public static void writeFile(File file, String text) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
    }

    //自定义检测生成指定文件夹下的指定文件
    public static void Make(File file) {
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
