package com.example.quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;


import com.example.quizapp.databinding.LoginBinding;

import java.util.ArrayList;

public class login_page extends AppCompatActivity  {
 LoginBinding binding;





    RadioGroup gender_group;
    String selected_gender;
   boolean  sure_gender_checked = false;

    AppCompatSpinner country_code;



    boolean sure_agree_check;






    String [] country_code_list = {"Country code ","+880 BD" , "+92 Pak" , "+65 Sing"  };


      ArrayList<String> first_name_array_list = new ArrayList<>();


   {
      first_name_array_list.add("Saiful");
      first_name_array_list.add("apon");
      first_name_array_list.add("asif");
      first_name_array_list.add("safayet");
      first_name_array_list.add("saifi");
      first_name_array_list.add("foysal");
      }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        id fine start














//        id fine end



//        auto complete text start

       ArrayAdapter<String> first_name_array_adapter = new ArrayAdapter<>(
            login_page.this,
           android.R.layout.simple_dropdown_item_1line,
           first_name_array_list

       );


//       first_name.setAdapter(first_name_array_adapter);

//        auto complete text end







//                                                                                                                                          Radio gender button start
       binding.genderGroup.setOnCheckedChangeListener((radioGroup, i) -> {
           RadioButton selected_gender_id = findViewById(i) ;
          selected_gender = selected_gender_id.getText().toString();

           Log.i("saiful_tag", "gender is : " + selected_gender);
          sure_gender_checked = true;
       });


//                                                                                                                                                  Radio gender button end

//                                                                                                                                                 spinner start
        ArrayAdapter<String>  country_code_array_adapter =new ArrayAdapter<>(
               login_page.this ,
                android.R.layout.simple_dropdown_item_1line,
                country_code_list);

        binding.countryCode.setAdapter(country_code_array_adapter);



//        country_code.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//
//                country_code_selected_item =  country_code_list[position];
//
//
//
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }


//        });
//                                                     spinner end



//                                                                                                                            check agree button start

       binding.agreeCheckButtun.setOnCheckedChangeListener((compoundButton, b) -> {
           sure_agree_check =  b;
          Log.i("saiful_tag", "agreement checked : " + b);

       });




//      submit button one click start

        binding.submitButton.setOnClickListener(v -> {



           //       convert string strat



           String birth_Day = binding.birthday.getText().toString();
           String phone_Number = binding.phoneNumberOrEmail.getText().toString();


           String user_zip_Code = binding.userZipCode.getText().toString();
           String Password = binding.password.getText().toString();


//        convert string end


            if (binding.name.getText().toString().equals("")) {
                Log.i("saiful_tag", "No first name ");
              binding.name.setError("Name required ");
              binding.showView.setText("Name required ");
              binding.showView.setError("Fill this requird form");



            } else if (birth_Day.equals("")) {
                Log.i("saiful_tag", "No Birth day  ");
                binding.birthday.setError("Birth day required");
              binding.showView.setText("Birth day required");
              binding.showView.setError("Fill this requird form");

            } else if(!sure_gender_checked){
                Log.i("saiful_tag", "");
              binding.showView.setText("No gender checked  ");
              binding.showView.setError("Fill this requird form");
          

        }else if (binding.countryCode.getText().toString().equals("")){
                Log.i("saiful_tag", "No country code  ");
              binding.showView.setText("No country code  ");
              binding.showView.setError("Fill this requird form");


        }else if (phone_Number.equals("")) {
            Log.i("saiful_tag", "No phone number  ");
            binding.phoneNumberOrEmail.setError("Email or phone.. required ");
              binding.showView.setText("phone number required ");
              binding.showView.setError("Fill this requird form");




        } else if (user_zip_Code.equals("")) {
            Log.i("saiful_tag", "No zip code ");
            binding.userZipCode.setError("Zip code required ");
              binding.showView.setText("Zip code required ");
              binding.showView.setError("Fill this requird form");

        } else if (Password.equals("")) {
            Log.i("saiful_tag", " No password ");
            binding.password.setError("Password required ");
              binding.showView.setText("Password required ");
              binding.showView.setError("Fill this requird form");

        }else if (sure_agree_check ==false) {
               Log.i("saiful_tag", " No agreement checked ");
               binding.agreeCheckButtun.setError(" agreement check required ");
              binding.showView.setText("agreement check required ");
              binding.showView.setError("Fill this requird form");

            } else {


                Toast.makeText(this, "Submit...", Toast.LENGTH_SHORT).show();




      SharedPreferences  shared_preferences = getSharedPreferences("shar", MODE_PRIVATE);

      SharedPreferences.Editor shared_preferences_editor = shared_preferences.edit();
      shared_preferences_editor.putString("name", binding.name.getText().toString());
      shared_preferences_editor.putString("birth_day", binding.birthday.getText().toString());
      shared_preferences_editor.putString("birth_day", selected_gender);
              shared_preferences_editor.putString("birth_day",binding.countryCode.getText().toString());
      shared_preferences_editor.putString("birth_day", binding.phoneNumberOrEmail.getText().toString());
      shared_preferences_editor.putString("birth_day", binding.userZipCode.getText().toString());

      shared_preferences_editor.putString("birth_day", binding.password.getText().toString());
      shared_preferences_editor.putBoolean("sure_login", true);
      shared_preferences_editor.apply();
               startActivity( new Intent(login_page. this ,  class_serial_books.class ));

               finish();





        }



    }  );

           //      submit button one click end



        //       submit button     long click start
        binding.submitButton.setOnLongClickListener(v ->{
            Log.i("saiful_tag", "submit button long click : ");

            binding.showView.setText("sumbit button long click");

            return false;
        });

        //       submit button   long click end
}


}