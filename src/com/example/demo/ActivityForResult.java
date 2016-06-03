package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class ActivityForResult extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button bn  = (Button)findViewById(R.id.bn);
		EditText city = (EditText)findViewById(R.id.city);
		
		bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(ActivityForResult.this, SelectCityActivity.class);
				//启动指定Activity并等待返回的结果，其中0是请求码，用于标识该请求
				startActivityForResult(intent, 0);
			}
		});
	}
	
	//重写该方法，该方法以回调的方式来获取指定Activity返回的结果
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		// TODO Auto-generated method stub
		//super.onActivityResult(requestCode, resultCode, intent);
		
		if (requestCode == 0 && resultCode == 0) //当requestCode、resultCode同时为0时，也就是处理特定的结果
		{
			Bundle data = intent.getExtras(); //取出Intent里的Extras数据
			String resultCity = data.getString("city"); //取出Bundle中的数据
			//city.setText(resultCity); //修改city文本框的内容
	    }

	}
	
}
