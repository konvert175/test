/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class TestReader implements SomeReader{
    @Override
    public LinkedList<String> Read(String url,String regmask) 
    {
        if ("".equals(url))
        {
        url = "Необходимо учесть, что размер скачанной web-страницы может\n" +
"превышать размер доступной ОЗУ. В случае, если файл больше\n" +
"объема оперативной памяти, подсчет количества слов должен\n" +
"осуществляться корректно;\n" +
"а если не корректно, то необходимо учесть, что это не зачтут;\n" +                
"2. В программе необходимо предусмотреть обработку нештатных\n" +
"2. В программе необходимо предусмотреть обработку нештатных\n" +
"ОЗУ ОЗУ ОЗУ ОЗУ ОЗУ ОЗУ ОЗУ ОЗУ "+
"ситуаций;";
        }
        LinkedList<String> ReturnList = new LinkedList<String>();
        String[] split;
        //split = S.split(" |\n");
        split = url.split(regmask);
        ReturnList.addAll(Arrays.asList(split));        
        return ReturnList;
    }
}
