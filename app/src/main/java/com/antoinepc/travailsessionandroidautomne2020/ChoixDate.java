package com.antoinepc.travailsessionandroidautomne2020;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ChoixDate extends DialogFragment
{
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int annee = c.get(Calendar.YEAR);
        int mois = c.get(Calendar.MONTH);
        int jour = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener) getActivity(),annee,mois,jour);
        dialog.getDatePicker().setMinDate(Calendar.getInstance().getTime().getTime());
        Calendar cMaxDate = Calendar.getInstance();
        cMaxDate.setTime(new Date());
        cMaxDate.add(Calendar.DATE,365);
        dialog.getDatePicker().setMaxDate(cMaxDate.getTime().getTime());

        return dialog;
    }

}
