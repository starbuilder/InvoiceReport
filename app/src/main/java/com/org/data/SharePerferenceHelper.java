package com.org.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 偏好設定
 * @author andy.Li
 */ 
public class SharePerferenceHelper{

	static SharedPreferences mSharedPreferences;
	static SharePerferenceHelper msharePerferenceHelper;

	SharePerferenceHelper(Context mContext){
		if(mSharedPreferences==null)
			mSharedPreferences=mContext.getSharedPreferences("ebook", Context.MODE_PRIVATE);  
	}
	public static SharePerferenceHelper getIntent(Context mContext){
		if(mSharedPreferences==null)
			msharePerferenceHelper=new SharePerferenceHelper(mContext);
		return msharePerferenceHelper;
	}
	@SuppressLint("CommitPrefEdits")
	public void clear(){
		Editor mEditor=getEditor();
		if(mEditor!=null){
			mEditor.clear();
			mEditor.commit();
		}
	}
	public  Editor getEditor(){
		if(mSharedPreferences!=null)
			return mSharedPreferences.edit();
		return null;
	}
	public  String getString(String key,String def){
		if(mSharedPreferences!=null)
			return mSharedPreferences.getString(key, def);
		return def;
	}
	public  boolean setString(String key,String value){
		Editor mEditor=getEditor();
		if(mEditor!=null){
			mEditor.putString(key, value);
			mEditor.commit();
			return true;
		}
		return false;
	}
	public  int getInt(String key,int def){
		if(mSharedPreferences!=null)
			return mSharedPreferences.getInt(key, def);
		return def;
	}
	public  boolean setInt(String key,int value){
		Editor mEditor=getEditor();
		if(mEditor!=null){
			mEditor.putInt(key, value);
			mEditor.commit();
			return true;
		}
		return false;
	}
	public  boolean getboolean(String key,boolean def){
		if(mSharedPreferences!=null)
			return mSharedPreferences.getBoolean(key, def);
		return def;
	}
	public  boolean setboolean(String key,boolean value){
		Editor mEditor=getEditor();
		if(mEditor!=null){
			mEditor.putBoolean(key, value);
			mEditor.commit();
			return true;
		}
		return false;
	}

}
