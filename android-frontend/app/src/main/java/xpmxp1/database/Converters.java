package xpmxp1.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Rene Hasenburger on 18.04.2018.
 */

public class Converters {

    @TypeConverter
    public static Date dateFromTimestamp(Long val) {
        return val == null ? null : new Date(val);
    }

    @TypeConverter
    public static Long timestampFromDate(Date date) {
        return date == null ? null : date.getTime();
    }

}
