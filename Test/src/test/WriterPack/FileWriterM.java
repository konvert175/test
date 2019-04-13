/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.WriterPack;

import java.io.FileWriter;
import java.io.IOException;

/** 
 * Класс FileWriterM - сохраняет полученную строку в файл
 * имеет несколько конструкторов
 * @autor Андрей
 * @version 1
*/
public class FileWriterM implements IWriter {

    /** Поле Имя файла */
    private String filename;
    /** Поле Расширение файла */
    private String extention;
    /** 
     * Конструктор - по умолчанию,
     * extention принимаем по умолчанию равным "html"
     * filename принимаем по умолчанию равым "url"
     */
    public FileWriterM()
    {
        this.filename = "url";
        this.extention = "html";
    }
    /** 
     * Конструктор,
     * extention принимаем по умолчанию равным "html"
     * @param filename - имя файла
     */
    public FileWriterM(String filename )
    {
        this.filename = filename;
        this.extention = "html";
    }
    /**
     * Сохраняет строку в файл, если такой файл уже есть - перепишем его
     */
    @Override
    public void Write(String InputString, String NameOf) {
        try(FileWriter writer = new FileWriter(filename+"."+extention, false))
        {
            writer.write(InputString);         
            writer.flush();
        }
        catch(IOException ex){
             
            ex.printStackTrace();
        } 
    }
    /**
     * Сохраняет строку в файл, если такой файл уже есть - перепишем его
     */
    @Override
    public void Write(String InputString) {
        try(FileWriter writer = new FileWriter(filename+"."+extention, false))
        {
            writer.write(InputString);         
            writer.flush();
        }
        catch(IOException ex){
             
            ex.printStackTrace();
        } 
    }
    
}
