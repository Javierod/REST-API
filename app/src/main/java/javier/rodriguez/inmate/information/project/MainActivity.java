package javier.rodriguez.inmate.information.project;

import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button displayButton;       //Variable to handle button.
    private RequestQueue requestQueue;  //Variable to handle requests.
    private ListView InmateListView;    //Variable to handle list.
    private InmateListAdapter InmateLA; //Variable to handle list adapter.
    private List<Inmate> inmateList;    //List object.
    private String httpCall;            //Flag.
    private Inmate [] inmate;           //Array to handle inmates data.
    private String [] spinnerChoices = {"UNSORTED", "SORT BY ID", "SORT BY ABC", "SORT BY UID"}; //Array to allow user to sort list.
    private Spinner spinner;            //Variable to handle spinner.
    private ArrayAdapter arrayAdapter;  //Spinner adapter.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayButton = (Button) findViewById(R.id.ParseButton);        //Linking.
        spinner = (Spinner) findViewById(R.id.Spinner);                 //Linking.
        InmateListView = (ListView) findViewById(R.id.CustomList);      //Linking.
        final View header = (View) getLayoutInflater().inflate(R.layout.list_header,null);                   //Linking.
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,spinnerChoices); //Linking.

        inmateList = new ArrayList<>();                                 //Initializing
        requestQueue = Volley.newRequestQueue(this);            //Initializing.
        spinner.setAdapter(arrayAdapter);

        parseJson();                                                                    //Parsing JSON file.
        InmateLA = new InmateListAdapter(getApplicationContext(), inmateList);          //Setting up list adapter.
        InmateListView.addHeaderView(header);                                           //Setting up list header.
        InmateListView.setAdapter(InmateLA);                                            //Setting list.

        //Function
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spinner.getSelectedItem() == spinnerChoices[0]) {
                    unsorted();
                } else if(spinner.getSelectedItem() == spinnerChoices[1]){
                    sortById();
                } else if(spinner.getSelectedItem() == spinnerChoices[2]){
                    sortByABC();
                } else{
                    sortByUID();
                }
            }
        });
    }

    ////////////////////////////////////////////
    //FUNCTION NAME: parseJson                //
    //FUNCTION PURPOSE: Parse JSON file.      //
    //                                        //
    //PARAMETERS: None.                       //
    //RETURNS: Void.                          //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/23/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION: 05/24/2018           //
    //MADE BY: Javier Rodriguez.              //
    ////////////////////////////////////////////
    public void parseJson(){
        String URL = "https://api.citytelecoin.com/3186291/getInmates"; //REST API address.
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try{inmate = new Inmate[response.length()];
                            for(int i=0; i<response.length(); i++) {
                                JSONObject inmateJSON = response.getJSONObject(i);
                                inmate[i] = new Inmate(inmateJSON.getString("facility_id"), inmateJSON.getString("inmate_id"),
                                                       inmateJSON.getString("first_name"), inmateJSON.getString("last_name"),
                                                       inmateJSON.getString("pod"), inmateJSON.getString("uid"));
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
    }

    ////////////////////////////////////////////
    //FUNCTION NAME: unsorted                 //
    //FUNCTION PURPOSE: Display default list. //
    //                                        //
    //PARAMETERS: None.                       //
    //RETURNS: Void.                          //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/24/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    public void unsorted(){
        inmateList.clear();                                         //Cleaning list.
        for (int i = 0; i < inmate.length; i++)                     //Adding items to list.
            inmateList.add(inmate[i]);
        InmateLA.notifyDataSetChanged();                            //Notifying change.
    }

    ////////////////////////////////////////////
    //FUNCTION NAME: sortById                 //
    //FUNCTION PURPOSE: Display list sorted by//
    //                  id.                   //
    //                                        //
    //PARAMETERS: None.                       //
    //RETURNS: Void.                          //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/24/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    public void sortById(){
        int [] order = new int[inmate.length];                  //Array to handle IDs.
        int [] indexOrder = new int[inmate.length];             //Array to handle IDs position.

        //Getting inmates IDs.
        for(int i=0; i < inmate.length; i++)
            try{ order[i] = Integer.parseInt(inmate[i].getInmateID());      //Initializing.
            } catch(NumberFormatException e){
                Toast.makeText(getApplicationContext(), "COULD NOT CONVERT IDs", Toast.LENGTH_SHORT).show();
            }

        //Initializing.
        for(int i=0; i< inmate.length; i++)
            indexOrder[i] = i;

        //Bubble sort.
        bubbleSort(indexOrder, order);


        inmateList.clear();                             //Clearing list.
        for (int i = 0; i < indexOrder.length; i++)     //Adding items to list.
            inmateList.add(inmate[indexOrder[i]]);
        InmateLA.notifyDataSetChanged();                //Notifying change.
    }

    ////////////////////////////////////////////
    //FUNCTION NAME: sortByabc                //
    //FUNCTION PURPOSE: Display list sorted   //
    //                  alphabetically.       //
    //                                        //
    //PARAMETERS: None.                       //
    //RETURNS: Void.                          //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/24/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:05/25/2018            //
    //MADE BY: Javier Rodriguez.              //
    ////////////////////////////////////////////
    public void sortByABC(){
        int compare = "CARL".compareTo("JOSE");

        inmateList.clear();
        if(compare>1){
            Log.i("LOG", "CARL");
        } else
            Log.i("LOG", "JOSE");
        InmateLA.notifyDataSetChanged();
    }

    ////////////////////////////////////////////
    //FUNCTION NAME: sortByUID                //
    //FUNCTION PURPOSE: Display list sorted by//
    //                  uid.                  //
    //                                        //
    //PARAMETERS: None.                       //
    //RETURNS: Void.                          //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/24/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:05/25/2018            //
    //MADE BY: Javier Rodriguez.              //
    ////////////////////////////////////////////
    public void sortByUID(){
        int [] order = new int[inmate.length];                  //Array to handle UIDs.
        int [] indexOrder = new int[inmate.length];             //Array to handle UIDs position.

        //Getting inmates UIDs.
        for(int i=0; i < inmate.length; i++)
            try{ order[i] = Integer.parseInt(inmate[i].getInmateUid());      //Initializing.
            } catch(NumberFormatException e){
                Toast.makeText(getApplicationContext(), "COULD NOT CONVERT UIDs", Toast.LENGTH_SHORT).show();
            }

        //Initializing.
        for(int i=0; i< inmate.length; i++)
            indexOrder[i] = i;

        //Bubble sort.
        bubbleSort(indexOrder, order);


        inmateList.clear();                             //Clearing list.
        for (int i = 0; i < indexOrder.length; i++)     //Adding items to list.
            inmateList.add(inmate[indexOrder[i]]);
        InmateLA.notifyDataSetChanged();                //Notifying change.
    }

    ////////////////////////////////////////////
    //FUNCTION NAME: bubbleSort               //
    //FUNCTION PURPOSE: Sort list.            //
    //                                        //
    //PARAMETERS: 1 - Integer Array.          //
    //            2 - Integer Array.          //
    //RETURNS: Void.                          //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/25/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    private void bubbleSort(int [] indexOrder, int [] order){
        boolean swap;                                           //Flag.
        int temp;                                               //Integer variable for temporary value.
        int indexTemp;                                          //Integer variable for temporary index.

        do{
            swap = false;
            for(int count = 0; count < (order.length - 1); count++){
                if(order[count] > order[count + 1]){
                    temp = order[count];
                    indexTemp = indexOrder[count];
                    indexOrder[count] = indexOrder[count+1];
                    indexOrder[count+1] = indexTemp;
                    order[count] = order[count+1];
                    order[count+1] = temp;
                    swap = true;
                }
            }
        } while(swap);
    }
}