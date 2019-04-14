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
 * Основной класс для чтения информации из url
 */
public class UrlReader implements SomeReader {
    /**
     * Возвращает список, содержащий все слова на странице
     * @param url - строка для получения данных (адрес страницы, имя бд итп)
     * @param  RegMask - регулярное выражение для разделения
     * @param  Writer - класс писатель
     * @return LinkedList - возвращает LinkedList, содержащий слова со страницы разделенные согласно RegMask
     */ 
    @Override
    public LinkedList<String> Read(String url,String regmask,IWriter Writer) 
    {
        //grabAllMemory();
        
        LinkedList<String> ReturnList = new LinkedList<String>();
        Document doc;
        try    
        {
            doc = Jsoup.connect(url).get();             
            Writer.Write(doc.html());
            String[] split;
            List<String> S = doc.getElementsMatchingOwnText("[а-я]").eachText();
            for (String S1 : S) {;
                split = S1.split(regmask);
                ReturnList.addAll(Arrays.asList(split)); 
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        catch (java.lang.OutOfMemoryError e)
        {
            System.out.println("поймали OutOfMemoryError  "+e.getMessage());
            //ошибка не отлавливается
            //Совершенно не понимаю - как можно обработать закончившеюся оперативную память
        }
        /*
        for (int i = 0; i < ReturnList.size(); i++) {
            System.out.println(String.valueOf(i)+"  " +ReturnList.get(i));
        }*/
        return ReturnList;
    }
     /**
     * метод для тестирования ситуации - когда консилась оперативная память
     */ 
    private void grabAllMemory() {
    List<Object[]> arrays = new LinkedList<>();
    for (; ; ) {
      arrays.add(new Object[100]);
    }
  }
    
}
