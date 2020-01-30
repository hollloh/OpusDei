package com.example.opusdei;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.widget.Spinner;
import java.util.Calendar;

public class Logic
{
	// needed to get resources outside an activity
	// recommended not to do (due to memory leaks and crashes)
	// may change later
	// just too unfamiliar with java to know better practice
	static private Context context;
	public Logic(Context current)
	{
		this.context = current;
	}


	// simply used at the end of display_selected_officium()
	public void determine_feria_festa(Officium o)
	{
		Calendar calendar = Calendar.getInstance();

		//   january  1 :   1
		//  february  1 :  32
		//     march  1 :  61
		//     april  1 :  92
		//       may  1 : 122
		//      june  1 : 153
		//      july  1 : 183
		//    august  1 : 214
		// september  1 : 245
		//   october  1 : 275
		//  november  1 : 306
		//  december  1 : 336
		//  december 31 : 366
		int day_of_year = calendar.get(Calendar.DAY_OF_YEAR);

		System.out.println("DAY OF THE YEAR: " + day_of_year);


		// if today is just a feria
		// set oratio to collect of proper of season
		if(o.proprium == 0)
		{
			o.proprium_oratio.setText(R.string.dominica_1_adventus_oratio);
		}

		// if today is a festa
		if(o.proprium == 1)
		{
			switch(day_of_year)
			{
				case 33:
					o.proprium_oratio.setText(R.string.purificationis_beatae_mariae_virginis);
			}
		}

	}

	public void display_selected_officium(Officium o)
	{
		// for styling and collapsing the below orationes
		Letter_Styling letter_styling               = new Letter_Styling();
		Collapsible_Orationes collapsible_orationes = new Collapsible_Orationes();

		// this styles the strings
		SpannableString pater_noster_span_string_full          = letter_styling.redden_first_letter(context.getString(R.string.pater_noster_full),          context.getResources().getColor(R.color.red));
		SpannableString pater_noster_span_string_partial       = letter_styling.redden_first_letter(context.getString(R.string.pater_noster_partial),       context.getResources().getColor(R.color.red));
		SpannableString ave_maria_span_string_full             = letter_styling.redden_first_letter(context.getString(R.string.ave_maria_full),             context.getResources().getColor(R.color.red));
		SpannableString ave_maria_span_string_partial          = letter_styling.redden_first_letter(context.getString(R.string.ave_maria_partial),          context.getResources().getColor(R.color.red));
		SpannableString deus_in_adjutorium_span_string_full    = letter_styling.redden_first_letter(context.getString(R.string.deus_in_adjutorium_full),    context.getResources().getColor(R.color.red));
		SpannableString deus_in_adjutorium_span_string_partial = letter_styling.redden_first_letter(context.getString(R.string.deus_in_adjutorium_partial), context.getResources().getColor(R.color.red));
		SpannableString gloria_patri_span_string_full          = letter_styling.redden_first_letter(context.getString(R.string.gloria_patri_full),          context.getResources().getColor(R.color.red));
		SpannableString gloria_patri_span_string_partial       = letter_styling.redden_first_letter(context.getString(R.string.gloria_patri_partial),       context.getResources().getColor(R.color.red));

		// put in silly check to remind me some offices don't start with these (e.g.: compline)
		boolean yes = true;
		if(yes)
		{
			// let Collapsible_Orationes only handle the toggling
			o.pater_noster.setText(pater_noster_span_string_partial);
			o.ave_maria.setText(ave_maria_span_string_partial);
			o.deus_in_adjutorium.setText(deus_in_adjutorium_span_string_partial);
			o.gloriae[12].setText(gloria_patri_span_string_partial);

			// onClick() listener
			// toggles the full and partial oratio
			collapsible_orationes.collapse(o.pater_noster,       pater_noster_span_string_full,       pater_noster_span_string_partial);
			collapsible_orationes.collapse(o.ave_maria,          ave_maria_span_string_full,          ave_maria_span_string_partial);
			collapsible_orationes.collapse(o.deus_in_adjutorium, deus_in_adjutorium_span_string_full, deus_in_adjutorium_span_string_partial);
			collapsible_orationes.collapse(o.gloriae[12],        gloria_patri_span_string_full,       gloria_patri_span_string_partial);
		}

		int i;
		for(i = 0; i < 12; ++i)
		{
			o.gloriae[i].setText(gloria_patri_span_string_partial);
			collapsible_orationes.collapse(o.gloriae[i], gloria_patri_span_string_full, gloria_patri_span_string_partial);
		}


		// if vespers
		if (o.hora == 0)
		{
			for (i = 0; i < 4; ++i)
			{
				o.psalmi[i].setVisibility(View.VISIBLE);
				o.gloriae[i].setVisibility(View.VISIBLE);
			}
			for (i = 4; i < 12; ++i)
			{
				o.psalmi[i].setVisibility(View.GONE);
				o.gloriae[i].setVisibility(View.GONE);
			}
			for(i = 0; i < 8; ++i){o.antiphonae[i].setVisibility(View.VISIBLE);}
			for(i = 8; i < 17; ++i){o.antiphonae[i].setVisibility(View.GONE);}

			// if sunday
			if (o.feria == 0)
			{
				// set correct psalmus in TextView
				o.psalmi[0].setText(context.getResources().getString(R.string.dixit_dominus_109));
				o.psalmi[1].setText(context.getResources().getString(R.string.confitebor_tibi_domine_110));

				o.antiphonae[0].setText(context.getResources().getString(R.string.dominica_vesperas_1));
				o.antiphonae[1].setText(context.getResources().getString(R.string.dominica_vesperas_1));
				o.antiphonae[2].setText(context.getResources().getString(R.string.dominica_vesperas_2));
				o.antiphonae[3].setText(context.getResources().getString(R.string.dominica_vesperas_2));
			}
		}

		// if monday
		else if(o.feria == 1)
		{
			// if prime
			if(o.hora == 4)
			{
				for(i = 0; i < 4; ++i)
				{
					o.psalmi[i].setVisibility(View.VISIBLE);
					o.gloriae[i].setVisibility(View.VISIBLE);
				}
				for(i = 4; i < 12; ++i)
				{
					o.psalmi[i].setVisibility(View.GONE);
					o.gloriae[i].setVisibility(View.GONE);
				}



				o.psalmi[0].setText(context.getResources().getString(R.string.beautus_vir_1));
				o.psalmi[1].setText(context.getResources().getString(R.string.quare_fremuerunt_gentes_2));

				for(i = 0; i < 17; ++i){o.antiphonae[i].setVisibility(View.GONE);}
				o.antiphonae[0].setVisibility(View.VISIBLE);
				o.antiphonae[5].setVisibility(View.VISIBLE);
				o.antiphonae[0].setText(context.getResources().getString(R.string.secunda_primam_1));
				o.antiphonae[5].setText(context.getResources().getString(R.string.secunda_primam_1));
			}
		}
		determine_feria_festa(o);
	}


