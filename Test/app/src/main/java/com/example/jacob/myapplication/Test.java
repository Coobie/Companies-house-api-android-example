package com.example.jacob.myapplication;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

public class Test {

    public Test(){}


    @RequiresApi(api = Build.VERSION_CODES.O)
    public String tester() throws IOException {
        String address = "https://api.companieshouse.gov.uk/search?q=test";
        String username = ""; //REPLACE WITH API KEY
        String password = "";
        URL url = new URL(address);
        URLConnection conn = url.openConnection();
        conn.setConnectTimeout(30000); // 30 seconds time out

        //if (username != null && password != null){
        String user_pass = username + ":" + password;
        //String encoded = user_pass.getBytes() );
        conn.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString(user_pass.getBytes()));
        //}

        String line = "";
        StringBuffer sb = new StringBuffer();
        BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()) );
        while((line = input.readLine()) != null)
            sb.append(line + "\n");
        input.close();
        return sb.toString();
    }


}
