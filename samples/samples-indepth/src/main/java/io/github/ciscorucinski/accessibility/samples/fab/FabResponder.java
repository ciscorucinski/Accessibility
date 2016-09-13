package io.github.ciscorucinski.accessibility.samples.fab;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

import io.github.ciscorucinski.accessibility.samples.FragmentType;
import io.github.ciscorucinski.accessibility.samples.SectionsPagerAdapter;

public abstract class FabResponder implements View.OnClickListener, DisplayUpdater {

    private FabUpdater fabUpdater;
    private ViewPager pager;
    private SectionsPagerAdapter adapter;
    private FragmentType currentType;

    protected FabResponder(FabUpdater listener) {
        this.fabUpdater = listener;
        currentType = FragmentType.DEFAULT;
    }

    @Override
    public void onClick(View view) {

        if ((pager == null) || (adapter == null)) return;

        FragmentType previousFragmentType = currentType;
        int currentTabPosition = pager.getCurrentItem();

        fabUpdater.update(previousFragmentType);

        currentType = previousFragmentType.swap();
        adapter.setFragmentDisplayType(currentTabPosition, currentType);
        updateDisplay(currentType, view);

    }

    /**
     * Initializes the FAB responder with the selected ViewPager and Adapter
     **/
    public void setupWithPager(@NonNull ViewPager pager, @NonNull SectionsPagerAdapter adapter) {
        this.pager = pager;
        this.adapter = adapter;
    }
}