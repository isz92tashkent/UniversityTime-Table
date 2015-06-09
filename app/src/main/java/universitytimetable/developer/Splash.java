package universitytimetable.developer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splash extends Activity {

	private Animation animFadein;
	private TextView txtt;
	private TextView txt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);
		
		animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.fade_in);
		
		txt=(TextView)findViewById(R.id.tx);
		txtt=(TextView)findViewById(R.id.txx);
		
		txt.startAnimation(animFadein);
		txtt.startAnimation(animFadein);
		
		Handler handl=new Handler();
		handl.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				Intent intent=new Intent(Splash.this, HomeScreen.class);
				startActivity(intent);
				finish();
				
			}
		}, 3000);
	}

	
}
