package linhmil.oop.hcmiu.rescuepets.dynamicgrid;

import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import linhmil.oop.hcmiu.rescuepets.entities.model.Pets;

/**
 * Author: alex askerov
 * Date: 9/6/13
 * Time: 7:43 PM
 */


/**
 * Abstract adapter for {@link DynamicGridView} with sable items id;
 */

public abstract class AbstractDynamicGridAdapter extends BaseAdapter implements DynamicGridAdapterInterface {
    public static final int INVALID_ID = -1;

    private int nextStableId = 0;

    private HashMap<Pets, Integer> mIdMap = new HashMap<Pets, Integer>();

    /**
     * Adapter must have stable id
     *
     * @return
     */
    @Override
    public final boolean hasStableIds() {
        return true;
    }

    /**
     * creates stable id for object
     *
     * @param item
     */
    protected void addStableId(Pets item) {
        mIdMap.put(item, nextStableId++);
    }

    /**
     * create stable ids for list
     *
     * @param items
     */
    protected void addAllStableId(ArrayList<Pets> items) {
        for (Pets item : items) {
            addStableId(item);
        }
    }

    /**
     * get id for position
     *
     * @param position
     * @return
     */
    @Override
    public final long getItemId(int position) {
        if (position < 0 || position >= mIdMap.size()) {
            return INVALID_ID;
        }
        Object item = getItem(position);
        return mIdMap.get(item);
    }

    /**
     * clear stable id map
     * should called when clear adapter data;
     */
    protected void clearStableIdMap() {
        mIdMap.clear();
    }

    /**
     * remove stable id for <code>item</code>. Should called on remove data item from adapter
     *
     * @param item
     */
    protected void removeStableID(Pets item) {
        mIdMap.remove(item);
    }

}
