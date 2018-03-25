package linhmil.oop.hcmiu.rescuepets.dynamicgrid;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import linhmil.oop.hcmiu.rescuepets.entities.model.Pets;

public class DynamicGridUtils {

    public static void reorder(ArrayList<Pets> list, int indexFrom, int indexTwo) {
        Pets obj = list.remove(indexFrom);
        list.add(indexTwo, obj);
    }


    public static void swap(ArrayList<Pets> list, int firstIndex, int secondIndex) {
        Pets firstObject = list.get(firstIndex);
        Pets secondObject = list.get(secondIndex);
        list.set(firstIndex, secondObject);
        list.set(secondIndex, firstObject);
    }

    public static float getViewX(View view) {
        return Math.abs((view.getRight() - view.getLeft()) / 2);
    }

    public static float getViewY(View view) {
        return Math.abs((view.getBottom() - view.getTop()) / 2);
    }
}
