package com.example.schema;

import android.content.Context;

import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class SchemeLoader extends AsyncTaskLoader<List<ChildItem>> {
    private String mUrl;

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    public SchemeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    public List<ChildItem> loadInBackground() {
        if(mUrl == null) {
            return null;
        }

        return QueryUtils.fetchEarthquakeData(mUrl);
    }

}

