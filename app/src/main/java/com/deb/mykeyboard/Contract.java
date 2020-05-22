package com.deb.mykeyboard;

import android.provider.BaseColumns;

public class Contract {
    public Contract() {
    }
    public  static final class NOTEPAD implements BaseColumns{
        public static final String TABLE_NAME = "Notepad";
        public static final String COLUMN_NAME ="name";
        public static final String COLUMN_DATA ="data";
        public static final String COLUMN_TIME ="time";
    }
}
