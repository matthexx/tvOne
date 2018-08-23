package ng.com.tingomobile.tingo.data;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import ng.com.tingomobile.tingo.R;


    /**
     * FetchVideoService is responsible for fetching the videos from the Internet and inserting the
     * results into a local SQLite database.
     */
    public class FetchVideoService extends IntentService {
        private static final String TAG = "FetchVideoService";

        /**
         * Creates an IntentService with a default name for the worker thread.
         */
        public FetchVideoService() {
            super(TAG);
        }

        @Override
        protected void onHandleIntent(Intent workIntent) {
            VideoDbBuilder builder = new VideoDbBuilder(getApplicationContext());

            try {
                List<ContentValues> contentValuesList =
                        builder.fetch(getResources().getString(R.string.catalog_url));
                ContentValues[] downloadedVideoContentValues =
                        contentValuesList.toArray(new ContentValues[contentValuesList.size()]);
                getApplicationContext().getContentResolver().bulkInsert(VideoContract.VideoEntry.CONTENT_URI,
                        downloadedVideoContentValues);
            } catch (IOException | JSONException e) {
                Log.e(TAG, "Error occurred in downloading videos");
                e.printStackTrace();
            }
        }
    }


