package com.example.qrcodedemo;

import com.google.zxing.decoding.GenerateQRCode;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
/**
 * 生成二维码
 * @author Administrator
 *
 */

public class MakeqrcodeMainActivity extends Activity {
	@ViewInject(R.id.editText1)
	private EditText etcontent;
	@ViewInject(R.id.imageView1)
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.makeqrcode_main);
		
		ViewUtils.inject(this);
	}

	@OnClick(R.id.button1)
	public void makeqrcode(View v){
		String content = etcontent.getText().toString();
		//生成二维码(核心),goole官方提供
		Bitmap bitmap = GenerateQRCode.generateQRCode(content);
		//设置生成二维码的图片
		imageView.setImageBitmap(bitmap);
	}
	
}
