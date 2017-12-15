package linhmil.oop.hcmiu.rescuepets;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.Button;
import android.view.animation.AnimationUtils;


import java.util.ArrayList;
import java.util.Random;

import linhmil.oop.hcmiu.rescuepets.dynamicgrid.DynamicGridView;
import linhmil.oop.hcmiu.rescuepets.entities.adapter.PetAdapter;
import linhmil.oop.hcmiu.rescuepets.entities.model.Board;
import linhmil.oop.hcmiu.rescuepets.entities.model.Pets;

public class PlayActivity extends Activity {
    private DynamicGridView gvMatrix;
    private int[] arrId;
    private int[] arrImage;
    private String[] arrPet;
    private ArrayList<Pets> arrPets;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder a_builder = new AlertDialog.Builder(PlayActivity.this);
        a_builder.setMessage("Do you want to quit the game?")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }) ;
        AlertDialog alert = a_builder.create();
        alert.setTitle("Quit game");
        alert.show();

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Board.current=6;

        gvMatrix = (DynamicGridView) findViewById(R.id.gridlayout);
        TypedArray images = getResources().obtainTypedArray(R.array.arrImage);

        //get resources
        arrPet = getResources().getStringArray(R.array.arrPet);
        arrImage = new int[5];
        arrId = new int[5];
        for (int i = 0; i < 5; i++) {
            arrImage[i] = images.getResourceId(i, -1);
            arrId[i] = i;
        }

        //set item for gridlayout
        if (arrPets == null) arrPets = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int count = 0;
            for (int j = 0; j < 8; j++) {
                int pos = Board.getInstance().getElement(Board.row-Board.current+i,j);;
                Pets temp = new Pets(arrId[pos]);
                temp.setPic(arrImage[pos]);
                arrPets.add(temp);
            }
        }

        PetAdapter adapter = new PetAdapter(this, arrPets, 8);
        gvMatrix.setAdapter(adapter);
        gvMatrix.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                gvMatrix.startEditMode(position);

                return true;
            }
        });


    }
}
