package com.eworkbandung.nowdb.example.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Seta on 9/3/16.
 */
public class Util {
    public static String longToDate(long val){
        Date date=new Date(val);
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
        return df2.format(date);
    }

    public static long getTimeNow(){
        return System.currentTimeMillis();
    }
}
