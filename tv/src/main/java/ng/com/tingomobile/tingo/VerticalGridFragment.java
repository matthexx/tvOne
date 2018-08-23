package ng.com.tingomobile.tingo;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;


import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.VerticalGridPresenter;

import ng.com.tingomobile.tingo.data.VideoProvider;
import ng.com.tingomobile.tingo.Movie;
import ng.com.tingomobile.tingo.CardPresenter;

import org.json.JSONException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Vertical browse fragment
 * responsible for vertical layout of each channel category
 */
public class VerticalGridFragment  extends android.support.v17.leanback.app.VerticalGridFragment {



    private static final String TAG = VerticalGridFragment.class.getSimpleName();
    private static final int NUM_COLUMNS = 10;

    private LinkedHashMap<String, List<Movie>> mVideoLists = null;
    private ArrayObjectAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        setupFragment();
    }

    private void setupFragment() {
        VerticalGridPresenter gridPresenter = new VerticalGridPresenter();
        gridPresenter.setNumberOfColumns(NUM_COLUMNS);
        setGridPresenter(gridPresenter);

        mAdapter = new ArrayObjectAdapter(new CardPresenter());

//        /* Add movie items */
//        try {
//            mVideoLists = VideoProvider.buildMedia(getActivity());
//        } catch (JSONException e) {
//            Log.e(TAG, e.toString());
//        }
        for (int i = 0; i < 9; i++) { // This loop is to for increasing the number of contents. not necessary.
            for (Map.Entry<String, List<Movie>> entry : mVideoLists.entrySet()) {
                // String categoryName = entry.getKey();
                List<Movie> list = entry.getValue();
                for (int j = 0; j < list.size(); j++) {
                    Movie movie = list.get(j);
                    mAdapter.add(movie);
                }
            }
        }
        setAdapter(mAdapter);
    }
}