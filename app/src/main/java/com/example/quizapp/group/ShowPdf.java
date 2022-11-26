package com.example.quizapp.group;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.quizapp.databinding.ShowPdfBinding;

public class ShowPdf extends AppCompatActivity {

 ShowPdfBinding binding;

@Override
protected void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 binding = ShowPdfBinding.inflate(getLayoutInflater());
	 setContentView(binding.getRoot());



	 binding.pdfView.fromAsset("inter_1s_y_Bangla1s.pdf").load();


}
}