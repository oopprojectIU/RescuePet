package linhmil.oop.hcmiu.rescuepets.entities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import linhmil.oop.hcmiu.rescuepets.R;
import linhmil.oop.hcmiu.rescuepets.dynamicgrid.BaseDynamicGridAdapter;
import linhmil.oop.hcmiu.rescuepets.entities.model.Pets;

/**
 * Created by Admin on 12/10/2017.
 */

public class PetAdapter extends BaseDynamicGridAdapter {
    public static final int NBR_ITEMS = 8*6;

    public PetAdapter(Context context, int columnCount) {
        super(context, columnCount);
    }

    public PetAdapter(Context context, ArrayList<Pets> items, int columnCount) {
        super(context, items, columnCount);
    }

    /*
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater view = LayoutInflater.from(con);
        convertView = view.inflate(layout,null);
        ImageView ivItem = (ImageView) convertView.findViewById(R.id.imageView);
        Pets temp = arrPet.get(position);
        ivItem.setImageResource(temp.getPic());

        return convertView;
        //return super.getView(position, convertView, parent);
    }*/


/*    public View getView(int position, @Nullable View convertView, @NonNull GridLayout parent) {
        LayoutInflater inflater = LayoutInflater.from(con);
        //for (int i = 0; i < NBR_ITEMS; i++) {
            //convertView = inflater.inflate(layout, mGrid, false);
        convertView = inflater.inflate(layout, null);
        //final View itemView = inflater.inflate(R.layout.grid_item, mGrid, false);
            ImageView ivItem = (ImageView) convertView.findViewById(R.id.imageView);
            Pets temp = arrPet.get(position);
            ivItem.setImageResource(temp.getPic());
            ivItem.setOnLongClickListener(new LongPressListener());
        //}
            //parent.addView(convertView);
        //}
        return convertView;
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_pet, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //ivItem.setOnLongClickListener(new LongPressListener());
        holder.build(getItems().get(position).getPic());
        return convertView;
    }

    private class ViewHolder {
        private ImageView ivItem;

        private ViewHolder(View view) {
            ivItem = (ImageView) view.findViewById(R.id.imageView);
        }

        void build(int pic) {
            ivItem.setImageResource(pic);
        }
    }
}
