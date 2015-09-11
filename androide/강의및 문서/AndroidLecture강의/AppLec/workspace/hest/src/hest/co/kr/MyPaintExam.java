package hest.co.kr;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MyPaintExam extends Activity {
	private FrameLayout root;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_graph_exam);
		root = (FrameLayout)findViewById(R.id.root);
		root.addView(new MyView(this));		
	}
	
	class MyView extends View {

		public MyView(Context context) {
			super(context);
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
			paint.setColor(Color.GREEN);
			paint.setStrokeWidth(10);
			canvas.drawLine(0, 0, 300, 300, paint);
			paint.setColor(Color.YELLOW);
			//paint.setStrokeWidth(5);
			//paint.setStyle(Paint.Style.STROKE);
			int[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.RED};
			SweepGradient sg 
			= new SweepGradient(canvas.getWidth()/2, canvas.getHeight()/2, colors, null);
			paint.setShader(sg);
			canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, 
					canvas.getWidth()/2, paint);
		}
	}
}







