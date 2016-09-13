package io.github.ciscorucinski.accessibility.samples.ui;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import io.github.ciscorucinski.accessibility.R;
import io.github.ciscorucinski.accessibility.samples.FabFactory;
import io.github.ciscorucinski.accessibility.samples.FragmentType;
import io.github.ciscorucinski.accessibility.samples.SectionsPagerAdapter;
import io.github.ciscorucinski.accessibility.samples.fab.FabHandler;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final CoordinatorLayout coordinator = (CoordinatorLayout) findViewById(R.id.main_content);

        final SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());

        setSupportActionBar(toolbar);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        FabHandler updater = FabFactory.createHandler(fab, coordinator, viewPager, adapter, this);
        updater.update(FragmentType.ACCESSIBLE);

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
