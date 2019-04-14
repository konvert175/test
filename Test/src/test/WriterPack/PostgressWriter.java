/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.WriterPack;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Класс - PostgressWriter
 * Содержит конструкторы + методы специально для БД Postgress.
 * В каждом конструкторе происходит инициализация соединения с БД и создание/пересоздание таблицы
 */
public class PostgressWriter extends DataBaseWriter {
     /** 
     * Конструктор,
     * Поля заполняем по умолчанию
     * Таблицу назовем - wordcount
     * @throws java.sql.SQLException
     */
    public PostgressWriter()throws SQLException
    {   
        ServerName = "jdbc:postgresql://127.0.0.1:5432/postgres";
        UserName = "postgres";
        UserPass = "1111";
        TableName="wordcount";
        Connect();
        replaceTable();
    }
     /** 
     * Конструктор,
     * Основные поля заполняем по умолчанию
     * @param TableName - название таблицы
     * @throws java.sql.SQLException
     */
    public PostgressWriter(String TableName)throws SQLException
    {   
        ServerName = "jdbc:postgresql://127.0.0.1:5432/postgres";
        UserName = "postgres";
        UserPass = "1111";
        this.TableName=TableName;
        Connect();
        replaceTable();
    }
     /** 
     * Конструктор,
     * ServerName заполняем по умолчанию
     * @param TableName - название таблицы
     * @param UserName - имя пользователя БД
     * @param UserPass - пароль пользователя БД
     * @throws java.sql.SQLException
     */
    public PostgressWriter(String UserName,String UserPass,String TableName)throws SQLException
    {
         this.UserName = UserName;
         this.UserPass = UserPass;
         this.TableName=TableName;
         ServerName = "jdbc:postgresql://127.0.0.1:5432/postgres";
         Connect();
         replaceTable();
    }
     /** 
     * Конструктор,
     * ServerName заполняем по умолчанию
     * @param TableName - название таблицы
     * @param UserName - имя пользователя БД
     * @param UserPass - пароль пользователя БД
     * @param ServerName - имя сервера БД
     * @param Port - порт, используемый для соединения с БД
     * @throws java.sql.SQLException
     */
    public PostgressWriter(String ServerName,String Port,String UserName,String UserPass,String TableName)throws SQLException
    {
        this(UserName,UserPass,TableName);
        this.ServerName="jdbc:"+ServerName+"://127.0.0.1:"+Port+"/postgres";
    }
    /**
     * Метод на выполнение
     * @deprecated 
     */
    @Override
    void ExecSome() 
    {
        Statement statement;
    }
    /**
     * Проверяет существование таблицы
     * @param  NameTable - название таблицы
     * @throws  SQLException
     */
    @Override
    public boolean IsTableExists(String NameTable) throws SQLException {
        String selectTableSQL = 
            "SELECT count(1) FROM information_schema.tables\n" +
            "where table_name = '"+NameTable.toLowerCase()+"';";
        //System.out.println(selectTableSQL);
        try 
        {
	Statement statement = connection.createStatement();
	ResultSet rs = statement.executeQuery(selectTableSQL);
	while (rs.next()) 
            {
                //System.out.println("TRUE "+rs.getString(1));
                if (rs.getString(1).equals("1"))
                    return true;       
            }
        }
        catch (SQLException e)
        {
            
            throw e;
        }
        //System.out.println("FALSE");
        return false;
     }
    /**
     * Создает таблицу
     * @param  NameTable - название таблицы
     * @throws java.sql.SQLException
     */
    @Override
    public void CreateTable(String NameTable) throws SQLException {
        Statement statement;
	String createTableSQL = 
                "create table "+NameTable+" ("+
                "id varchar(100),"+
                "word varchar(100),"+
                "coun varchar(100))";
	try 
        {
		statement = connection.createStatement();
                //System.out.println(TableName+" create 1");
		statement.execute(createTableSQL);
                //System.out.println(TableName+" create 2");
        }
        catch (SQLException e)
        {
            
            throw e;
        }
    }
    /**
     * Служебный метод - открывает соединение с БД, на основании параметров в конструкторе.
     * Вызывается из конструктора. 
     * @throws SQLException
     */
    private void Connect() throws SQLException
    { 
        try
        {
        connection = DriverManager.getConnection(ServerName, UserName, UserPass);
        }
        catch (SQLException e)
        {
            
            throw e;
        }
    }
     /**
     * Служебный метод - пересоздает таблицу, если она есть, иначе создает
     * Вызывается из метода Write. 
     * @throws SQLException
     */
    void replaceTable() throws SQLException
    {
        if (IsTableExists(TableName))
        {
            DropTable(TableName);
            //System.out.println(TableName+" has been deleted");
            CreateTable(TableName);
            //System.out.println(TableName+" has been created after deleting");
        }
        else
        {
            CreateTable(TableName);
            //System.out.println(TableName+" has been created");
        }
    }

}