	public void get_time(Spinner feria_spinner, Spinner hora_spinner)
	{
		Calendar calendar = Calendar.getInstance();

		int day_of_year = calendar.get(Calendar.DAY_OF_YEAR);

		int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);
		int h = calendar.get(Calendar.HOUR_OF_DAY);
		int m = calendar.get(Calendar.MINUTE);
		int M = (h * 60) + m;

		switch(day_of_week)
		{
			case Calendar.SUNDAY:
				feria_spinner.setSelection(0);
				break;
			case Calendar.MONDAY:
				feria_spinner.setSelection(1);
				break;
			case Calendar.TUESDAY:
				feria_spinner.setSelection(2);
				break;
			case Calendar.WEDNESDAY:
				feria_spinner.setSelection(3);
				break;
			case Calendar.THURSDAY:
				feria_spinner.setSelection(4);
				break;
			case Calendar.FRIDAY:
				feria_spinner.setSelection(5);
				break;
			case Calendar.SATURDAY:
				feria_spinner.setSelection(6);
				break;
			default:
				feria_spinner.setSelection(0);
				break;
		}

		     if(M >=  990 && M < 1170){hora_spinner.setSelection(0);} // vesperas
		else if(M >= 1170 && M < 1350){hora_spinner.setSelection(1);} // completorium
		else if(M >= 1350 || M <   90){hora_spinner.setSelection(2);} // matutinum
		else if(M >=   90 && M <  270){hora_spinner.setSelection(3);} // laudes
		else if(M >=  270 && M <  450){hora_spinner.setSelection(4);} // primam
		else if(M >=  450 && M <  630){hora_spinner.setSelection(5);} // tertiam
		else if(M >=  630 && M <  810){hora_spinner.setSelection(6);} // sextam
		else if(M >=  810 && M <  990){hora_spinner.setSelection(7);} // nonam
		else                          {hora_spinner.setSelection(0);}
	} // get_time()
}
