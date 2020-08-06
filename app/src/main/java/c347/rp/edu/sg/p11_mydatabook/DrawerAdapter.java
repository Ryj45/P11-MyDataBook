package c347.rp.edu.sg.p11_mydatabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class DrawerAdapter extends ArrayAdapter<String> {
    Context context;
    String[] drawerItems;
    ImageView ivIcon;
    TextView tvItem;
    int resource;

    public DrawerAdapter(Context context, int resource, String[] drawerItems){
        super(context, resource, drawerItems);
        this.context = context;
        this.resource = resource;
        this.drawerItems = drawerItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resource, parent, false);

        ivIcon = rowView.findViewById(R.id.ivIcon);
        tvItem = rowView.findViewById(R.id.tvItem);

        String item = drawerItems[position];
        tvItem.setText(item);

        if (position == 0)
            ivIcon.setImageResource(android.R.drawable.ic_menu_info_details);
        else if (position == 1)
            ivIcon.setImageResource(android.R.drawable.ic_menu_edit);
        else if (position == 2)
            ivIcon.setImageResource(android.R.drawable.ic_menu_my_calendar);
        else if (position == 3)
            ivIcon.setImageResource(android.R.drawable.btn_star_big_on);


        return rowView;
    }
}
