/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.CounterPack;

import java.util.ArrayList;
import java.util.LinkedList;
import test.WriterPack.IWriter;

/**
 *  Отвечает за подсчет кол-ва элементов в списке
 */
public class Counter implements ICounter {

    @Override
    /**
     * Реализует подсчет кол-ва элементов в списке
     * @return  ArrayList
     * @param IWriter - класс писатель, определяющий куда вывести результат
     * @param LinkedList
     */
    public ArrayList<WordCount> Count(LinkedList<String> InputList,IWriter WriteTo) {
        ArrayList<String> A;
        ArrayList<WordCount> ReturnArrayList;
        ReturnArrayList = new ArrayList<>();
        A = new ArrayList<>();
        for (String S : InputList)
        {
            if (A.contains(S))
            {
                for (WordCount W : ReturnArrayList)
                    if (W.GetWord().equals(S))
                        W.IncrementCountByWord();
            }
            else 
            {
                A.add(S);
                WordCount NewWord = new WordCount(S);
                ReturnArrayList.add(NewWord);
            }
        }
        ReturnArrayList.forEach((W) -> {
            WriteTo.Write(W.GetWordAndCountToString());
        });
        return ReturnArrayList;
    }
    
}
