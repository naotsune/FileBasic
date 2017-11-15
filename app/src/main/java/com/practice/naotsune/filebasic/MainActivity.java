package com.practice.naotsune.filebasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

import android.widget.EditText;
import android.view.View;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    EditText txtMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //読込んだデータを取得するための器を準備
        StringBuffer str = new StringBuffer();
        try {
            //memo.datを開く
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            openFileInput("memo.dat")));
            //memo.datから行単位に読込、その内容をStringBufferに保存
            while (reader.ready()) {
                if(0 != str.length()) {
                    str.append("\n");
                }
                str.append(reader.readLine());
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        //EditTextを取得
        txtMemo = (EditText)findViewById(R.id.txtMemo);
        //StringBufferの内容をテキストエリアに反映
        txtMemo.setText(str.toString());
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
