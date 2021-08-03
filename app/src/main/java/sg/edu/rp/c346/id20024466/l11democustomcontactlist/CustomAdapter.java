package sg.edu.rp.c346.id20024466.l11democustomcontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Contact> contactList;

    public CustomAdapter(Context context,int resource,ArrayList<Contact> objects)
    {
        super(context,resource,objects);
        this.parent_context = context;
        this.layout_id = resource;
        this.contactList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id,parent,false);

        // connecting the xml variables to java variables

        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvCode = rowView.findViewById(R.id.textViewCountryCode);
        TextView tvNum = rowView.findViewById(R.id.textViewPhoneNum);
        ImageView ivGender = rowView.findViewById(R.id.imageViewGender);


        // get the position of item in list view
        Contact currentItem = contactList.get(position);
        tvName.setText(currentItem.getName());
        tvCode.setText("+" + currentItem.getCountryCode());
        tvNum.setText(currentItem.getPhoneNum() + " ");
        //ivGender.setImageResource(R.drawable.female);

        if(currentItem.getGender() == 'F')
        {
            ivGender.setImageResource(R.drawable.female);
        }
        else if(currentItem.getGender() == 'M')
        {
            ivGender.setImageResource(R.drawable.male);
        }
        return rowView;
    }
}
