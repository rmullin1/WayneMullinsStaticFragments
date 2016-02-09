package edu.westga.waynemullinsstaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataDisplayAddFragment extends Fragment {

    private TextView textSum;
    private double value1;
    private double value2;
    private double sum;

    public void setValue1(double value) {
        value1 = value;
    }

    public void setValue2(double value) {
        value2 = value;
    }

    public DataDisplayAddFragment() {
        // Required empty public constructor
    }

    public void add() {
        sum = value1 + value2;
        String text = sum % 1.0 == 0 ? String.format("%d", (long) sum) : String.format("%s", sum);
        textSum.setText(text);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_display_add, container, false);
        textSum = (TextView)theView.findViewById(R.id.textView3);

        return theView;
    }


}
