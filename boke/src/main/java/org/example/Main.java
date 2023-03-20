package org.example;

import lombok.Data;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.InputStream;

@Data

public class Main {


    public static void main(String[] args) {

        InputStream inputStream=Main.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        String statement="com.southwind.mapper.AccountMapper.save";
        Account account=new Account(5,"丘八","123456","女",20011108);
        sqlSession.insert(statement,account);
        sqlSession.commit();

    }
}