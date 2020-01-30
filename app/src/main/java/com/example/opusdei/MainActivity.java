package com.example.opusdei;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	public Spinner proprium_spinner,
	               proprium_de_tempore_spinner,
	               adventus_spinner,
	               nativitas_spinner,
	               proprium_sanctorum_spinner,
	               januarii_spinner,
	               februarii_spinner,
	               feria_spinner,
	               hora_spinner;

	public Officium o = new Officium();

	// needed to get resources outside an activity
	// recommended not to do (due to memory leaks and crashes)
	// may change later
	// just too unfamiliar with java to know better practice
	final Logic logic = new Logic(this);

	@Override
	protected void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		o.pater_noster       = findViewById(R.id.pater_noster);
		o.ave_maria          = findViewById(R.id.ave_maria);
		o.deus_in_adjutorium = findViewById(R.id.deus_in_adjutorium);
		o.gloriae[12]       = findViewById(R.id.gloria_patri_0);

		o.psalmi[0] = findViewById(R.id.psalmus_1);
		o.psalmi[1] = findViewById(R.id.psalmus_2);
		o.psalmi[2] = findViewById(R.id.psalmus_3);
		o.psalmi[3] = findViewById(R.id.psalmus_4);
		o.psalmi[4] = findViewById(R.id.psalmus_5);
		o.psalmi[5] = findViewById(R.id.psalmus_6);
		o.psalmi[6] = findViewById(R.id.psalmus_7);
		o.psalmi[7] = findViewById(R.id.psalmus_8);
		o.psalmi[8] = findViewById(R.id.psalmus_9);
		o.psalmi[9] = findViewById(R.id.psalmus_10);
		o.psalmi[10] = findViewById(R.id.psalmus_11);
		o.psalmi[11] = findViewById(R.id.psalmus_12);

		o.gloriae[0] = findViewById(R.id.gloria_patri_1);
		o.gloriae[1] = findViewById(R.id.gloria_patri_1);
		o.gloriae[2] = findViewById(R.id.gloria_patri_2);
		o.gloriae[3] = findViewById(R.id.gloria_patri_3);
		o.gloriae[4] = findViewById(R.id.gloria_patri_4);
		o.gloriae[5] = findViewById(R.id.gloria_patri_5);
		o.gloriae[6] = findViewById(R.id.gloria_patri_6);
		o.gloriae[7] = findViewById(R.id.gloria_patri_7);
		o.gloriae[8] = findViewById(R.id.gloria_patri_8);
		o.gloriae[9] = findViewById(R.id.gloria_patri_9);
		o.gloriae[10] = findViewById(R.id.gloria_patri_10);
		o.gloriae[11] = findViewById(R.id.gloria_patri_11);

		o.antiphonae[0] = findViewById(R.id.antiphona_1_1);
		o.antiphonae[1] = findViewById(R.id.antiphona_1_2);
		o.antiphonae[2] = findViewById(R.id.antiphona_2_1);
		o.antiphonae[3] = findViewById(R.id.antiphona_2_2);
		o.antiphonae[4] = findViewById(R.id.antiphona_3_1);
		o.antiphonae[5] = findViewById(R.id.antiphona_3_2);
		o.antiphonae[6] = findViewById(R.id.antiphona_4_1);
		o.antiphonae[7] = findViewById(R.id.antiphona_4_2);
		o.antiphonae[8] = findViewById(R.id.antiphona_5_1);
		o.antiphonae[9] = findViewById(R.id.antiphona_5_2);
		o.antiphonae[10] = findViewById(R.id.antiphona_6_1);
		o.antiphonae[11] = findViewById(R.id.antiphona_6_2);
		o.antiphonae[12] = findViewById(R.id.antiphona_7_1);
		o.antiphonae[13] = findViewById(R.id.antiphona_7_2);
		o.antiphonae[14] = findViewById(R.id.antiphona_8_1);
		o.antiphonae[15] = findViewById(R.id.antiphona_8_2);
		o.antiphonae[16] = findViewById(R.id.antiphona_9_1);
		o.antiphonae[17] = findViewById(R.id.antiphona_9_2);

		o.proprium_oratio = findViewById(R.id.proprium_oratio);

		// spinner for proprium
		proprium_spinner = findViewById(R.id.proprium_spinner);
		ArrayAdapter<CharSequence> proprium_adapter = ArrayAdapter.createFromResource(this, R.array.proprium_array, android.R.layout.simple_spinner_item);
		proprium_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		proprium_spinner.setAdapter(proprium_adapter);

		proprium_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				if(position == 0)
				{
					o.proprium = 0;
					proprium_de_tempore_spinner.setVisibility(View.VISIBLE);
					           adventus_spinner.setVisibility(View.VISIBLE);
					          nativitas_spinner.setVisibility(View.VISIBLE);

					proprium_sanctorum_spinner.setVisibility(View.GONE);
					          januarii_spinner.setVisibility(View.GONE);
					         februarii_spinner.setVisibility(View.GONE);
				}

				if(position == 1)
				{
					o.proprium = 1;
					proprium_de_tempore_spinner.setVisibility(View.GONE);
					           adventus_spinner.setVisibility(View.GONE);
					          nativitas_spinner.setVisibility(View.GONE);

					proprium_sanctorum_spinner.setVisibility(View.VISIBLE);
					          januarii_spinner.setVisibility(View.VISIBLE);
					         februarii_spinner.setVisibility(View.VISIBLE);
				}
				logic.display_selected_officium(o);
			}
			@Override public void onNothingSelected(AdapterView<?> parentView){}
		});

		proprium_de_tempore_spinner = findViewById(R.id.proprium_de_tempore_spinner);
		ArrayAdapter<CharSequence> proprium_de_tempore_adapter = ArrayAdapter.createFromResource(this, R.array.proprium_de_tempore_array, android.R.layout.simple_spinner_item);
		proprium_de_tempore_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		proprium_de_tempore_spinner.setAdapter(proprium_de_tempore_adapter);
		proprium_de_tempore_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				if(position == 0)
				{
					 adventus_spinner.setVisibility(View.VISIBLE);
					nativitas_spinner.setVisibility(View.GONE);
				}
				if(position == 1)
				{
					 adventus_spinner.setVisibility(View.GONE);
					nativitas_spinner.setVisibility(View.VISIBLE);
				}
				logic.display_selected_officium(o);
			}
			@Override public void onNothingSelected(AdapterView<?> parentView){}
		});

		adventus_spinner = findViewById(R.id.adventus_spinner);
		ArrayAdapter<CharSequence> adventus_adapter = ArrayAdapter.createFromResource(this, R.array.adventus_array, R.layout.multiline_spinner_dropdown_item);
		adventus_adapter.setDropDownViewResource(R.layout.multiline_spinner_dropdown_item);
		adventus_spinner.setAdapter(adventus_adapter);
		adventus_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				logic.display_selected_officium(o);
			}
			@Override public void onNothingSelected(AdapterView<?> parentView){}
		});

		nativitas_spinner = findViewById(R.id.nativitas_spinner);
		ArrayAdapter<CharSequence> nativitas_adapter = ArrayAdapter.createFromResource(this, R.array.nativitas_array, android.R.layout.simple_spinner_item);
		nativitas_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		nativitas_spinner.setAdapter(nativitas_adapter);
		nativitas_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				logic.display_selected_officium(o);
			}
			@Override public void onNothingSelected(AdapterView<?> parentView){}
		});

		proprium_sanctorum_spinner = findViewById(R.id.proprium_sanctorum_spinner);
		ArrayAdapter<CharSequence> proprium_sanctorum_adapter = ArrayAdapter.createFromResource(this, R.array.proprium_sanctorum_array, android.R.layout.simple_spinner_item);
		proprium_sanctorum_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		proprium_sanctorum_spinner.setAdapter(proprium_sanctorum_adapter);
		proprium_sanctorum_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				if(position == 0)
				{
					 januarii_spinner.setVisibility(View.VISIBLE);
					februarii_spinner.setVisibility(View.GONE);
				}
				if(position == 1)
				{
					 januarii_spinner.setVisibility(View.GONE);
					februarii_spinner.setVisibility(View.VISIBLE);
				}
				logic.display_selected_officium(o);
			}
			@Override public void onNothingSelected(AdapterView<?> parentView){}
		});

		januarii_spinner = findViewById(R.id.januarii_spinner);
		ArrayAdapter<CharSequence> januarii_adapter = ArrayAdapter.createFromResource(this, R.array.januarii_array, android.R.layout.simple_spinner_item);
		januarii_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		januarii_spinner.setAdapter(januarii_adapter);
		januarii_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				logic.display_selected_officium(o);
			}
			@Override public void onNothingSelected(AdapterView<?> parentView){}
		});

		februarii_spinner = findViewById(R.id.februarii_spinner);
		ArrayAdapter<CharSequence> februarii_adapter = ArrayAdapter.createFromResource(this, R.array.februarii_array, android.R.layout.simple_spinner_item);
		februarii_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		februarii_spinner.setAdapter(februarii_adapter);
		februarii_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				logic.display_selected_officium(o);
			}
			@Override public void onNothingSelected(AdapterView<?> parentView){}
		});

		feria_spinner = findViewById(R.id.feria_spinner);
		ArrayAdapter<CharSequence> feria_adapter = ArrayAdapter.createFromResource(this, R.array.feria_array, android.R.layout.simple_spinner_item);
		feria_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		feria_spinner.setAdapter(feria_adapter);
		feria_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				o.feria = position;
				logic.display_selected_officium(o);
			}
			@Override public void onNothingSelected(AdapterView<?> parentView){}
		});

		hora_spinner = findViewById(R.id.hora_spinner);
		ArrayAdapter<CharSequence> hora_adapter = ArrayAdapter.createFromResource(this, R.array.hora_array, android.R.layout.simple_spinner_item);
		hora_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		hora_spinner.setAdapter(hora_adapter);
		hora_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
			{
				o.hora = position;
				logic.display_selected_officium(o);
			}
			@Override public void onNothingSelected(AdapterView<?> parentView){}
		});

		// eventually adjust these variable names
		Button button = findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view)
			{
				logic.get_time(feria_spinner, hora_spinner);
				logic.display_selected_officium(o);
			}
		});
	} // onCreate
} // public class MainActivity extends AppCompatActivity


/* ******************************************************************
   **** for reference on how to create elements programmatically ****
   ******************************************************************

		import com.google.android.flexbox.FlexboxLayout;

		public LinearLayout main_linear_layout;

		main_linear_layout = findViewById(R.id.main_linear_layout);
		FlexboxLayout iniOraFlexLay = findViewById(R.id.initial_orationes_flexbox_layout);
		for(int i = 0; i < 10; ++i)
		{
			TextView extra_gloria = new TextView(getApplicationContext());
			extra_gloria.setText("EXTRA " + i);
			extra_gloria.setTextColor(Color.parseColor("#000000"));
			iniOraFlexLay.addView(extra_gloria);

		}
		TextView extra_gloria = new TextView(getApplicationContext());
		extra_gloria.setText("EXTRA");
		extra_gloria.setTextColor(Color.parseColor("#000000"));
		iniOraFlexLay.addView(extra_gloria);

   ******************************************************************
   ****                                                          ****
   ****************************************************************** */

