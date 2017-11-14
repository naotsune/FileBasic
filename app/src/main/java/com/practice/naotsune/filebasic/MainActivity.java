package com.practice.naotsune.filebasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.widget.EditText;
import android.view.View;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    EditText txtMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditTextを取得
        txtMemo = (EditText)findViewById(R.id.txtMemo);
    }

    public void onClick(View view) {
        int aaa = 5;
        int bbb = 10;
        try {
            //memo.datへの書き込みを準備
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            openFileOutput("memo.dat", Context.MODE_PRIVATE)));
            //EditTextへの入力値をファイルに書き込み
            String str = txtMemo.getText().toString();
            writer.write(str);
            //ファイルをクローズ
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
