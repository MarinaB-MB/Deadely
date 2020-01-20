package com.deadely.copy;
 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
 
public class DataAdapter extends BaseAdapter{
 
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public DataAdapter(MainActivity mainActivity, String[] mvNameList, int[] mvImages) {
        
        result=mvNameList;
        context=mainActivity;
        imageId=mvImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
    }
 
    @Override
    public int getCount() {
       
        return result.length;
    }
 
    @Override
    public Object getItem(int position) {
       
        return position;
    }
 
    @Override
    public long getItemId(int position) {
       
        return position;
    }
 
    public class Holder
    {
        TextView mv_text;
        ImageView mv_img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
      
        Holder holder=new Holder();
        View rowView;
 
        rowView = inflater.inflate(R.layout.item, null);
        holder.mv_text =(TextView) rowView.findViewById(R.id.mv_texts);
        holder.mv_img =(ImageView) rowView.findViewById(R.id.mv_images);
 
        holder.mv_text.setText(result[position]);
        holder.mv_img.setImageResource(imageId[position]);
 
        rowView.setOnClickListener(new OnClickListener() {
 
            @Override
            public void onClick(View v) {
                
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_SHORT).show();
            }
        });
 
        return rowView;
    }
 
}