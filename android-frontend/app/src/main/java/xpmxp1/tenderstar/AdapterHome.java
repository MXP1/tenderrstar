package xpmxp1.tenderstar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by David Ignacz on 21.03.2018.
 */

public class AdapterHome extends ArrayAdapter<String>{


    List<String> stringArray;


    public AdapterHome(@NonNull Context context, List<String> stringArray ) {
        super(context, 0, stringArray);

        this.stringArray = stringArray;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String stringToDisplay = stringArray.get(position);

        convertView = null;
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.home_item_layout, parent, false);

        TextView name = (TextView) convertView.findViewById(R.id.name);

        name.setText(null);
        name.setText(stringToDisplay);







    return convertView;}

}
