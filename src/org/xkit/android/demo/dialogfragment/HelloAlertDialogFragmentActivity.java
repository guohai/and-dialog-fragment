package org.xkit.android.demo.dialogfragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HelloAlertDialogFragmentActivity extends Activity {

	private final static String LOG_TAG = HelloAlertDialogFragmentActivity.class
			.getName();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_dialog);
		View tv = findViewById(R.id.text);
		((TextView) tv).setText("Android DialogFragment Samples");
		Button button = (Button) findViewById(R.id.show);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog();
			}
		});
	}

	public void doPositiveClick() {
		Log.i(LOG_TAG, "Positive Button Clicked");
	}

	public void doNegativeClick() {
		Log.i(LOG_TAG, "Negative Button Clicked");
	}

	void showDialog() {
		DialogFragment newFragment = MyAlertDialogFragment
				.newInstance(R.string.alert_dialog_two_buttons_title);
		newFragment.show(getFragmentManager(), "alert_dialog");
	}

	public static class MyAlertDialogFragment extends DialogFragment {
		public static MyAlertDialogFragment newInstance(int title) {
			MyAlertDialogFragment frag = new MyAlertDialogFragment();
			Bundle args = new Bundle();
			args.putInt("title", title);
			frag.setArguments(args);
			return frag;
		}

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			int title = getArguments().getInt("title");
			return new AlertDialog.Builder(getActivity())
					.setIcon(R.drawable.ic_launcher)
					.setTitle(title)
					.setPositiveButton(R.string.alert_dialog_ok,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									((HelloAlertDialogFragmentActivity) getActivity())
											.doPositiveClick();
								}
							})
					.setNegativeButton(R.string.alert_dialog_cancel,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									((HelloAlertDialogFragmentActivity) getActivity())
											.doNegativeClick();
								}
							}).create();
		}
	}
}
