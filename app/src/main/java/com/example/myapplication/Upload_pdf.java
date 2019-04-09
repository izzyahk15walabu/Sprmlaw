package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Upload_pdf extends AppCompatActivity {


    private static final int RESULT_LOAD_PDF = 1;
    Button btnSelectpdf;
    RecyclerView rc_uploadpdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_pdf);

        btnSelectpdf=findViewById(R.id.btn_selectuploadedpdf);
        rc_uploadpdf=findViewById(R.id.rc_selectedpdflist);

        btnSelectpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//the below line allows us to choose the  file we wont from the file explorer in android
                Intent intent=new Intent();
                intent.setType("application/pdf");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"select pdfs"),RESULT_LOAD_PDF);
            }
        });
    }
//this methode
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

          if (requestCode == RESULT_LOAD_PDF &&resultCode == RESULT_OK){

              if (data.getClipData()!=null){

                  Toast.makeText(Upload_pdf.this,"multiple file selector",Toast.LENGTH_SHORT).show();

              }
              else if (data.getData()!=null){
                  Toast.makeText(Upload_pdf.this,"single file selector",Toast.LENGTH_SHORT).show();

              }


          }
    }
}
