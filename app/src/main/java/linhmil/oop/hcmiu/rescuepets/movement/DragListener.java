package linhmil.oop.hcmiu.rescuepets.movement;

import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

/**
 * Created by Admin on 12/14/2017.
 */

public class DragListener implements View.OnDragListener {

    private GridLayout layout;

    public DragListener(GridLayout layout) {
        this.layout = layout;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        final View view = (View) event.getLocalState();
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_LOCATION:
                // do nothing if hovering above own position
                if (view == v) return true;
                // get the new list index
                final int index = calculateNewIndex(event.getX(), event.getY());
                // remove the view from the old position
                layout.removeView(view);
                // and push to the new
                layout.addView(view, index);
                break;
            case DragEvent.ACTION_DROP:
                view.setVisibility(View.VISIBLE);
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                if (!event.getResult()) {
                    view.setVisibility(View.VISIBLE);
                }
                break;
        }
        return false;
    }

    private int calculateNewIndex(float x, float y) {
        // calculate which column to move to
        final float cellWidth = layout.getWidth() / layout.getColumnCount();
        final int column = (int)(x / cellWidth);

        // calculate which row to move to
        final float cellHeight = layout.getHeight() / layout.getRowCount();
        final int row = (int)Math.floor(y / cellHeight);

        // the items in the GridLayout is organized as a wrapping list
        // and not as an actual grid, so this is how to get the new index
        int index = row * layout.getColumnCount() + column;
        if (index >= layout.getChildCount()) {
            index = layout.getChildCount() - 1;
        }

        return index;
    }
}
