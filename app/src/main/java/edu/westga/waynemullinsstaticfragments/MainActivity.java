package edu.westga.waynemullinsstaticfragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements DataEntryFragment.DataEntryListener, DataDisplayFragment.DataAddButtonListener {

    @Override
    public void onDataEntry(double value1, double value2) {
        //handle event callback from DataEntryFragment
        DataDisplayFragment displayFragment = (DataDisplayFragment) getSupportFragmentManager().findFragmentById(R.id.dataDisplayFragment);
        displayFragment.setValue1(value1);
        displayFragment.setValue2(value2);
        displayFragment.multiply();
        displayFragment.displayProduct();
    }

    @Override
    public void onDataAdd(DataDisplayFragment fragment) {
        //handle event callback from DataEntryFragment
        DataEntryFragment dataEntryFragment = (DataEntryFragment)getSupportFragmentManager().findFragmentById(R.id.dataEntryFragment);
        double value1 = dataEntryFragment.getValue1();
        double value2 = dataEntryFragment.getValue2();
        DataDisplayAddFragment displayAddFragment = (DataDisplayAddFragment) getSupportFragmentManager().findFragmentById(R.id.dataDisplayAddFragment);
        displayAddFragment.setValue1(value1);
        displayAddFragment.setValue2(value2);
        displayAddFragment.add();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("StaticFragments");
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
