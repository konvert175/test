/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 * Класс реализующий вывод в консоль
 * @author User
 */
public class ConsoleWriter implements IWriter{

    /**
     * Метод выводщий строку в консоль
     * @param InputString - выводимая строка
     * @param FirstRow - первая выводимая строка
     */
    @Override
    public void Write(String InputString, String FirstRow) {
        System.out.println(FirstRow);
        System.out.println(InputString);
    }
    
}
