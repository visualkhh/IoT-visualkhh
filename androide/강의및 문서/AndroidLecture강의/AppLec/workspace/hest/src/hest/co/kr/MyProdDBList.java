package hest.co.kr;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyProdDBList extends ListActivity {
	private MyProdDBHelper openHelper;
	private SQLiteDatabase sdb;
	private SimpleCursorAdapter myAdapter;
	private String searchCode = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Intent parameter 가져오기
		Intent i = getIntent();
		searchCode = i.getStringExtra("searchCode");
		if (searchCode == null)
			searchCode = "";
	}

	@Override
	protected void onResume() {
		super.onResume();
		// DB 연결 준비
		openHelper = new MyProdDBHelper(this, MyProdDBCons.DB_NAME, null,
				MyProdDBCons.DB_VERSION);
		sdb = openHelper.getReadableDatabase();
		// 반환할 컬럼 항목, _id 컬럼 정의
		String columns[] = { MyProdDBCons._ID, MyProdDBCons.PROD_CODE,
				MyProdDBCons.PROD_NAME };
		String order_by = MyProdDBCons.PROD_NAME;
		String qWhere = MyProdDBCons.PROD_CODE + " like ? or "
				+ MyProdDBCons.PROD_NAME + " like ?";
		String qLike = "%" + searchCode + "%";
		// 커서 생성
		Cursor c = sdb.query(MyProdDBCons.TABLE_NAME, columns, qWhere,
				new String[] { qLike, qLike }, null, null, order_by, null);
		startManagingCursor(c);
		
		int cnt = c.getCount();
		if(cnt==0) {
			Toast.makeText(this, "데이터가 없습니다.", 2000).show();
			finish();
		} else {
			// SimpleCursorAdapter 연결
			String[] FROM = new String[] { MyProdDBCons.PROD_CODE,
					MyProdDBCons.PROD_NAME };
			int[] TO = new int[] { R.id.my_prod_code, R.id.my_prod_name };
			
			//myAdapter = new SimpleCursorAdapter(this, R.layout.my_prod_db_col, c,
			//		FROM, TO);
			//setListAdapter(myAdapter);
			setListAdapter(new MyAdapter(this, R.layout.my_prod_db_col2, c, FROM, TO));
		}
		sdb.close();		
	}

	class MyAdapter extends SimpleCursorAdapter {
		int layout;
		Cursor c;
		public MyAdapter(Context context, int layout, Cursor c, String[] from,
				int[] to) {
			super(context, layout, c, from, to);
			this.c = c;
			this.layout = layout;
		}
		
		int i = R.drawable.snk01;
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			c.moveToNext();
			View row = getLayoutInflater().inflate(layout, null);
			TextView label1 = (TextView)row.findViewById(R.id.my_prod_code);
			TextView label2 = (TextView)row.findViewById(R.id.my_prod_name);
			ImageView img = (ImageView)row.findViewById(R.id.my_prod_img);
			label1.setText(c.getString(1));
			label2.setText(c.getString(2));
			img.setImageResource(i++);
			return row;
		}
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		TextView my_prod_code = (TextView) v.findViewById(R.id.my_prod_code);
		TextView my_prod_name = (TextView) v.findViewById(R.id.my_prod_name);
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.putExtra(MyProdDBCons.PROD_CODE, my_prod_code.getText());
		intent.putExtra(MyProdDBCons.PROD_NAME, my_prod_name.getText());
		intent.setType(MyProdDBCons.CONTENT_TYPE);
		startActivity(intent);
	}
}
