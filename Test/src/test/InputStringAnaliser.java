/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/** 
 * Класс InputStringAnaliser - реализует логику контроля за вводимыми пользователем даннымим
 * @autor Андрей
 * @version 1
*/
public class InputStringAnaliser {
/** 
 * AnaliseUrl - реализует логику контроля за вводимыми пользователем даннымим
 * @param InputStr - анализируемая строка
 * @return String - возвращается введенная строка или строкаа по умолчанию и сообщение в консоль
*/
    public static String AnaliseUrl(String InputStr)
    {
        if ((InputStr.indexOf("http://")+InputStr.indexOf("https://")>0)
              && InputStr.indexOf(".")>0  )
            return InputStr;
        else
            System.out.println("Введенная строка неккоректна (ожидалось наличие строки с http://, https:// и точкой), будет выполнен анализ по строке 'по умолчанию'");
        return "https://simbirsoft.com";
    }
/** 
 * AnaliseTableName - реализует логику контроля за вводимыми пользователем даннымим
 * @param InputStr - анализируемая строка
 * @return String - возвращается введенная строка или строкаа по умолчанию и сообщение в консоль
*/
    public static String AnaliseTableName(String InputStr)
    {
        if (InputStr.matches("[a-z]*"))
        return InputStr;
        else
            System.out.println("Введенная строка неккоректна (ожидалась одно слово без пробелов и небуквенных символов), результат будет сохранен в таблицу WordCount");
        return "WordCount";
    }
}
