﻿/***
	Copyright (c) 2008-2009 CommonsWare, LLC
	
	Licensed under the Apache License, Version 2.0 (the "License"); you may
	not use this file except in compliance with the License. You may obtain
	a copy of the License at
		http://www.apache.org/licenses/LICENSE-2.0
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/

package com.commonsware.android.selection;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoCompleteDemo extends Activity
	implements TextWatcher {
	TextView selection;
	AutoCompleteTextView edit;
	String[] items={"lorem", "ipsum", "dolor", "sit", "amet",
					"consectetuer", "adipiscing", "elit", "morbi", "vel",
					"ligula", "vitae", "arcu", "aliquet", "mollis",
					"etiam", "vel", "erat", "placerat", "ante",
					"porttitor", "sodales", "pellentesque", "augue", "purus"};

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		selection=(TextView)findViewById(R.id.selection);
		edit=(AutoCompleteTextView)findViewById(R.id.edit);
		edit.addTextChangedListener(this);
		
		edit.setAdapter(new ArrayAdapter<String>(this,
													android.R.layout.simple_dropdown_item_1line,
													items));
	}
	
	public void onTextChanged(CharSequence s, int start, int before,
															int count) {
		selection.setText(edit.getText());
	}
	
	public void beforeTextChanged(CharSequence s, int start,
																	int count, int after) {
		// 인터페이스를 구현할 때 필요하지만, 사용하지 않음
	}
	
	public void afterTextChanged(Editable s) {
		// 인터페이스를 구현할 때 필요하지만, 사용하지 않음
	}
}