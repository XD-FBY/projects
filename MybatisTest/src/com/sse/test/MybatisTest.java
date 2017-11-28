package com.sse.test;

import com.sse.model.Employeer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.ibatis.io.Resources;
import java.io.Reader;


/**
 * Created by Administrator on 2017/11/28.
 */
public class MybatisTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void findEmployeerById(int employeer_id) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            Employeer employeer = (Employeer) session.selectOne(
                    "com.sse.model.EmployeerMapper.findEmployeerByID", employeer_id);
            if (employeer == null)
                System.out.println("null");
            else{
                System.out.println(employeer.getEmloyeer_id());
                System.out.println(employeer);}
        } finally {
            session.close();
        }
    }
    public static void addEmployeer(Employeer employeer){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            //返回值是记录条数
            int resultCount = session.insert("com.sse.model.EmployeerMapper.addEmployeer", employeer );
            System.out.printf("当前插入的employeer_id :%d    当前插入数据库中条数:%d " , employeer.getEmloyeer_id() ,resultCount);  //获取插入对象的id
            System.out.println("");
            session.commit() ;
        } finally {
            session.close();
        }
    }
    public static void deleteEmployeer(int id){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            //返回值是记录条数
            int resultCount=session.delete("com.sse.model.EmployeerMapper.deleteEmployeer",id);
            System.out.println("当前删除数据库中条数: "+resultCount);  //获取插入对象的id
            session.commit() ;
        } finally {
            session.close();
        }
    }
    public static void updateEmployeer(Employeer employeer){
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            session.update("com.sse.model.EmployeerMapper.updateEmployeer",employeer);
            session.commit() ;
        } finally {
            session.close();
        }
    }
    public static void main(String[] args){
        Employeer employeer1=new Employeer();
        employeer1.setEmployeer_name("李四");
        employeer1.setEmployeer_age(23);
        employeer1.setEmployeer_department("产品一部");
        employeer1.setEmployeer_worktype("开发工程师");

        Employeer employeer2=new Employeer();
        employeer2.setEmployeer_name("张三");
        employeer2.setEmployeer_age(30);
        employeer2.setEmployeer_department("产品二部");
        employeer2.setEmployeer_worktype("测试工程师");

        Employeer employeer3=new Employeer();
        employeer3.setEmployeer_name("小王");
        employeer3.setEmployeer_age(22);
        employeer3.setEmployeer_department("产品三部");
        employeer3.setEmployeer_worktype("数据分析师");


        Employeer employeer4=new Employeer();
        employeer4.setEmployeer_name("明明");
        employeer4.setEmployeer_age(22);
        employeer4.setEmployeer_department("财会部");
        employeer4.setEmployeer_worktype("财务人员");
        addEmployeer(employeer1);
        addEmployeer(employeer2);
        addEmployeer(employeer3);
        addEmployeer(employeer4);
    }
}
