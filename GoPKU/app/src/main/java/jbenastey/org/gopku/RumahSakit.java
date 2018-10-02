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

public class RumahSakit extends ListActivity {
    public void onCreate (Bundle icecle){
        super.onCreate(icecle);
        //buat variable array untuk menampilkan list rumah sakit yang ada
        String [] rs = new String [] {"Rumah Sakit Eka Hospital",
                "Rumah Sakit Awal Bros","Rumah Sakit Syafira",
                "Rumah Sakit di sekitar saya",
                "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,rs));
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
            Intent rs = null;
            if (pilihan.equals("Rumah Sakit Eka Hospital")){
                rs = new Intent(this,RSEkaHospital.class);
            }
            else if (pilihan.equals("Rumah Sakit Awal Bros")){
                rs = new Intent(this,RSAwalBros.class);
            }
            else if (pilihan.equals("Rumah Sakit Syafira")){
                rs = new Intent(this,RSSyafira.class);
            }
            else if (pilihan.equals("Rumah Sakit di sekitar saya")){
                Uri dekatsaya = Uri.parse("geo:0,0?q=hospital");
                rs = new Intent(Intent.ACTION_VIEW,dekatsaya);
                rs.setPackage("com.google.android.apps.maps");
            }
            else if (pilihan.equals("Exit")){
                finish();
            }
            startActivity(rs);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
