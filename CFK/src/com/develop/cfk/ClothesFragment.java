package com.develop.cfk;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class ClothesFragment extends Fragment {
	private View csView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		csView = inflater.inflate(R.layout.tab_clothes_layout, container, false);
		return csView;
	}
}
