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

public class GedungPemerintahan extends ListActivity {
    public void onCreate (Bundle icecle){
        super.onCreate(icecle);
        //buat variable array untuk menampilkan list gedung pemerintahan yang ada
        String [] gp = new String [] {"Gedung DPR",
                "Kantor Polisi","Kantor Gubernur","Gedung pemerintahan di sekitar saya",
                "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,gp));
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
            Intent gp = null;
            if (pilihan.equals("Gedung DPR")){
                gp = new Intent(this,DPR.class);
            }
            else if (pilihan.equals("Kantor Polisi")){
                gp = new Intent(this,Polisi.class);
            }
            else if (pilihan.equals("Kantor Gubernur")){
                gp = new Intent(this,Gubernur.class);
            }
            else if (pilihan.equals("Gedung pemerintahan di sekitar saya")){
                Uri dekatsaya = Uri.parse("geo:0,0?q=pemerintahan");
                gp = new Intent(Intent.ACTION_VIEW,dekatsaya);
                gp.setPackage("com.google.android.apps.maps");
            }
            else if (pilihan.equals("Exit")){
                finish();
            }
            startActivity(gp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


