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
        // TODO code application logic here
        //SomeReader R = new TestReader();
        SomeReader R = new UrlReader();
        IWriter FileW = new FileWriterM();
        DataBaseWriter DBWriter = new PostgressWriter("Wor");
        LinkedList L = R.Read("https://simbirsoft.com",//" |\n|/.");
        //LinkedList L = R.Read("https://ru.wikipedia.org/wiki/Java",
        " |\n|\\.|;|,|\\]|\\[|\\!|\\?|\t|\r|\"",FileW);
        //" |,|/.|!|?|\"|;|:|[|]|(|)|\n|\r|\t");
        /*for (int i = 0; i < L.size(); i++) {
            System.out.println(String.valueOf(i)+"  " +L.get(i));
        }*/
        ICounter C ;
        C = new Counter();
        C.Count(L,DBWriter);
       // DBWriter.ExecSome();
        //System.out.println(DBWriter.IsTableExists("wordcount"));
        //DBWriter.Write("sdfgsgd", "wordcount");
         /*
        DBWriter.DropTable("Word685");
        System.out.println(DBWriter.IsTableExists("Word685"));
        DBWriter.CreateTable("Word685");
        System.out.println(DBWriter.IsTableExists("Word685"));
        */
        DBWriter.CloseConnect();
    }
    
}
