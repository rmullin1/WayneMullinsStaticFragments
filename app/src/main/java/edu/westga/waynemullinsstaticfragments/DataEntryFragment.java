package edu.westga.waynemullinsstaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataEntryFragment extends Fragment {

    private EditText value1Text;
    private EditText value2Text;
    private DataEntryListener listener;

    public double getValue1() {
        return Double.parseDouble(this.value1Text.getText().toString());
    }

    public double getValue2() {
        return Double.parseDouble(this.value2Text.getText().toString());
    }


    public interface DataEntryListener {
        void onDataEntry(double value1, double value2);
    }

    public DataEntryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_entry, container, false);
        this.value1Text = (EditText) theView.findViewById(R.id.editText);
        this.value2Text = (EditText) theView.findViewById(R.id.editText2);
        Button multiplyButton = (Button) theView.findViewById(R.id.multiplyButton);
        //anonymous class to handle onClick
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                multiplyButtonClicked(v);
            }
        });
        return theView;
    }

    //Multiply button click handler
    private void multiplyButtonClicked(View v) {
        double value1 = Double.parseDouble(this.value1Text.getText().toString());
        double value2 = Double.parseDouble(this.value2Text.getText().toString());
        listener.onDataEntry(value1, value2);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (DataEntryListener)context;
    }
}
