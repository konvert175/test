/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.WriterPack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Класс - DataBaseWriter
 * Содержит поля + методы "которые для всех БД одинаковые" (удаление таблицы, вставка в таблицу)
 */
public abstract class DataBaseWriter implements IWriter {
    /** Поле название сервера */
    String ServerName;
    /** Поле имя пользователя БД */
    String UserName;
    /** Поле пароль пользователя */
    String UserPass;
    /** Поле название таблицы */
    String TableName;
    Connection connection;
    /**
     * Метод на выполнение
     * @deprecated 
     */
    abstract void ExecSome();
    /**
     * Проверяет существование таблицы
     * @param  NameTable - название таблицы
     */
    public abstract boolean IsTableExists(String NameTable)throws SQLException;
    /**
     * Создает таблицу
     * @param  NameTable - название таблицы
     */
    public abstract void CreateTable(String NameTable)throws SQLException;
    /**
     * Получает одну строку из БД на основании SQL запроса
     * @deprecated 
     */
    String GetOneRowBySQL(String SQL) 
    { 
        return "";
    }
    /**
     * Сохраняет строку в таблицу БД, указанную в поле NameOf
     * @param InputString - строка, которую нужно сохранить
     * @param NameOf - название таблицы
     * @deprecated 
     */    
    @Override
    public void Write(String InputString, String NameOf)
    {
        Statement statement;
	String SQL = 
                "insert into "+NameOf+" values (-1,'"+InputString+"',-1)";
        System.out.print(SQL);
	try 
        {
		statement = connection.createStatement();
		statement.execute(SQL);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
     /**
     * Сохраняет строку в таблицу БД, указанную при создании объекта (в конструкторе)
     * @param InputString - строка, которую нужно сохранить
     */
    @Override
    public void Write(String InputString) {
        Statement statement;
        String[] S = InputString.split(" ");
        
	String SQL = 
                "insert into "+TableName+"(id,word,coun) values(?,?,?);";
        //System.out.print(SQL);
	try 
        {
                PreparedStatement stmt = connection.prepareStatement(SQL);
                statement = connection.createStatement();
                /*
                for (int i=0;i<S.length;i++)
                {
                    stmt.setString(i+1, S[i]);
                }*/
                stmt.setString(1, S[0]);
                stmt.setString(2, S[1]);
                stmt.setString(3, S[2]);
		//statement.execute(SQL);
                stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
     /**
     * Закрыть соединение с БД
     */
    public void CloseConnect()
    {
        try 
        {
        connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
     /**
     * Удаляем таблицу
     * @param TableName - название таблицы под удаление
     * @throws SQLException
     */
    public void DropTable(String TableName) throws SQLException
    {
        Statement statement;
	String createTableSQL = 
                "drop table "+TableName;
	try 
        {
		statement = connection.createStatement();
		statement.execute(createTableSQL);
        }
        catch (SQLException e)
        {
            throw e;
        }    
    }
}
