package xpmxp1.tenderstar.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

import xpmxp1.tenderstar.app_objects.OpeningHours;

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

    @TypeConverter
    public static OpeningHours opneningHoursFromString(String openingHours) {
        return new OpeningHours(new OpeningHours.Time(), new OpeningHours.Time(), false);
    }

    @TypeConverter
    public static String stringFromOpeningHours(OpeningHours openingHours) {
        return openingHours.toString();
    }

}
