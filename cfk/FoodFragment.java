package com.develop.cfk;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class FoodFragment extends Fragment {
	private View fdView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		fdView = inflater.inflate(R.layout.tab_food_layout, container, false);
		return fdView;
	}
}
