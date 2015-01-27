package com.example.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.example.test.R;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TestActivity extends Activity {


	MyAsyncHttpClient myAsyncHttpClient;


	Button b1;
	EditText t1,t2,t3;



	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post);
		myAsyncHttpClient = new MyAsyncHttpClient(getApplicationContext());

		b1 = (Button)findViewById(R.id.button1);
		t1 = (EditText)findViewById(R.id.EditText1);
		t2 = (EditText)findViewById(R.id.EditText2);
		t3 = (EditText)findViewById(R.id.EditText3);
	
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String moji1 = t1.getText().toString();
				String moji2 = t2.getText().toString();
				String moji3 = t3.getText().toString();
				myAsyncHttpClient.newRequestParams();

				//aaやbbはweb側と合わせる
				myAsyncHttpClient.setParams("aa",moji1);	//送るファイルを設定
				myAsyncHttpClient.setParams("bb",moji2);	//送るファイルを設定
				myAsyncHttpClient.setParams("cc",moji3);	//送るファイルを設定
				myAsyncHttpClient.access();
			}
		});




	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {


		return true;
	}
}
