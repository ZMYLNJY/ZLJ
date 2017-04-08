package com.develop.cfk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;


@SuppressLint("NewApi")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ContentFragment extends Fragment implements OnClickListener {

	private View currentView;
	private ImageView tabConversation, tabContact, tabPlugin;
	// 设置默认的tab
	private int index = 1;
	// fragment管理器
	private FragmentManager fragmentManager;
	// 声明fragment
	private ClothesFragment csFragment;//衣服&天气
	private FoodFragment fdFragment;//食物
	private MineFragment meFragment;//我的

	public void setCurrentParams(FrameLayout.LayoutParams layoutParams) {
		currentView.setLayoutParams(layoutParams);
	}

	public FrameLayout.LayoutParams getCurrentParams() {
		return (LayoutParams) currentView.getLayoutParams();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		currentView = inflater.inflate(R.layout.slidingpane_content_layout,
				container, false);
		
		fragmentManager = getFragmentManager();
		init();
		return currentView;
	}
	
	/**
	 * 初始化
	 */
	private void init() {
		tabConversation = (ImageView) currentView.findViewById(R.id.tab_conversation);
		tabContact = (ImageView) currentView.findViewById(R.id.tab_contact);
		tabPlugin = (ImageView) currentView.findViewById(R.id.tab_plugin);
		tabConversation.setOnClickListener(this);
		tabContact.setOnClickListener(this);
		tabPlugin.setOnClickListener(this);
		
		tabConversation.setBackgroundResource(R.drawable.tab_conversation_selected);
		tabContact.setBackgroundResource(R.drawable.tab_contact_normal);
		tabPlugin.setBackgroundResource(R.drawable.tab_plugin_normal);
		//
		setDefaultFragment();
	}
	
	/**
	 * 设置默认的fragment
	 */
	@SuppressLint("NewApi")
	private void setDefaultFragment() {
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		csFragment = new ClothesFragment();
		transaction.replace(R.id.content_layout, csFragment);
		transaction.commit();
	}
	
	/**
	 *更改fragment
	 * @param newFragment
	 */
	@SuppressLint("NewApi")
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void replaceFragment(Fragment newFragment) {
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		if (!newFragment.isAdded()) {
			transaction.replace(R.id.content_layout, newFragment);
			transaction.commit();
		} else {
			transaction.show(newFragment);
		}
	}

	/**
	 * 改变fragment状态
	 */
	private void clearStatus() {
		if (index == 1) {
			tabConversation.setBackgroundResource(R.drawable.tab_conversation_normal);
		} else if (index == 2) {
			tabContact.setBackgroundResource(R.drawable.tab_contact_normal);
		} else if (index == 3) {
			tabPlugin.setBackgroundResource(R.drawable.tab_plugin_normal);
		}
	}
	
	public void onClick(View v) {
		clearStatus();
		switch (v.getId()) {
		case R.id.tab_conversation:
			if (csFragment == null) {
				csFragment = new ClothesFragment();
			}
			replaceFragment(csFragment);
			tabConversation.setBackgroundResource(R.drawable.tab_conversation_selected);
			index = 1;
			break;
		case R.id.tab_contact:
			if (fdFragment == null) {
				fdFragment = new FoodFragment();
			}
			replaceFragment(fdFragment);
			tabContact.setBackgroundResource(R.drawable.tab_contact_selected);
			index = 2;
			break;
		case R.id.tab_plugin:
			if (meFragment == null) {
				meFragment = new MineFragment();
			}
			replaceFragment(meFragment);
			tabPlugin.setBackgroundResource(R.drawable.tab_plugin_selected);
			index = 3;
			break;
		}
	}
}
