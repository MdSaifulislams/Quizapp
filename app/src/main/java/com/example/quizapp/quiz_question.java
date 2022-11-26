package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.quizapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class quiz_question extends AppCompatActivity {



   ActivityMainBinding  binding ;

 List<question> question_list;

 int score = 0;


  int right_answer = 0;
  int wrong_answer = 0;

 String selected_answer;
 int current_index =0;
 int  question_list_size;
boolean sure_checked = false;
int one_question_time_milliis_sec = 10000;
int total_question_time_milliis_sec;


int total_question_time_sec;
;

   CountDownTimer count_down_timer;

String name = "saiful";


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      binding = ActivityMainBinding.inflate( getLayoutInflater ());
      setContentView(binding.getRoot());

      MobileAds.initialize(this, initializationStatus -> {
      });
     AdRequest adrequest = new AdRequest.Builder().build();
     binding.bottomBannerAds.loadAd(adrequest);

//      getSupportActionBar().setDisplayHomeAsUpEnabled(true);



   question_list = new ArrayList<>();
//                                                                                                       question start
question question1  =new question("What is the capital of Bangladesh  ?", "Islamabad ", "Istanbul", "Riyad", "Dhaka", "Dhaka");
question_list.add(question1);

question_list.add(new question ("What is the name of this app owner  ? ", "Asif", "Apon ", "Saiful", "Saife", "Saiful"));

question_list.add(new question( "What is the country code of pakistan  ?" , "+880", "+92", "+65", "+23", "+92"));

question_list.add(new question( "What is my future hobby  ?" , "Job", "Software Engineer", "unemployed", "politics", "Software Engineer"));

question_list.add(new question( "What is language need Software to do development  ?" , "Javascript", "HTML", "Java", "Css", "Java"));

question_list_size= question_list.size();
//                                                                                                       question end

//                                                                                                      set up question start

      set_up_question_and_answer( current_index);

     total_question_time_milliis_sec = question_list_size*one_question_time_milliis_sec;
     total_question_time_sec = total_question_time_milliis_sec/1000;

     start_time();






//                                                                                                        set up question end


//                                                                                                        shared preferences number start

      SharedPreferences shared_preferences = getSharedPreferences("saiful_shared", MODE_PRIVATE);
      SharedPreferences.Editor editor_shared = shared_preferences.edit();

      editor_shared.putString("name_key", name);
      editor_shared.apply();

      //                                                                                                        shared preferences number start

   SharedPreferences hared_preferences =   getSharedPreferences("saiful_shared",MODE_PRIVATE);
String  name =   hared_preferences.getString("name_key","NO name ");

//                                                                                                        set up question number start
      binding.questionNumber.setText( "NO : "+current_index+"/"+ question_list_size);

      binding.resultShow.setText(right_answer+"-" + wrong_answer  + "=" + (right_answer - wrong_answer));


//                                                                                                 set up question number end




binding.answerOption.setOnCheckedChangeListener((radioGroup, i) -> {

   RadioButton  selected_answer_id = findViewById(i);

   selected_answer = selected_answer_id.getText().toString();
   sure_checked = true;

 binding.subimtButton.setBackgroundResource(R.drawable.button_background_check);



});


binding.seePreviewQuiz.setOnClickListener(view -> {

   Toast.makeText(quiz_question.this, "Exit", Toast.LENGTH_SHORT).show();

});



      binding.subimtButton.setOnClickListener(view -> {


         if (sure_checked == true ){
            check_right_answer();
//            count_down_timer.cancel();




      }else{
            Toast.makeText(this, "Check any one", Toast.LENGTH_SHORT).show();

         }
   } );


   } //                                                                                                                                                   on create end





    //                                                                                                                                                  private method start

   private void set_up_question_and_answer(int current_index) {

//      new Handler().postDelayed(() -> {
      if (question_list.size()>current_index){

         binding.answer1.setChecked(false);
         binding.answer2.setChecked(false);
         binding.answer3.setChecked(false);
         binding.answer4.setChecked(false);

         binding.quizQuestionShow.setText(  question_list.get(current_index).getQuestion());
         binding.answer1.setText(question_list.get(current_index).getAnswer_1());
         binding.answer2.setText(question_list.get(current_index).getAnswer_2());
         binding.answer3.setText(question_list.get(current_index).getAnswer_3());
         binding.answer4.setText(question_list.get(current_index).getAnswer_4());


         timer();
      }else {
         Toast.makeText(this, "Thanks successfully completed", Toast.LENGTH_SHORT).show();
        answer_button_disable();

      }
//      } ,   1000 );
   }




   private void check_right_answer() {


         if ( selected_answer.equals(question_list.get(current_index).getRight_answer())){

            score +=10;
            current_index++;
            right_answer++;
            binding.scoreView.setText("Score is : " +score  );
            binding.resultShow.setText(right_answer+"-" + wrong_answer  + "=" + (right_answer - wrong_answer));
            binding.questionNumber.setText( "NO : "+current_index  +"/"+ question_list_size);
            binding.scoreView.setTextColor(Color.parseColor("#FF03DAC5"));
            set_up_question_and_answer(current_index);
         }else {
            score -= 5;
            current_index++;
            wrong_answer++;

            binding.scoreView.setText("Score is : " +score);

            binding.questionNumber.setText( "NO : "+current_index +"/"+ question_list_size);
            binding.resultShow.setText(right_answer+"-" + wrong_answer  + "=" + (right_answer - wrong_answer));

            binding.scoreView.setTextColor(Color.parseColor("#FF0000"));

            set_up_question_and_answer(current_index);

            Toast.makeText(quiz_question.this, "Wrong answer ", Toast.LENGTH_SHORT).show();
//                  binding.answer1.setButtonTintList(ContextCompat.getColorStateList(mContext, R.color.colorGris));

         }


   }




   private void start_time() {
   count_down_timer = new CountDownTimer(total_question_time_milliis_sec, 1000){
         @Override
         public void onTick(long l) {
            binding.timeShow.setText("Time : " + total_question_time_sec );
            total_question_time_sec --;
         }

         @Override
         public void onFinish() {
            total_question_time_sec = 0;
            binding.timeShow.setTextColor(Color.RED);
            binding.timeShow.setText("Time : " + total_question_time_sec);
            binding.timeShow.setTextSize(15);
            answer_button_disable();


         }



      }.start();
   }


   public void timer(){
      TimerTask time_count = new TimerTask() {
         @Override
         public void run() {

         }
      };

   }



   private void answer_button_disable() {
      binding.answer1.setEnabled(false);
      binding.answer2.setEnabled(false);
      binding.answer3.setEnabled(false);
      binding.answer4.setEnabled(false);


   }











}