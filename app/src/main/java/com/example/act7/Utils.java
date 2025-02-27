//package com.example.act7;
//
//import android.app.Activity;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.Spinner;
//
//public class Utils {
//
//        private Spinner spinner ;
//        private Activity activity;
//
//
//            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//        @Override
//        public void onItemSelected(AdapterView<?> activity, View selectedItemView, int position, long id) {
//            if (spinner.getSelectedItemPosition() == 2 || binding.studentsSpinner.getSelectedItemPosition() == 3){
//
//                binding.faseEditText.setText("Entered the if statement");
//                Log.d("Debug", "entered the if Statement: ");
//
//            } else {
//
//                binding.faseEditText.setText("Programacion");
//
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> parentView) {
//            binding.faseEditText.setText("Nun selected");
//        }
//
//    });
//}
