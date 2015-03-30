package com.momo.myfuncation;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.momo.myfuncation.adapter.BaseAdapterHelper;
import com.momo.myfuncation.adapter.QuickAdapter;

public class MainActivity extends Activity {

	private QuickAdapter<String>	adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView list = (ListView) this.findViewById(R.id.list);
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			l.add("http://h.hiphotos.baidu.com/image/pic/item/ac345982b2b7d0a24b021693c9ef76094a369af0.jpg");
			l.add("http://a.hiphotos.baidu.com/image/pic/item/728da9773912b31ba8d2172b8418367adab4e172.jpg");
			l.add("http://d.hiphotos.baidu.com/image/pic/item/08f790529822720ea71345fb79cb0a46f31fabd6.jpg");
			l.add("http://a.hiphotos.baidu.com/image/pic/item/b2de9c82d158ccbfcc4a860b1ad8bc3eb1354108.jpg");
			l.add("http://h.hiphotos.baidu.com/image/pic/item/9345d688d43f879463257b1fd11b0ef41bd53a2c.jpg");
			l.add("http://f.hiphotos.baidu.com/image/pic/item/91ef76c6a7efce1b080a0bc3ad51f3deb48f6592.jpg");
			l.add("http://c.hiphotos.baidu.com/image/pic/item/3812b31bb051f81914574149d8b44aed2e73e747.jpg");
			l.add("http://b.hiphotos.baidu.com/image/pic/item/3bf33a87e950352ae7582c155143fbf2b2118bf5.jpg");
		}
		if (adapter == null) {
			adapter = new QuickAdapter<String>(this, R.layout.item, l) {
				@Override
				protected void convert(BaseAdapterHelper helper, String url) {
					helper.setImageUrl(R.id.item_iv, url);
					helper.setText(R.id.item_tv, url);
				}
			};
		}
		list.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
