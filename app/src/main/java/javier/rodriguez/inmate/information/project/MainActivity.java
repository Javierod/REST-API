package javier.rodriguez.inmate.information.project;

import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button displayButton;       //Variable to handle button.
    private RequestQueue requestQueue;  //Variable to handle requests.
    private ListView InmateListView;    //Variable to handle list.
    private InmateListAdapter InmateLA; //Variable to handle list adapter.
    private List<Inmate> inmateList;    //List object.
    private boolean httpCall = false;      //Signal.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayButton = (Button) findViewById(R.id.ParseButton);        //Linking
        InmateListView = (ListView) findViewById(R.id.CustomList);      //Linking
        final View header = (View) getLayoutInflater().inflate(R.layout.list_header,null);

        inmateList = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);            //Initializing.

        //Function
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!httpCall) {
                    parseJson();
                    InmateLA = new InmateListAdapter(getApplicationContext(), inmateList);
                    InmateListView.addHeaderView(header);
                    InmateListView.setAdapter(InmateLA);
                } else {
                    Toast.makeText(getApplicationContext(),"DISPLAYED", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void parseJson(){
        String URL = "https://api.citytelecoin.com/3186291/getInmates"; //REST API address.
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try{for(int i=0; i<response.length(); i++){
                            JSONObject inmate = response.getJSONObject(i);
                            InmateLA.notifyDataSetChanged();
                            inmateList.add(new Inmate(inmate.getString("facility_id"),
                                                      inmate.getString("inmate_id"),
                                                      inmate.getString("first_name"),
                                                      inmate.getString("last_name"),
                                                      inmate.getString("pod"),
                                                      inmate.getString("uid")));
                        }
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonArrayRequest);
        httpCall = true;
    }
}
