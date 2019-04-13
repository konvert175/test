/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ReaderPack;

import test.WriterPack.IWriter;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author User 
 */
public class UrlReader implements SomeReader {

    @Override
    public LinkedList<String> Read(String url,String regmask,IWriter Writer) 
    {
       LinkedList<String> ReturnList = new LinkedList<String>();
        String title="";
        // JSoup Example 2 - Reading HTML page from URL
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            title = doc.title();
            Writer.Write(doc.html(),"_______________________");
            //System.out.println(doc.getElementsMatchingOwnText("[а-я]").eachText());
            //System.out.println(doc.getElementsMatchingText("[а-я]"));
            String[] split;
            List<String> S = doc.getElementsMatchingOwnText("[а-я]").eachText();
           for (String S1 : S) {
                //System.out.println(S1);
                split = S1.split(regmask);
                ReturnList.addAll(Arrays.asList(split)); 
           }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("Jsoup Can read HTML page from URL, title : " + title);
        for (int i = 0; i < ReturnList.size(); i++) {
            System.out.println(String.valueOf(i)+"  " +ReturnList.get(i));
        }
        return ReturnList;
    }
    
}
