package com.example.demo;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SelectCityActivity extends ExpandableListActivity {
	
	//定义省份数组
	private String[] provices = new String[] {"广东", "广西", "湖南"};
	private String[][] cities = new String[][] 
	{
			{"广州", "深圳", "珠海", "中山"},
			{"桂林", "柳州", "南宁", "北海"},
			{"长沙", "岳阳", "衡阳", "株洲"}
	};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
        	
        	//获取指定位置、指定子列表项处的子列表项数据
			@Override
			public Object getChild(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return cities[groupPosition][childPosition];
			}
			
			@Override
			public long getChildId(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return childPosition;
			}
			
			@Override
			public int getChildrenCount(int groupPosition) {
				// TODO Auto-generated method stub
				return cities[groupPosition].length;
			}
			
			private TextView getTextView() 
			{
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 64);
				TextView textView = new TextView(SelectCityActivity.this);
				textView.setLayoutParams(lp);
				textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
				textView.setPadding(36, 0, 0, 0);
				textView.setTextSize(20);
				return textView;
			}
			
			//该方法决定每个子选项的外观
			@Override
			public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View converView,
					ViewGroup parent) {
				// TODO Auto-generated method stub
				TextView textView = getTextView();
				textView.setText(getChild(groupPosition, childPosition).toString());
				return textView;
			}
			
			@Override
			public Object getGroup(int groupPosition) {
				// TODO Auto-generated method stub
				return provices[groupPosition];
			}
			
			@Override
			public int getGroupCount() {
				// TODO Auto-generated method stub
				return provices.length;
			}
			
			@Override
			public long getGroupId(int groupPosition) {
				// TODO Auto-generated method stub
				return groupPosition;
			}
			
			//该方法决定每个组选项的外观
			@Override
			public View getGroupView(int groupPosition, boolean isExpanded, View converView, ViewGroup parent) {
				// TODO Auto-generated method stub
				LinearLayout ll = new LinearLayout(SelectCityActivity.this);
				ll.setOrientation(0);
				ImageView logo = new ImageView(SelectCityActivity.this);
				ll.addView(logo);
				TextView textView = getTextView();
				textView.setText(getGroup(groupPosition).toString());
				ll.addView(textView);
				return ll;
			}
			
			@Override
			public boolean isChildSelectable(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean hasStableIds() {
				// TODO Auto-generated method stub
				return true;
			}
		};
		
		//设置该窗口显示列表
		setListAdapter(adapter);
		getExpandableListView().setOnChildClickListener(new OnChildClickListener(){

			@Override
			public boolean onChildClick(ExpandableListView parent, View source,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				//获取启动该Activity之前的Activity对应的Intent
				Intent intent = getIntent();
				Bundle data = new Bundle();
				data.putString("city", cities[groupPosition][childPosition]);
				intent.putExtras(data);
				//设置该SelectCityActivity的结果码，并设置结束之后退回的Activity
				SelectCityActivity.this.setResult(0, intent);
				SelectCityActivity.this.finish(); //结束SelectCityActivity
				return false;
			}});
	
    }

}
