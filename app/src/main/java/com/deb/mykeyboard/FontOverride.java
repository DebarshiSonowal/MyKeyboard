package com.deb.mykeyboard;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

class FontOverride {

    static void setDefaultFont(Context context,
                               String staticTypefaceFieldName, String fontAssetName) {
        final Typeface regular = Typeface.createFromAsset(context.getAssets(),
                fontAssetName);
        replaceFont(staticTypefaceFieldName, regular);

}

    private static void replaceFont(String staticTypefaceFieldName, Typeface regular) {

        try {
            final Field staticField = Typeface.class
                    .getDeclaredField(staticTypefaceFieldName);
            staticField.setAccessible(true);
            staticField.set(null, regular);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    }

