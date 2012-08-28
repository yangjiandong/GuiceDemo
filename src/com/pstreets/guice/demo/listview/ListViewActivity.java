package com.pstreets.guice.demo.listview;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.pstreets.guice.demo.R;

public class ListViewActivity extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listvmain);

//        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
//        for (int i = 0; i < 10; i++) {
//            Map<String, String> item = new HashMap<String, String>();
//            item.put("name", String.format("Item %d", i));
//            data.add(item);
//        }
//
//        String[] from = { "name" };
//        int[] to = { android.R.id.text1 };
//
//        SimpleAdapter adapter = new SimpleAdapter(this, data, android.R.layout.simple_list_item_1, from, to);
//        setListAdapter(adapter);

        List<String>data = new ArrayList<String>();
        for ( int i = 1; i <= 10; i++ )
        {
            data.add( String.format( "Item %d", i ) );
        }

        CustomAdapter adapter = new CustomAdapter( this, data );

        ListView listView = (ListView)findViewById( android.R.id.list );
        listView.setAdapter( adapter );

        listView.setOnItemClickListener( new OnItemClickListener()
        {
            @Override
            public void onItemClick( AdapterView<?> listView, View view,
                int pos, long id )
            {
                TextView textView =
                    (TextView) view.findViewById( android.R.id.text1 );
                toast( (String) textView.getText() );
            }
        } );
    }

    @Override
    protected void onListItemClick( ListView l, View v, int position, long id )
    {
        TextView textView = (TextView) v.findViewById( android.R.id.text1 );
        toast( (String) textView.getText() );
    }

    private void toast( String text )
    {
        Toast.makeText( ListViewActivity.this,
            String.format( "Item clicked: %s", text ), Toast.LENGTH_SHORT )
            .show();
    }
}