/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import test.WriterPack.DataBaseWriter;
import test.CounterPack.ICounter;
import test.CounterPack.Counter;
import test.ReaderPack.UrlReader;
import test.ReaderPack.SomeReader;
import test.WriterPack.*;
import java.util.*;
/**
 *
 * @author User
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SomeReader R = new UrlReader();      
        IWriter FileW = new FileWriterM();       

        
        System.out.println("Введите URL (по умолчанию будет подставлено https://simbirsoft.com)");
        Scanner in = new Scanner(System.in);
        String URL = in.nextLine();
        if (URL.equals(""))
            URL = "https://simbirsoft.com";
        System.out.println("Будет осуществлен подсчет слов со страницы "+URL);
        System.out.println("Введите предподчтительный способ вывода результат (пусто - на экран, иначе в таблицу, имя которой будет введено");
        String TableName = in.nextLine();
        
        LinkedList L = R.Read(URL," |\n|\\.|;|,|\\]|\\[|\\!|\\?|\t|\r|\"",FileW);
        ICounter C = new Counter();
        if (TableName.equals(""))
        {
            IWriter DBWriter = new ConsoleWriter();
            C.Count(L,DBWriter);
            
        }
        else
        {         
            DataBaseWriter DBWriter = new PostgressWriter(TableName);     
            C.Count(L,DBWriter);
            System.out.println("Результат сохранен в таблице"+TableName);
            DBWriter.CloseConnect();
        }
        
        //" |,|/.|!|?|\"|;|:|[|]|(|)|\n|\r|\t");
        /*for (int i = 0; i < L.size(); i++) {
            System.out.println(String.valueOf(i)+"  " +L.get(i));
        }*/
        
       // DBWriter.ExecSome();
        //System.out.println(DBWriter.IsTableExists("wordcount"));
        //DBWriter.Write("sdfgsgd", "wordcount");
         /*
        DBWriter.DropTable("Word685");
        System.out.println(DBWriter.IsTableExists("Word685"));
        DBWriter.CreateTable("Word685");
        System.out.println(DBWriter.IsTableExists("Word685"));
        */
        
    }
    
}
