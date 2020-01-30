package com.example.opusdei;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

public class Letter_Styling
{
	public SpannableString redden_first_letter(String text, int color)
	{
		SpannableString spannable_string = new SpannableString(text);
		spannable_string.setSpan(new ForegroundColorSpan(color), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		return spannable_string;
	}
}