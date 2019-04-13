/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.WriterPack;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author User
 */
public class FileWriterM implements IWriter {

    @Override
    public void Write(String InputString, String NameOf) {
         try(FileWriter writer = new FileWriter("notes3.txt", false))
        {
           // запись всей строки
            writer.write(InputString);
            // запись по символам
             
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
    }
    
}
