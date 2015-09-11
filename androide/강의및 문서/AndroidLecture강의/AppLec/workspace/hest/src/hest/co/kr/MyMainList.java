package hest.co.kr;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MyMainList extends ListActivity {
	TextView itemSelected;
	String[] items = {"MyFrameAni","MyPaintExam", "MyBindingDemo","MyHandlerServiceApp","MyHandlerDemo", "MyCPDemo", "MyProdDBManager", "MyReadBin", "MyResXML", "MyRawXML", "MyXMLPref", "MyBundle","MyActivityCycle", "MyAlarm","MyIntentCaller", "MyIntentExam", "MyTextStyle","MyWebView","MyImageView","MyEditText",
			"MyScrollView", "MySpinner", "MyListView", "MyTab"};
	// abcd --> MySpinner, MyTab
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_main_list);
		itemSelected = (TextView)findViewById(R.id.listItem);
		setListAdapter(
				new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(items[position]);
		startActivity(intent);
//		Intent intent;
//		try {
//			intent = new Intent(this, Class.forName("hest.co.kr." + items[position]));
//			startActivity(intent);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}
}





