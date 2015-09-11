package hest.co.kr;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MyFrameAni extends Activity {
	AnimationDrawable mframeAnimation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_frame_ani);
		final Button onButton = (Button) findViewById(R.id.ButtonStart);
		final Button offButton = (Button) findViewById(R.id.ButtonStop);
		onButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startAnimation();
			}
		});
		offButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				stopAnimation();
			}
		});
	}
	private void stopAnimation() {
		mframeAnimation.stop();
		mframeAnimation.setVisible(false, false);
	}
	private void startAnimation() {
		ImageView img = (ImageView)findViewById(R.id.ImageView_Juggle);
		BitmapDrawable frame0 = (BitmapDrawable)getResources().getDrawable(R.drawable.zzangu0);
		BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.zzangu1);
		BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.zzangu2);
		BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.zzangu3);
		BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.zzangu4);
		BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.zzangu5);
		BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.zzangu6);
		BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.zzangu7);
		BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.zzangu8);
		mframeAnimation = new AnimationDrawable();
		mframeAnimation.setOneShot(false);// ���� �ݺ�
		int reasonableDuration = 250;
		mframeAnimation.addFrame(frame0, reasonableDuration);
		mframeAnimation.addFrame(frame1, reasonableDuration);
		mframeAnimation.addFrame(frame2, reasonableDuration);
		mframeAnimation.addFrame(frame3, reasonableDuration);
		mframeAnimation.addFrame(frame4, reasonableDuration);
		mframeAnimation.addFrame(frame5, reasonableDuration);
		mframeAnimation.addFrame(frame6, reasonableDuration);
		mframeAnimation.addFrame(frame7, reasonableDuration);
		mframeAnimation.addFrame(frame8, reasonableDuration);		

		img.setBackgroundDrawable(mframeAnimation);
		mframeAnimation.setVisible(true,false);
		mframeAnimation.start();		
	}
}








