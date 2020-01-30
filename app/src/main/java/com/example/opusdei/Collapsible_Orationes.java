package com.example.opusdei;

import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;

public class Collapsible_Orationes
{
	public void collapse(final TextView t, final SpannableString f, final SpannableString p)
	{
		t.setOnClickListener(new View.OnClickListener()
		{
			boolean full = true;
			public void onClick(View view)
			{
				if(full)
				{
					t.setText(f);
					full = false;
				}
				else
				{
					t.setText(p);
					full = true;
				}
			}
		});
	}
}