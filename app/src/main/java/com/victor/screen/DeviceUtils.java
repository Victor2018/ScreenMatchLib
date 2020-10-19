package com.victor.screen;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.victor.screen.app.App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Locale;

/*
 * -----------------------------------------------------------------
 * Copyright (C) 2020-2030, by Victor, All rights reserved.
 * -----------------------------------------------------------------
 * File: DeviceUtils
 * Author: Victor
 * Date: 2020/9/14 11:17
 * Description: 获取设备的信息
 * -----------------------------------------------------------------
 */

public class DeviceUtils {

    private static DisplayMetrics mDisplayMetrics;

    /**
     * 获取设备的宽和高
     *
     * @return
     */
    public static DisplayMetrics getDisplayMetrics() {
        if (mDisplayMetrics == null) {
            mDisplayMetrics = App.get().getResources().getDisplayMetrics();
        }
        return mDisplayMetrics;
    }

    public static int getDisplayWidth() {
        if (mDisplayMetrics == null) {
            mDisplayMetrics = App.get().getResources().getDisplayMetrics();
        }
        return mDisplayMetrics.widthPixels;
    }

    public static int getDisplayHeight() {
        if (mDisplayMetrics == null) {
            mDisplayMetrics = App.get().getResources().getDisplayMetrics();
        }
        return mDisplayMetrics.heightPixels;
    }

    @SuppressLint("NewApi")
    public static boolean checkPermission(Context context, String permission) {
        boolean result = false;
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
                result = true;
            }
        } else {
            PackageManager pm = context.getPackageManager();
            if (pm.checkPermission(permission, context.getPackageName()) == PackageManager.PERMISSION_GRANTED) {
                result = true;
            }
        }
        return result;
    }

    /**
     * 获取设备的唯一标识 物理地址加device id
     *
     * @return
     */
    @SuppressLint("MissingPermission")
    public static String getUDID() {
        try {
            TelephonyManager tm = (TelephonyManager) App.get().getSystemService(Context.TELEPHONY_SERVICE);
            String device_id = null;
            if (checkPermission(App.get(), Manifest.permission.READ_PHONE_STATE)) {
                device_id = tm.getDeviceId();
            }
            if (TextUtils.isEmpty(device_id)) {
                device_id = android.provider.Settings.Secure.getString(App.get().getContentResolver(),
                        android.provider.Settings.Secure.ANDROID_ID);
            }
//            return CryptoUtils.MD5(device_id);
            return device_id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMac() {
        String mac_s= "";
        try {
            byte[] mac;
            NetworkInterface ne= NetworkInterface.getByInetAddress(InetAddress.getByName(getLocalIpAddress()));
            mac = ne.getHardwareAddress();
            mac_s = byte2hex(mac);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mac_s;
    }

    public static String getEthernetMac() {
        BufferedReader reader = null;
        String ethernetMac = "";
        try {
            reader = new BufferedReader(new FileReader(
                    "sys/class/net/eth0/address"));
            ethernetMac = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ethernetMac.toUpperCase();
    }

    public static String getTVMac() {
        StringBuffer tvMac = new StringBuffer();
        String mac = getMac().toUpperCase();
        try {
            for (int i=0;i<mac.length() / 2;i++) {
                tvMac.append(mac.substring(i*2,(i+1)*2) + ":");
            }
            tvMac.deleteCharAt(tvMac.lastIndexOf(":"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tvMac.toString();
    }

    public static String byte2hex(byte[] b) {
        StringBuffer hs = new StringBuffer(b.length);
        String stmp = "";
        int len = b.length;
        for (int n = 0; n < len; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1)
                hs = hs.append("0").append(stmp);
            else {
                hs = hs.append(stmp);
            }
        }

        return String.valueOf(hs);
    }


    public static String getLocalIpAddress() {
        String sLocalIPAddress = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
                 en.hasMoreElements();) {
                NetworkInterface netInterface = (NetworkInterface) en.nextElement();

                for (Enumeration<InetAddress> ipaddr = netInterface.getInetAddresses();
                     ipaddr.hasMoreElements();) {

                    InetAddress inetAddress = (InetAddress) ipaddr.nextElement();

                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        sLocalIPAddress = inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return sLocalIPAddress;
    }

    /**
     * 获取手机品牌
     *
     * @return
     */
    public static String getPhoneBrand() {
        return Build.BRAND;
    }

    /**
     * 获取系统版本
     *
     * @return
     */
    public static String getSysVersion() {
        return Build.VERSION.RELEASE;
    }
    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getPhoneModel() {
        return Build.MODEL;
    }

    public static String getSysLanguage () {
        Locale locale = Locale.getDefault();
        return locale.getLanguage();
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return  系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取屏幕尺寸
     */
    @SuppressWarnings("deprecation")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public static Point getScreenSize(Context context){
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB_MR2){
            return new Point(display.getWidth(), display.getHeight());
        }else{
            Point point = new Point();
            display.getSize(point);
            return point;
        }
    }

    /**
     * 获取手机厂商
     *
     * @return  手机厂商
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }

}

