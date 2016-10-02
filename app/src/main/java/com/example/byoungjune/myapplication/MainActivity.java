package com.example.byoungjune.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


    public abstract class Myvalues {

        public  void getResult(int a) {

           int a1 = a;
            Toast.makeText(getApplicationContext(),"Result : " + a1, Toast.LENGTH_LONG).show();

        }

    }

    class MyAverage extends Myvalues {

public void getResult(int a , int b, int c){
    int a1 =a;
    int b2 =b;
    int c3 =c;
    int d = (a1 + b2 + c3)/3;
    Toast.makeText(getApplicationContext(),"AVG : "+d, Toast.LENGTH_LONG).show();
}
        public void getResult(int b[]){
            int a[] = b;
            int sum = 0;

            for(int i =0;i< a.length;i++){
                sum += a[i];
            }

            int d = sum/a.length;
            Toast.makeText(getApplicationContext(),"AVG : "+d, Toast.LENGTH_LONG).show();
        }


    }

    class Myminimum extends Myvalues {

        public void getResult(int b[]){
            int a[] = b;
            //int a[] = new int[]{4,2,5,1,3};

            for(int i = 0 ; i <a.length-1; i++) {
                for (int j = i + 1; j < a.length; j++) {

                    if (a[i] > a[j]) {
                        int tmp = a[j];
                        a[j] = a[i];
                        a[i] = tmp;
                    }
                }
            }
            Toast.makeText(getApplicationContext(), "Min : " + a[0], Toast.LENGTH_LONG).show();
        }


    }


    public void ClickBtn1(View v) {

        Myminimum m = new Myminimum();
        int a[] = new int[]{4,2,5,0,3};
        m.getResult(a);

    }
    public void ClickBtn2(View v) {

        MyAverage m = new MyAverage();
        int a[] = new int[]{1,2,3,4,5};
        m.getResult(a);

    }

}
