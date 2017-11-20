package com.example.shaopeng.testproject.util;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/11/20.
 */

public class FormatUtil {
    public static float format2Decimal(float data) {
        DecimalFormat df = new DecimalFormat("0.00");
        return Float.parseFloat(df.format(data));
    }
}
