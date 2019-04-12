/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.LinkedList;

/**
 * Интерфейс - SomeReader
 * Классы реализующие его выполняют чтение информации откуда-либо
 * 
 */
public interface SomeReader {
    /**
     * Возвращает список, содержащий все слова на странице
     * @param url - строка для получения данных (адрес страницы, имя бд итп)
     * @param  RegMask - регулярное выражение для разделения
     * @param  Writer - класс писатель
     * @return LinkedList - возвращает LinkedList, содержащий слова со страницы разделенные согласно RegMask
     */
    public LinkedList<String> Read(String url,String RegMask,IWriter Writer);  
}
