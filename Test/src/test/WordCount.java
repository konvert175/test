/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/** 
 * Класс Слово с полями <b>word</b> и <b>count</b>.
 * @autor Андрей
 * @version 1
*/
public class WordCount {
    /** Поле слово */
    private String word;
    /** Поле количество вхождений слова */
    private int count;
    /** 
     * Конструктор - создание нового объекта,
     * count принимаем по умолчанию равным 1
     * @param word - слово
     * @see WordCount#WordCount()
     */
    public WordCount(String word)
    {
        this.word = word;
        count=1;
        System.out.print(word+" ");
 //       if (word.endsWith(" "))
 //           System.out.println("ПРОБЕЛЫ ТОЖЕ ПОПАДАЮТ");
    }
    /**
     * Увеличивает число вхождений слова {@link WordCount#word}
     */
    public void IncrementCountByWord()
    {
        count++;
    }
    /**
     * Возвращает слово и кол-во его вхождений, для вывода пользователю{@link WordCount#word}
     * @return  String
     */
    public String GetWordAndCountToString()
    {
        return word +" "+ String.valueOf(count);
    }
    /**
     * Возвращает слово {@link WordCount#word}
     * @return  String
     */
    public String GetWord()
    {
        return word;
    }
}
