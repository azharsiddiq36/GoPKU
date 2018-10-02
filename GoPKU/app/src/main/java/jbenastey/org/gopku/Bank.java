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

public class Bank extends ListActivity {
    public void onCreate (Bundle icecle){
        super.onCreate(icecle);
        //buat variable array untuk menampilkan list rumah sakit yang ada
        String [] bank = new String [] {"Bank Riau Kepri",
                "Bank Mandiri","Bank BRI","Bank di sekitar saya",
                "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,bank));
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
            Intent bank = null;
            if (pilihan.equals("Bank Riau Kepri")){
                bank = new Intent(this,BRiau.class);
            }
            else if (pilihan.equals("Bank Mandiri")){
                bank = new Intent(this,BMandiri.class);
            }
            else if (pilihan.equals("Bank BRI")){
                bank = new Intent(this,BBri.class);
            }
            else if (pilihan.equals("Bank di sekitar saya")){
                Uri dekatsaya = Uri.parse("geo:0,0?q=bank");
                bank = new Intent(Intent.ACTION_VIEW,dekatsaya);
                bank.setPackage("com.google.android.apps.maps");
            }
            else if (pilihan.equals("Exit")){
                finish();
            }
            startActivity(bank);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}



