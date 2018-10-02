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

public class SportCenter extends ListActivity {
    public void onCreate (Bundle icecle){
        super.onCreate(icecle);
        //buat variable array untuk menampilkan list sport center yang ada
        String [] sport = new String [] {"Stadion Utama Riau",
                "Stadion Kaharuddin Nasution","Gelanggang Remaja","Stadion di sekitar saya",
                "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,sport));
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
            Intent sport = null;
            if (pilihan.equals("Stadion Utama Riau")){
                sport = new Intent(this,SRiau.class);
            }
            else if (pilihan.equals("Stadion Kaharuddin Nasution")){
                sport = new Intent(this,SRumbai.class);
            }
            else if (pilihan.equals("Gelanggang Remaja")){
                sport = new Intent(this,GRemaja.class);
            }
            else if (pilihan.equals("Stadion di sekitar saya")){
                Uri dekatsaya = Uri.parse("geo:0,0?q=stadion");
                sport = new Intent(Intent.ACTION_VIEW,dekatsaya);
                sport.setPackage("com.google.android.apps.maps");
            }
            else if (pilihan.equals("Exit")){
                finish();
            }
            startActivity(sport);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}



