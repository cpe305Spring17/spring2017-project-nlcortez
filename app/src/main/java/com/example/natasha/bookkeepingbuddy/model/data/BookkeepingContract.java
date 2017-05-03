package com.example.natasha.bookkeepingbuddy.model.data;

import android.provider.BaseColumns;

/**
 * Created by Natasha on 4/21/2017.
 */

public final class BookkeepingContract {
    private BookkeepingContract() {}

    public static final class CategoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "categories";
        public static final String COLUMN_CATEGORY_NAME = "name";
        public static final String COLUMN_UNIT = "unit";

        private CategoryEntry() {}
    }
}
