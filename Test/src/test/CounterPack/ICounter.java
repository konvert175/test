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
 * Интерфейс ICounter - подразумевается, что классов "Считателей", реализующих этот интерфейс
 * мб несколько (например считать можно средствами БД)
 * @autor Андрей
 * @version 1
*/
public interface ICounter {
    /**
     * Подсчитаывает кол-во вхождений слова на странице
     * @param LinkedList - список всех слов с страницы, разделенных согласно правилам
     * @param IWriter - класс писатель, определяющий куда вывести результат
     * @return ArrayList - возвращает ArrayList, содержащий структуру WordCount
     */
    public ArrayList<WordCount> Count(LinkedList<String> InputList,IWriter WriteT);  
}
