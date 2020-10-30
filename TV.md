# 概念

- dp(dip)： Density Independent Pixels（密度无关像素）的缩写。以160dpi为基准，1dp=1px

- px：像素，物理上的绝对单位

- sp：Scale-Independent Pixels的缩写，可以根据文字大小首选项自动进行缩放。Google推荐我们使用12sp以上的大小，通常可以使用12sp，14sp，18sp，22sp，最好不要使用奇数和小数。

- dpi：屏幕像素密度的单位，“dot per inch”的缩写

- density：每平方英寸像素点数。

  

px = density * dp; 

density = dpi / 160; 

px = dp * (dpi / 160);

#### 屏幕尺寸、分辨率、像素密度三者关系

一部手机的分辨率是宽x高，屏幕大小是以寸为单位，那么三者的关系是：

![img](https://upload-images.jianshu.io/upload_images/944365-2b5dc928ab334440.png?imageMogr2/auto-orient/strip|imageView2/2/w/360/format/webp)

dpi=√(width^2 x height^2)/屏幕尺寸



# 屏幕密度



| 密度类型             | 代表的分辨率（px） | 屏幕像素密度（dpi） |
| :------------------- | :----------------: | :-----------------: |
| 低密度（ldpi）       |      240x320       |         120         |
| 中密度（mdpi）       |      320x480       |         160         |
| 高密度（hdpi）       |      480x800       |         240         |
| 超高密度（xhdpi）    |      720x1280      |         320         |
| 超超高密度（xxhdpi） |     1080x1920      |         480         |



# TV

Name                            Play Store   Size     Resolution      Density                     SmallestWidthDp

AndroidTV(720p)                              55"       1280*720        tvdpi                720/(213/160.0) = 540.85dp

AndroidTV(1080p)                            55"       1920*1080     xhdpi                1080/(320/160.0)=540.0dp



# Phone

Name                          Play Store   Size                Resolution         Density                 SmallestWidthDp

Pixel XL                                            5.5"                1440*2560         560dpi                 1440/(560/160.0) = 411.43dp

Pixel 3a XL                                       6.0"                1080*2160         400dpi                  1080/(400/160.0) = 432.0dp

Pixel 3a                      --                    5.6"                1080*2220         440dpi                  1080/(440/160.0) = 392.73dp

Pixel 3 XL                                         6.3"                 1440*2960         560dpi                  1440/(560/160.0) = 411.43dp

Pixel 3                        --                   5.46"                1080*2160         440dpi                  1080/(440/160.0) =392.73dp

Pixel 2 XL                                        5.99"                1440*2880          560dpi                 1440/(560/160.0) = 411.43dp

Pixel 2                       --                    5.0"                  1080*1920          420dpi                  1080/(420/160.0) =411.43dp

Pixel                          --                    5.0"                   1080*1920          420dpi                  1080/(420/160.0)=411.43dp

Nexus S                                           4.0"                    480*800              hdpi                     480/(240/160.0)=320.0dp

Nexus One                                     3.7"                    480*800               hdpi                    480/(240/160.0)=320.0dp

Nexus 6P                                        5.7"                    1440*2560           560dpi               1440/(560/160.0)=411.43dp

Nexus 6                                         5.96"                    1440*2560           560dpi               1440/(560/160.0)=411.43dp

Nexus 5X               --                     5.2"                    1080*1920           420dpi                 1080/(420/160.0)=411.43dp

Nexus 5                  --                     4.95"                    1080*1920           xxhdpi               1080/(480/160.0)=360.0dp

Nexus 4                                         4.7"                    768*1280               xhdpi                  768/(320/160.0)=384.0dp

Galaxy Nexus                                4.65"                    720*1280               xhdpi               720/(320/160.0)=360.0dp

8" Foldable                                    8.03"                    2200*2480               420dpi          2200/(420/160.0)=838.10dp

7.3" Foldable                                   7.3"                    1536*2152               420dpi          1536/(420/160.0)=585.14dp

5.4" FWVGA                                    5.4"                      480*854                   mdpi             480/(160/160.0)=480.0dp

5.1" WVGA                                    5.1"                      480*800                   mdpi               480/(160/160.0)=480.0dp

4.7" WXGA                                    4.7"                      720*1280                   xhdpi            720/(320/160.0)=360.0dp

4.65" 720p (Galaxy Nexus)         4.65"                      720*1280                xhdpi            720/(320/160.0)=360.0dp

4" WVGA (Nexus S)                        4.0"                      480*800                   hdpi             480/(240/160.0)=320.0dp

3.7" WVGA (Nexus One)                3.4"                      480*800                   hdpi            480/(240/160.0)=320.0dp

3.7" FWVGA slider                          3.7"                      480*854                   hdpi            480/(240/160.0)=320.0dp

3.4" WQVGA                                   3.4"                      240*432                   ldpi             240/(120/160.0)=320.0dp

3.3" WQVGA                                   3.3"                      240*400                   ldpi             240/(120/160.0)=320.0dp

3.2" QVGA(ADP2)                           3.2"                      320*480                   mdpi         320/(160/160.0)=320.0dp

3.2" HVGA slider (ADP1)                3.2"                      320*480                   mdpi        320/(160/160.0)=320.0dp

2.7" QVGA slider                            2.7"                      240*320                   ldpi            240/(120/160.0)=320.0dp

2.78" QVGA                                    2.7"                      240*320                   ldpi            240/(120/160.0)=320.0dp



#  Wear OS



Name                                           Play Store   Size                Resolution         Density                 SmallestWidthDp

Android Wear Square                     --              1.65"                280*280              hdpi      280/(240/160.0)=186.67dp

Android Wear Round Chin             --               1.65"               290*320              tvdpi   290/(213/160.0) = 217.84dp

Android Wear Round                      --               1.65"               320*320              hdpi   320/(240/160.0)=213.33dp



# Tablet

Name                                           Play Store     Size                  Resolution         Density                 SmallestWidthDp

Pixel C                                                                9.94"                 2560*1800         xhdpi      1800/(320/160.0)=900dp

Nexus 9                                                              8.86"                2480*1536         xhdpi   1536/(320/160.0)=768.0dp

Nexus 7 (2012)                                                   7.0"                 800*1280            tvdpi  800/(213/160.0)=600.94dp

Nexus 7                                                               7.02"               1200*1920         xhdpi  1200/(320/160.0)=600.0dp

Nexus 10                                                             10.05"             2560*1600         xhdpi  1600/(320/160.0)=800.0dp

7" WSVGA(Tablet)                                               7.0"                 600*1024           mdpi  600/(160/160.0)=600.0dp

10.1" WXGA(Tablet)                                             10.1"              800*1280           mdpi  800/(160/160.0)=800dp



# Automotive

Name                                           Play Store     Size                  Resolution         Density                 SmallestWidthDp

Polestar 2                                                         11.13"                 1152*1536      mdpi 1152/(160/160.0) = 1152.0dp

Automotive (1024p landscape)                   8.4"                      1024*768       mdpi  768/(160/160.0) = 768.0dp











   

