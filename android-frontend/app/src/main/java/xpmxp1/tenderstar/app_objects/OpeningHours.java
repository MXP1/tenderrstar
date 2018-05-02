package xpmxp1.tenderstar.app_objects;

import android.util.Log;

/**
 * Created by Rene Hasenburger on 25.04.2018.
 */

public class OpeningHours {

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
            String h = "", m = "";
            if (hour < 10)
                h += "0";
            if (minute < 10)
                m += "0";
            h += hour.toString();
            m += minute.toString();
            return h + ":" + m;
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

    // Members
    private TimeSlot[] timeSlots = new TimeSlot[7];

    private String[] daysWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    // Constructor
    OpeningHours() { }

    public OpeningHours(Time open, Time close, boolean weekend) {
        for (int i = 0; i < (weekend ? 7 : 5); i++) {
            timeSlots[i] = new TimeSlot(open, close);
        }
    }

    public String toString() {
        String out = "";
        for (TimeSlot ts: timeSlots ) {
            if (ts != null)
                out += ts.begin.toString() + " - " + ts.end.toString() + "\n";
        }
        return out;
    }
}
