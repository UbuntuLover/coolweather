package com.coolweather.app.activity;

import java.nio.channels.SelectableChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import com.coolweather.app.R;
import com.coolweather.app.model.City;
import com.coolweather.app.model.CoolWeatherDB;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;


import android.app.Activity;
import android.app.DownloadManager.Query;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.renderscript.Mesh.Primitive;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class ChooseAreaActivity extends Activity {
	public static final int LEVEL_PROVINCE = 0;
	public static final int LEVEL_CITY = 1;
	public static final int LEVEL_COUNTY = 2;
	private ProgressDialog progressDialog;
	private TextView titleText;
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private CoolWeatherDB coolWeatherDB;
	private List<String> dataList = new ArrayList<String>();
	/*
	 * 省列表
	 * */
	private List<Province> provinceList;
	/*
	 * 市列表
	 * */
	private List<City> cityList;
	/*
	 * 县列表
	 * */
	private List<County> countyList;
	/*
	 * 选中的省份
	 * */
	private Province selectedProvince;
	/*
	 * 选中的城市
	 * */
	private City selectedCity;
	/*
	 *当前选中的级别 
	 * */
	private int currentLevel;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.choose_area);
		listView = (ListView) findViewById(R.id.list_view);
		titleText = (TextView) findViewById(R.id.title_text);
		adapter = new ArrayAdapter<String>
						(this, android.R.layout.simple_list_item_1,dataList);
		listView.setAdapter(adapter);
		coolWeatherDB = coolWeatherDB.getInstance(this);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void 
			onItemClick(AdapterView<?> arg0, View view, int index, long arg3) {
				// TODO Auto-generated method stub
				if (currentLevel == LEVEL_PROVINCE) {
					selectedProvince = provinceList.get(index);
					queryCities();
				}else if (currentLevel == LEVEL_CITY) {
					selectedCity = cityList.get(index);
					queryCounties();
				}
			}

			
			
		});
		
		queryProvinces();		
	}
	/*
	 * 查询省，从数据库先查，没有再去服务器查
	 * */
	private void queryProvinces(){
		
	}
	/*
	 * 查询选中省内所有的市，同上
	 * */
	private void queryCities() {
		
	}
	/*
	 * 查询选中市所有的县，同上
	 * */
	private void queryCounties() {
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
