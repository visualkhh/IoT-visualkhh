package hest.co.kr;

import hest.co.kr.IMyRemoteService.Stub;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

public class MyBindingService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return myBinder;
	}

	private final IMyRemoteService.Stub myBinder = new Stub() {
		public void basicTypes(int anInt, long long1, boolean boolean1,
				float float1, double double1, String string)
				throws RemoteException {
		}

		public String getMyRemoteMsg() throws RemoteException {
			return "okgosu서비스에서 보냈음";
		}

		public String showMyRemoteMsg(String msg) throws RemoteException {
			return "okgosu서비스 Client로부터받은메시지: " + msg;
		}
	};

	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(this, "MyBindingService onCreate", Toast.LENGTH_SHORT)
				.show();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "MyBindingService onDestroy", Toast.LENGTH_SHORT)
				.show();
	}
}
