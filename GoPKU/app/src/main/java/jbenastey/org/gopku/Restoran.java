package jbenastey.org.gopku;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by jbenastey on 28-May-17.
 */

public class Restoran extends ListActivity {
    public void onCreate (Bundle icecle){
        super.onCreate(icecle);
        //buat variable array untuk menampilkan list restoran yang ada
        String [] resto = new String [] {"Pizza Hut",
                "CFC","KFC","Restoran di sekitar saya",
                "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,resto));
    }
    //fungsi untuk mendengarkan apa yang di klik
    protected void onListItemClick (ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }
    //seleksi pilihannya
    private void tampilkanpilihan(String pilihan) {
        try{
            //handle pilihan
            Intent resto = null;
            if (pilihan.equals("Pizza Hut")){
                resto = new Intent(this,PH.class);
            }
            else if (pilihan.equals("CFC")){
                resto = new Intent(this,CFC.class);
            }
            else if (pilihan.equals("KFC")){
                resto = new Intent(this,KFC.class);
            }
            else if (pilihan.equals("Restoran di sekitar saya")){
                Uri dekatsaya = Uri.parse("geo:0,0?q=restoran");
                resto = new Intent(Intent.ACTION_VIEW,dekatsaya);
                resto.setPackage("com.google.android.apps.maps");
            }
            else if (pilihan.equals("Exit")){
                finish();
            }
            startActivity(resto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

