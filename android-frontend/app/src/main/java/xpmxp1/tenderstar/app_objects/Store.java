package xpmxp1.tenderstar.app_objects;

import android.util.Log;

import java.util.List;

/**
 * Created by dominik on 21.03.18.
 */

public class Store {
    static public class Time {
        private Integer hour;
        private Integer minute;

        public Time() {
            this.hour = 0;
            this.minute = 0;
        }

        public Time(int hour, int minute) {
            if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60) {
                Log.e("Store.OpeningHours.Time","invalid time " + hour + ":" + minute);
            }

            this.hour = hour;
            this.minute = minute;
        }

        public String toString() {
            return String.format(hour.toString(), "%02d") + ":" + String.format(minute.toString(), "%02d");
        }
    }

    static public class TimeSlot {
        public Time begin;
        public Time end;

        public TimeSlot() {
            this.begin = new Time(8, 0);
            this.end = new Time(16,0);
        }

        public TimeSlot(Time begin, Time end) {
            this.begin = begin;
            this.end = end;
        }
    }

    static public class OpeningHours {
        // Members
        private TimeSlot[] timeSlots = new TimeSlot[7];

        // Constructor
        OpeningHours() { }

        public OpeningHours(Time open, Time close, boolean weekend) {
            for (int i = 0; i < (weekend ? 7 : 5); i++) {
                timeSlots[i] = new TimeSlot(open, close);
            }
        }
    }

    public String name;
    public List<Product> products;
    public OpeningHours openingHours;
    public String link;

    public String address;
    public String postalCode;

    public Store(String name) {
        this.name = name;
    }

    public Store(String name, OpeningHours openingHours, String address, String postalCode) {
        this.name = name;
        this.openingHours = openingHours;
        this.address = address;
        this.postalCode = postalCode;
    }
}
