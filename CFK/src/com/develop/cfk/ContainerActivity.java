package com.develop.cfk;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout.PanelSlideListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;


public class ContainerActivity extends Activity {
	
	private SlidingPaneLayout slidingPane;
	private MenuFragment menuFragment;
	private ContentFragment contentFragment;
	private int maxMargin = 0;
	private DisplayMetrics mMetrics = new DisplayMetrics();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
		setContentView(R.layout.container_activity);
		
		slidingPane = (SlidingPaneLayout) findViewById(R.id.slidingpanellayout);
		menuFragment = new MenuFragment();
		contentFragment = new ContentFragment();
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.replace(R.id.slidingpane_menu, menuFragment);
		transaction.replace(R.id.slidingpane_content, contentFragment);
		transaction.commit();
		
		maxMargin = mMetrics.heightPixels/10;
		slidingPane.setPanelSlideListener(new PanelSlideListener() {
			
			public void onPanelSlide(View view, float slideOffset) {
				int contentMargin = (int) (slideOffset*maxMargin);
				FrameLayout.LayoutParams contentParams = contentFragment.getCurrentParams();
				contentParams.setMargins(0, contentMargin, 0, contentMargin);
				contentFragment.setCurrentParams(contentParams);
				
				float scale = 1 - ((1 - slideOffset) * maxMargin * 2)
						/ (float) mMetrics.heightPixels;
				View currentView = menuFragment.getCurrentView();
				currentView.setScaleX(scale);// 设置缩放的基准点
				currentView.setScaleY(scale);// 设置缩放的基准点
				currentView.setPivotX(0);// 设置缩放和�?择的�?
				currentView.setPivotY(mMetrics.heightPixels / 2);
				currentView.setTranslationX(-100 + slideOffset * 100);
				currentView.setAlpha(slideOffset);
			}
			
			public void onPanelOpened(View arg0) {
				
			}
			
			public void onPanelClosed(View arg0) {
				
			}
		});
	}
	
	public SlidingPaneLayout getSlidingPane(){
		return slidingPane;
	}
}