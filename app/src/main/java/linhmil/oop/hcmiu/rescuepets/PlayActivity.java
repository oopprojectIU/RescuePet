package linhmil.oop.hcmiu.rescuepets;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import java.util.ArrayList;
import java.util.Random;

import linhmil.oop.hcmiu.rescuepets.dynamicgrid.DynamicGridView;
import linhmil.oop.hcmiu.rescuepets.entities.adapter.PetAdapter;
import linhmil.oop.hcmiu.rescuepets.entities.model.Pets;
import linhmil.oop.hcmiu.rescuepets.movement.DragListener;
import linhmil.oop.hcmiu.rescuepets.movement.LongPressListener;

public class PlayActivity extends Activity {
    private DynamicGridView gvMatrix;
    private int[] arrId;
    private int[] arrImage;
    private String[] arrPet;
    private ArrayList<Pets> arrPets;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        gvMatrix = (DynamicGridView) findViewById(R.id.gridlayout);
        TypedArray images = getResources().obtainTypedArray(R.array.arrImage);

        //get resources
        arrPet = getResources().getStringArray(R.array.arrPet);
        arrImage = new int[5];
        arrId = new int[5];
        for(int i=0;i<5;i++) {
            arrImage[i]= images.getResourceId(i,-1);
            arrId[i]=i;
        }

        //initialize matrix
        int[][] a= new int[8][8];
        for (int i=0;i<6;i++) {
            for (int j=0;j<8;j++) {
                Random r = new Random();
                a[i][j]=r.nextInt()%4;
                if (a[i][j]<0) a[i][j]*=-1;
            }
        }

        //set item
        if (arrPets==null) arrPets= new ArrayList<>();
        for (int i=0;i<6;i++) {
            int count=0;
            for (int j =0; j<8; j++) {
                Pets temp = new Pets();
                int pos=a[i][j];
                temp.setId(arrId[pos]);
                temp.setName(arrPet[pos]);
                temp.setPic(arrImage[pos]);
                arrPets.add(temp);
            }
        }

        PetAdapter adapter = new PetAdapter(this,arrPets, 8);
        gvMatrix.setAdapter(adapter);
        gvMatrix.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                gvMatrix.startEditMode(position);
                return true;
            }
        });

/*        for (int i = 0; i < PetAdapter.NBR_ITEMS; i++) {
            adapter.getView(i,null,gvMatrix );
        }*/

/*        final LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < PetAdapter.NBR_ITEMS; i++) {
            System.out.println(1);
            final View itemView = inflater.inflate(R.layout.item_pet, gvMatrix, false);
            System.out.println(1);
            final ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setImageResource(arrPets.get(i).getPic());
            itemView.setOnLongClickListener(new LongPressListener());
            gvMatrix.addView(itemView);
        }*/

        /*gvMatrix.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long id) {
                Pets pet = arrPets.get(position);
                Toast.makeText(PlayActivity.this,position+" clicked", Toast.LENGTH_SHORT).show();

                gvMatrix.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent event) {
                        int pos2nd=0;
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            pos2nd=position+8;
                        }
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            pos2nd = position -8;
                        }
                        if (pos2nd<0) return false;
                        Pets temp = new Pets();
                        temp.assign(arrPets.get(position));
                        arrPets.get(position).assign(arrPets.get(pos2nd));
                        arrPets.get(pos2nd).assign(temp);
                        return true;
                    }
                });
                PetAdapter adapter = new PetAdapter(this, R.layout.item_pet, arrPets);
                gvMatrix.setAdapter(adapter);
            }
        });*/
    }
}
