package com.example.qrcodedemo;

import com.google.zxing.MipcaActivityCapture;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
/**
 * 二维码
 * @author Administrator
 *
 */

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ViewUtils.inject(this);
	}
	//生成二维码
	@OnClick(R.id.button1)
	public void button1(View v){
		Intent intent = new Intent(MainActivity.this,MakeqrcodeMainActivity.class);
		startActivity(intent);
	}
	//扫一扫
	@OnClick(R.id.button2)
	public void button2(View v){
		//点击按钮,打开摄像头扫描
		Intent intent = new Intent();
		intent.setClass(MainActivity.this,MipcaActivityCapture.class);
		//将需要启动的Activity添加到当前的任务中
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivityForResult(intent, 0);
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if(resultCode == RESULT_OK){
			if(requestCode == 0){
				String result = data.getExtras().getString("result");
				
				if(TextUtils.isEmpty(result)){
					Toast.makeText(MainActivity.this,"没有扫描到结果",Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
				}
			}
		}
		
	}

	
}
