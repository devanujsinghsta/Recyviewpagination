package com.example.anujtest.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class ConnectionDetector {
    public static boolean isNetworkAvailable(Context _context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) _context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
}
