package com.example.anujtest.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;

public class UtilFunction {
    private static ProgressDialog progressDialog;
    public static void show(Context context, String messageResourceId) {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            int style;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                style = android.R.style.Theme_Material_Light_Dialog;
            } else {
                style = ProgressDialog.THEME_HOLO_LIGHT;
            }

            progressDialog = new ProgressDialog(context, style);
            progressDialog.setMessage(messageResourceId);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        public static void dismiss(Context context) {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        }
    public static void noInternetConnection(Context context) {
        Toast.makeText(context, "No Internet Cnnection", Toast.LENGTH_SHORT).show();
    }

    }


