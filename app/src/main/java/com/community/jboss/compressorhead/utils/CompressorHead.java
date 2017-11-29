package com.community.jboss.compressorhead.utils;

import android.net.Uri;
import android.support.annotation.NonNull;

/**
 * Created by murad on 23/11/17.
 */

public class CompressorHead {

    public static final String PNG = "png";
    public static final String JPEG = "jpeg";
    public static final String WEBP = "webp";

    public static String getURL(@NonNull String imageURl, int width, int height, String format) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority(Constants.BASE_URL)
                .appendPath("image")
                .appendQueryParameter("image_url", imageURl)
                .appendQueryParameter("width", String.valueOf(width))
                .appendQueryParameter("height", String.valueOf(height))
                .appendQueryParameter("format", format);
        return builder.build().toString();
    }
}
