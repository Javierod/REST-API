package javier.rodriguez.inmate.information.project;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by javier on 5/23/18.
 */

public class InmateListAdapter extends BaseAdapter{
    private Context mContext;
    private List<Inmate> mInmateList;

    public InmateListAdapter(Context mContext, List<Inmate> mInmateList){
        this.mContext = mContext;
        this.mInmateList = mInmateList;
    }

    @Override
    public int getCount() {
        return mInmateList.size();
    }

    @Override
    public Object getItem(int i) {
        return mInmateList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(mContext, R.layout.custom_row, null);
        TextView Facility_id = (TextView)v.findViewById(R.id.Facility_id);
        TextView Inmate_id = (TextView)v.findViewById(R.id.Inmate_id);
        TextView Inmate_name = (TextView)v.findViewById(R.id.Inmate_name);
        TextView Inmate_pod = (TextView)v.findViewById(R.id.Inmate_pod);
        TextView Inmate_uid = (TextView)v.findViewById(R.id.Inmate_uid);

        //Set text for objects
        Facility_id.setText("Facility #" + mInmateList.get(i).getFacilityID());
        Inmate_id.setText("ID #" + mInmateList.get(i).getInmateID());
        Inmate_name.setText("Inmate: " + mInmateList.get(i).getInmateFirstName() + " " +mInmateList.get(i).getInmateLastName());
        Inmate_pod.setText("Pod: " + mInmateList.get(i).getInmatePod());
        Inmate_uid.setText("Unit ID #" + mInmateList.get(i).getInmateUid());

        return v;
    }
}