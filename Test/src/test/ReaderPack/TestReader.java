/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ReaderPack;

import test.WriterPack.IWriter;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * Тестовый класс, для отладки.
 * В дальнейшем не используется
 * @deprecated 
 */
public class TestReader implements SomeReader{
    @Override
    public LinkedList<String> Read(String url,String regmask,IWriter Writer) 
    {

        url = "Необходимо учесть, что размер скачанной web-страницы может\n" +
"превышать [размер ] доступной ОЗУ . В случае, если файл больше\n" +
"превышать [размер] доступной ОЗУ.В;случае;если]файл больше\n" +              
" объема [оперативной] памяти, подсчет количества слов должен\n" +
" осуществляться корректно;\n" +
" как это сделать?как это сделать?как это ;сделать? \n" +                
" 2. В программе необходимо предусмотреть обработку нештатных\n" +
" 2. В программе необходимо предусмотреть обработку нештатных\n" +
" ОЗУ ОЗУ ОЗУ ОЗУ,ОЗУ ОЗУ ОЗУ ОЗУ "+
" ситуаций;";
        
        LinkedList<String> ReturnList = new LinkedList<>();
        String[] split;
        //split = S.split(" |\n");
        split = url.split(regmask);
        ReturnList.addAll(Arrays.asList(split));
        Writer.Write(url);        
        return ReturnList;
    }
}
