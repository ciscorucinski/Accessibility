package io.github.ciscorucinski.accessibility.samples.ui;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import io.github.ciscorucinski.accessibility.R;
import io.github.ciscorucinski.accessibility.samples.FragmentType;
import io.github.ciscorucinski.accessibility.samples.SectionsPagerAdapter;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        final ViewPager viewPager = (ViewPager) findViewById(R.id.container);

        viewPager.setAdapter(adapter);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            FragmentType currentType = FragmentType.DEFAULT;

            @Override
            public void onClick(View view) {

                int currentPosition = viewPager.getCurrentItem();

                // swap the current icon with the new one
                currentType = (currentType == FragmentType.DEFAULT)
                        ? (FragmentType.ACCESSIBLE)
                        : (FragmentType.DEFAULT);

                // replace the FAB and Fragment
                fab.setImageResource(currentType.getIconResource());
                adapter.setFragmentDisplayType(currentPosition, currentType);

                Snackbar.make(view, currentType.getUserMessage(), Snackbar.LENGTH_LONG).show();

            }
        });

        // Let the user know that the UI is NOT accessible at the start
        CoordinatorLayout coordinator = (CoordinatorLayout) findViewById(R.id.main_content);
        Snackbar.make(coordinator, FragmentType.DEFAULT.getUserMessage(), Snackbar.LENGTH_LONG).show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sample, menu);
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
