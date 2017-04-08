package com.develop.cfk;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment implements View.OnClickListener {

	private View currentView;
	private Button vip, wallet, style, favorite, album, file;

	public View getCurrentView() {
		return currentView;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		currentView = inflater.inflate(R.layout.slidingpane_menu_layout,
				container, false);
		vip = (Button) currentView.findViewById(R.id.bt_vip);
		wallet = (Button) currentView.findViewById(R.id.bt_wallet);
		style = (Button) currentView.findViewById(R.id.bt_style);
		favorite = (Button) currentView.findViewById(R.id.bt_favorite);
		album = (Button) currentView.findViewById(R.id.bt_album);
		file = (Button) currentView.findViewById(R.id.bt_file);

		vip.setOnClickListener(this);
		wallet.setOnClickListener(this);
		style.setOnClickListener(this);
		favorite.setOnClickListener(this);
		album.setOnClickListener(this);
		file.setOnClickListener(this);

		return currentView;
	}

	public void onClick(View v) {
		((ContainerActivity) getActivity()).getSlidingPane().closePane();
	}
}
