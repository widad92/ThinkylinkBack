package com.omni.rest.utils;

import java.text.Format;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Tools {
    public final String dateToString() { 
        Date date = new Date() ; 
        Format formatter = new SimpleDateFormat("MM-dd-yyyy");
        return formatter.format(date);
    }

}
