package linhmil.oop.hcmiu.rescuepets.movement;

import android.content.ClipData;
import android.view.View;

/**
 * Created by Admin on 12/14/2017.
 */

public class LongPressListener implements View.OnLongClickListener {
    @Override
    public boolean onLongClick(View view) {
        final ClipData data = ClipData.newPlainText("", "");
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
        view.startDrag(data, shadowBuilder, view, 0);
        view.setVisibility(View.INVISIBLE);
        return false;
    }
}
