/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ReaderPack;

import test.WriterPack.IWriter;
import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * Класс - первая попытка получить информацию с url.
 * В дальнейшем не используется
 * @deprecated 
 */
public class UrlSimpleReader implements SomeReader {

    @Override
    public LinkedList<String> Read(String url,String regmask,IWriter Writer) 
    {
       LinkedList<String> ReturnList = new LinkedList<String>();
        try
        {
        URL Url = new URL(url);
        BufferedReader br = new BufferedReader(new InputStreamReader(Url.openConnection().getInputStream()));           
                String s;
                while((s = br.readLine())!=null)
                {
                    //System.out.println(s);
                    /*String[] split;
                    split = url.split(regmask);
                    ReturnList.addAll(Arrays.asList(split)); */
                    ReturnList.add(s);
                }   
                
        //System.out.println(ReturnList.get(14790));
        }
        catch(MalformedURLException e)
        {
             System.out.println("MalformedURLException");
             Logger.getLogger(UrlSimpleReader.class.getName()).log(Level.SEVERE, null, "Заданная строка "+url+" "+e);   
        }
        catch (IOException ex) 
        { 
             Logger.getLogger(UrlSimpleReader.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (Exception e)
        {
            Logger.getLogger(UrlSimpleReader.class.getName()).log(Level.SEVERE, null, e);
        }
        return ReturnList;
        }
    
}
