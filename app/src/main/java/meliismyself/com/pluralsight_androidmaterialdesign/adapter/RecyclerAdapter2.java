package meliismyself.com.pluralsight_androidmaterialdesign.adapter;

import android.content.Context;
import android.nfc.Tag;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import meliismyself.com.pluralsight_androidmaterialdesign.R;
import meliismyself.com.pluralsight_androidmaterialdesign.model.Landscape;
import meliismyself.com.pluralsight_androidmaterialdesign.model.Landscape2;

/**
 * Created by Meli Oktavia on 3/2/2016.
 */
public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.MyViewHolder> {
    private static final String TAG = RecyclerAdapter2.class.getSimpleName();
    private static final int PRIME_ROW = 0;
    private static final int NON_PRIME_ROW = 1;
    private List<Landscape2> mDataList;
    private LayoutInflater mInflater;


    public RecyclerAdapter2(Context context, ArrayList<Landscape2> data) {
        this.mDataList = data;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        switch (viewType){
            case PRIME_ROW:
                ViewGroup primeRow = (ViewGroup) mInflater.inflate(R.layout.list_item_prime, parent, false);
                MyViewHolder_PRIME holderPrime = new MyViewHolder_PRIME(primeRow);
                return holderPrime;
            case NON_PRIME_ROW:
                ViewGroup nonPrimeRow = (ViewGroup) mInflater.inflate(R.layout.list_item_not_prime, parent, false);
                MyViewHolder_NON_PRIME holderNonPrime = new MyViewHolder_NON_PRIME(nonPrimeRow);
                return holderNonPrime;
            default:
                ViewGroup defaulteRow = (ViewGroup) mInflater.inflate(R.layout.list_item_not_prime, parent, false);
                MyViewHolder_NON_PRIME holderDefault = new MyViewHolder_NON_PRIME(defaulteRow);
                return holderDefault;
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder " + position);
        Landscape2 currentObj = mDataList.get(position);

        switch (holder.getItemViewType()){
            case PRIME_ROW:
                MyViewHolder_PRIME holder_prime = (MyViewHolder_PRIME) holder;
                holder_prime.setData(currentObj);
                break;
            case NON_PRIME_ROW:
                MyViewHolder_NON_PRIME holder_non_prime = (MyViewHolder_NON_PRIME) holder;
                holder_non_prime.setData(currentObj);
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void removeItem(int position) {
        mDataList.remove(position);
        // notifyItemRemoved(position);
        // notifyItemRangeChanged(position, mDataList.size());
        notifyDataSetChanged();
    }

    public void addItem(int position, Landscape2 landscape) {
        mDataList.add(position, landscape);
        //notifyItemInserted(position);
        //notifyItemRangeChanged(position, mDataList.size());
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        Landscape2 landscape = mDataList.get(position);
        if (landscape.isPrime()) {
            return PRIME_ROW;
        } else {
            return NON_PRIME_ROW;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View itemView) {
            super(itemView);
        }

    }

    public class MyViewHolder_PRIME extends MyViewHolder{
        TextView title;
        ImageView imgThumb, imgRowType;
        int position;
        Landscape current;

        public MyViewHolder_PRIME (View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            imgThumb = (ImageView) itemView.findViewById(R.id.imgRow);
            imgRowType = (ImageView) itemView.findViewById(R.id.img_row_delete);
        }

        public void setData(Landscape2 current) {
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
            this.imgRowType.setImageResource(R.drawable.ic_delete_black_24dp);
        }
    }

    public class MyViewHolder_NON_PRIME extends MyViewHolder{
        TextView title;
        ImageView imgThumb, imgRowType;
        int position;
        Landscape current;

        public MyViewHolder_NON_PRIME (View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            imgThumb = (ImageView) itemView.findViewById(R.id.imgRow);
            imgRowType = (ImageView) itemView.findViewById(R.id.img_row_add);
        }

        public void setData(Landscape2 current) {
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
            this.imgRowType.setImageResource(R.drawable.ic_add_black_24dp);
        }
    }
}
