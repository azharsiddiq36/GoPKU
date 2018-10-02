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

public class Campus extends ListActivity {
    public void onCreate (Bundle icecle){
        super.onCreate(icecle);
        //buat variable array untuk menampilkan list kampus yang ada
        String [] campus = new String [] {"UIN SUSKA Riau",
                "Universitas Riau","Universitas Lancang Kuning","Kampus di sekitar saya",
                "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,campus));
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
            Intent campus = null;
            if (pilihan.equals("UIN SUSKA Riau")){
                campus = new Intent(this,UIN.class);
            }
            else if (pilihan.equals("Universitas Riau")){
                campus = new Intent(this,UR.class);
            }
            else if (pilihan.equals("Universitas Lancang Kuning")){
                campus = new Intent(this,Unilak.class);
            }
            else if (pilihan.equals("Kampus di sekitar saya")){
                Uri dekatsaya = Uri.parse("geo:0,0?q=kampus");
                campus = new Intent(Intent.ACTION_VIEW,dekatsaya);
                campus.setPackage("com.google.android.apps.maps");
            }
            else if (pilihan.equals("Exit")){
                finish();
            }
            startActivity(campus);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


