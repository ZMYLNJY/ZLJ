package com.develop.cfk;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class MineFragment extends Fragment {
	private View meView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		meView = inflater.inflate(R.layout.tab_mine_layout, container, false);
		return meView;
	}
}
