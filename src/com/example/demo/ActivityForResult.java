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
				//����ָ��Activity���ȴ����صĽ��������0�������룬���ڱ�ʶ������
				startActivityForResult(intent, 0);
			}
		});
	}
	
	//��д�÷������÷����Իص��ķ�ʽ����ȡָ��Activity���صĽ��
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		// TODO Auto-generated method stub
		//super.onActivityResult(requestCode, resultCode, intent);
		
		if (requestCode == 0 && resultCode == 0) //��requestCode��resultCodeͬʱΪ0ʱ��Ҳ���Ǵ����ض��Ľ��
		{
			Bundle data = intent.getExtras(); //ȡ��Intent���Extras����
			String resultCity = data.getString("city"); //ȡ��Bundle�е�����
			//city.setText(resultCity); //�޸�city�ı��������
	    }

	}
	
}
