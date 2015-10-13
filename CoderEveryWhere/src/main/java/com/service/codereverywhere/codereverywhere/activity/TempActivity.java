package com.service.codereverywhere.codereverywhere.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import com.service.codereverywhere.codereverywhere.BaseActivity;
import com.service.codereverywhere.codereverywhere.R;

public class TempActivity extends BaseActivity {

    private ListView _listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    protected int getLayout() {
        return R.layout.activity_category;
    }

    @Override
    protected void generateUIComponents() {
_listView = (ListView)findViewById(R.id.listView);
    }
}
