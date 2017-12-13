package linhmil.oop.hcmiu.rescuepets;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import linhmil.oop.hcmiu.rescuepets.entities.adapter.PetAdapter;
import linhmil.oop.hcmiu.rescuepets.entities.model.Pets;

public class PlayActivity extends Activity {
    GridView gvMatrix;
    int[] arrId;
    int[] arrImage;
    String[] arrPet;
    ArrayList<Pets> arrPets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        gvMatrix = (GridView) findViewById(R.id.gridview);
        TypedArray images = getResources().obtainTypedArray(R.array.arrImage);
        //int images[] = new int[]{R.drawable.cat,R.drawable.dog,R.drawable.hamster,R.drawable.tiger,R.drawable.pig};
        arrPet = getResources().getStringArray(R.array.arrPet);
        arrImage = new int[5];
        arrId = new int[5];
        for(int i=0;i<5;i++) {
            arrImage[i]= images.getResourceId(i,-1);
            //arrImage[i]=images[i];
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
        PetAdapter adapter = new PetAdapter(this, R.layout.item_pet, arrPets);
        gvMatrix.setAdapter(adapter);
        gvMatrix.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Pets pet = arrPets.get(position);
                Toast.makeText(PlayActivity.this,position+" clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
