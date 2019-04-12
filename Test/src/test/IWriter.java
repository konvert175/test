/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/** 
 * Интерфейс ICounter - подразумевается, что классов "Писателей", реализующих этот интерфейс
 * мб несколько (например в файл, на консоль, в бд)
 * @autor Андрей
 * @version 1
*/
public interface IWriter {
     /**
     * Получает данные в строковой форме - сохраняет в зависимости от типа класса-наследника
     * @param InputString - входная строка, которую необходимо сохранить
     * @param NameOf - имя для приемника (файл, бд, первая строка при выводе в консоль)
     */
    public void Write(String InputString,String NameOf);
    
}
