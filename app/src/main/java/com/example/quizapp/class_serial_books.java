package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.quizapp.databinding.ClassSerialBooksBinding;
import com.example.quizapp.group.ShowPdf;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

public class class_serial_books extends AppCompatActivity {

   private ClassSerialBooksBinding binding;



//   AdView bannerAds;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      binding = ClassSerialBooksBinding.inflate(getLayoutInflater());
      setContentView(binding.getRoot());




      MobileAds.initialize(this, initializationStatus -> {
      });
      AdRequest adrequest = new AdRequest.Builder().build();
      binding.bottomBannerAds.loadAd(adrequest);






      Toolbar toolbar = findViewById(R.id.custom_tool_bar);
      setSupportActionBar(toolbar);

      ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
          class_serial_books.this,
          binding.drawerLayout,
          toolbar,
          R.string.open,
          R.string.close);

      binding.drawerLayout.addDrawerListener(toggle);
      toggle.syncState();



      binding.classInter1stYear.setOnClickListener(view -> {

         Intent intent = new Intent(this, ShowPdf.class);
         startActivity(intent);

      });



      binding.quizSite.setOnClickListener(view ->

          startActivity(new Intent(class_serial_books.this, quiz_question.class)));

      //                                                                                                 drawer menu   start

      binding.drawerMenu.setNavigationItemSelectedListener(item -> {


         switch (item.getItemId()) {
            case R.id.home_drawer_menu:
               Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
               break;

            case R.id.book_drawer_menu:
               Toast.makeText(this, "Books", Toast.LENGTH_SHORT).show();
               break;

            case R.id.exam_quiz_drawer_menu:
               Toast.makeText(this, "Exam Quiz", Toast.LENGTH_SHORT).show();
               startActivity(new Intent(class_serial_books.this, quiz_question.class));
               break;

            case R.id.profile_drawer_menu:
               Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
       break;

            case R.id.setting_drawer_menu:
               Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
       break;

            case R.id.share_drawer_menu:
               Toast.makeText(this, "Share...", Toast.LENGTH_SHORT).show();
       break;

            case R.id.feedback_drawer_menu:
               Toast.makeText(this, "Feedback", Toast.LENGTH_SHORT).show();

         }
         return true;
      });
      //                                                                                                 drawer menu   end


      //                                                                                                 bottom nav menu  ads start

      binding.bottomMenu.setOnNavigationItemSelectedListener(item ->{

         if (item.getItemId()==R.id.home_bottom_menu ){
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();

         }else if (item.getItemId() == R.id.book_bottom_menu){
            Toast.makeText(this, "Books", Toast.LENGTH_SHORT).show();

         }else if (item.getItemId() == R.id.exam_quiz_bottom_menu){
            Toast.makeText(this, "Exam Quiz", Toast.LENGTH_SHORT).show();

         }else if (item.getItemId() == R.id.profile_bottom_menu){
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();

         }else if (item.getItemId() == R.id.setting_bottom_menu){
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
         }
      return true; });


      //                                                                                                 bottom nav menu  ads end









   }   //                                                                        on create method end






   //                                          tool bar  option menu start

   @Override
   public boolean onCreateOptionsMenu(@NonNull Menu menu) {

      MenuInflater menu_inflater = getMenuInflater();
      menu_inflater.inflate(R.menu.top_toolbar_menu, menu);


      return super.onCreateOptionsMenu(menu);
   }

   @Override
   public boolean onOptionsItemSelected(@NonNull MenuItem item) {

     if (item.getItemId() == R.id.light_them_menu_top){
        Toast.makeText(this, "Light themes", Toast.LENGTH_SHORT).show();

     }else if (item.getItemId() == R.id.dark_themes_menu_top){
         Toast.makeText(this, "Dark themes", Toast.LENGTH_SHORT).show();
      }
      return super.onOptionsItemSelected(item);

   }
      //                                                                                                tool bar  option menu end

}//                                                                                                  public class end