package br.com.bus;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class MainActivity extends ActionBarActivity {

	AsyncHttpClient client = new AsyncHttpClient();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.import_data:
			this.requestPositions();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void requestPositions() {

		client.get("http://192.168.1.50:9000/positions/307",
				new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String content) {
						Toast.makeText(MainActivity.this, content,
								Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onFailure(Throwable error) {
						Toast.makeText(MainActivity.this, error.toString(),
								Toast.LENGTH_SHORT).show();
					}
				});
	}

}
