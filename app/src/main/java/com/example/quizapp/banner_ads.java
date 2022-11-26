package com.example.quizapp;

import android.content.Context;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class banner_ads {


      public static void loadAds(LinearLayout container, Context context) {
         MobileAds.initialize(context, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
         });
         AdView adView = new AdView(context);
         adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
         container.addView(adView);
         AdRequest adRequest = new AdRequest.Builder().build();
         adView.setAdSize(AdSize.BANNER);
         adView.loadAd(adRequest);
      }

}
