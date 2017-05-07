package com.gasmek.androidfilerwsample;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by HARUN KOR on 07.05.2017.
 */

public class FileReadWrite {

    private Context context;
    private int CommandValue;
    private TextView textView;

    public FileReadWrite(Context context,int CommandValue, TextView textView ) // 1 read  - 2 write
    {
        this.context=context;
        this.CommandValue=CommandValue;
        this.textView=textView;


        if(CommandValue ==1)
        {


            textView.setText(""+ readToFile());
           // Toast.makeText(context, ""+ readToFile(), Toast.LENGTH_SHORT).show();
        }else
        {
            textView.setText( ""+ writeToFile("data description"));
          //  Toast.makeText(context, ""+ writeToFile("data description"), Toast.LENGTH_SHORT).show();
        }
    }





    private boolean writeToFile(String data)
    {
        boolean write= false;

        try {
            OutputStreamWriter outputStreamWriter= new OutputStreamWriter(context.openFileOutput("harun.txt",Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();

            write= true;


        }catch (IOException e )
        {
            write=false;
        }

        return  write;
    }



    private String readToFile()
    {
        String ret="";

        try
        {
            AssetManager assetManager= context.getAssets();
            InputStream inInputStream = assetManager.open("mevlut.txt");                               //  context.openFileInput("harun.txt");
            if(inInputStream != null)
            {
                InputStreamReader inpuInputStreamReader = new InputStreamReader(inInputStream);
                BufferedReader  bufferedReader= new BufferedReader(inpuInputStreamReader);
                String receiveString="";
                StringBuilder stringBuilder=new StringBuilder();
                while((receiveString= bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(receiveString);
                }
                inInputStream.close();
                ret=stringBuilder.toString();

            }


        }catch (FileNotFoundException e)
        {

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }





}


