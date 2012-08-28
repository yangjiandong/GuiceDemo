package com.pstreets.guice.demo.listview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pstreets.guice.demo.R;

public class CustomAdapter extends BaseAdapter {
    private final Map<View, Map<Integer,View>> cache =
            new HashMap<View, Map<Integer,View>>();

    private final Context context;
    private final List<String> items;

    public CustomAdapter(Context context, List<String> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent )
    {
        View v = convertView;
        TextView tv;
        ImageView iv;
        if ( v == null )
        {
            LayoutInflater inflater = (LayoutInflater) context
                .getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            v = inflater.inflate( R.layout.item, parent, false );
        }
        Map<Integer, View> itemMap = cache.get( v );
        if( itemMap == null )
        {
            itemMap = new HashMap<Integer, View>();
            tv = (TextView) v.findViewById( android.R.id.text1 );
            iv = (ImageView) v.findViewById( R.id.imageView );
            itemMap.put( android.R.id.text1, tv );
            itemMap.put(R.id.imageView, iv );
            cache.put( v, itemMap );
        }
        else
        {
            tv = (TextView)itemMap.get( android.R.id.text1 );
            iv = (ImageView)itemMap.get( R.id.imageView );
        }
        final String item = (String) getItem( position );
        tv.setText( item );
        iv.setOnClickListener( new OnClickListener()
        {

            @Override
            public void onClick( View v )
            {
                Toast.makeText( context,
                    String.format( "Image clicked: %s", item ),
                        Toast.LENGTH_SHORT ).show();
            }
        } );
        return v;
    }

    public View getView2(int position, View convertView, ViewGroup parent) {
        /*
         * Please note that while this code works it is somewhat inefficient
         * and may result in some jerky scrolling. Please read the article
         * which explains this code at http://blog.stylingandroid.com/archives/623
         * for further explanation and base any production code on the later,
         * more efficient examples.
         */
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item, parent, false);
        final String item = (String) getItem(position);
        TextView tv = (TextView) v.findViewById(android.R.id.text1);
        ImageView iv = (ImageView) v.findViewById(R.id.imageView);
        tv.setText(item);
        iv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context, String.format("Image clicked: %s", item), Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}