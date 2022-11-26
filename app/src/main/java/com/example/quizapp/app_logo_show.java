package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;

import com.example.quizapp.databinding.ActivityMainBinding;
import com.example.quizapp.databinding.AppLogoShowBinding;

public class app_logo_show extends AppCompatActivity {

   AppLogoShowBinding binding ;
   private int show_time = 1500;
   boolean sure_login;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      binding = AppLogoShowBinding.inflate(getLayoutInflater());
      setContentView(binding.getRoot());


      SharedPreferences shared_preferences =  getSharedPreferences("shar" , MODE_PRIVATE);
     sure_login = shared_preferences.getBoolean("sure_login",false);


   new  CountDownTimer(show_time, 100){
      @Override
      public void onTick(long l) {


      }

      @Override
      public void onFinish() {
         if (sure_login) {
            startActivity(new Intent(app_logo_show.this, class_serial_books.class));
            finish();
         }else {
         startActivity(new Intent(app_logo_show.this,login_page.class));
         finish();
         }
      }
   }.start();








   }

}