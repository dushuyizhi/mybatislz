package com.utils;


import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class OffSetDateTimeConverter {
    public static final String YYYYDDMMHHSSMM = "yyyyMMddHHmmss";
    public static final String YYYYDDMM_HH_SS_MM = "yyyyMMdd HH:mm:ss";

    /**
     * "yyyyMMdd HH:mm:ss"
     *
     * @param dateTime
     * @return
     */
    public static OffsetDateTime convertDateTime(String dateTime, String pattern) {
        if (StringUtils.isBlank(dateTime)) {
            return null;
        }

        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(pattern));
        return OffsetDateTime.of(localDateTime, ZoneId.systemDefault().getRules().getOffset(localDateTime));
    }


    public static String parseDate(OffsetDateTime offsetDateTime, String pattern){
        return  offsetDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }
}
