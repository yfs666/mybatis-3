package yfs.study;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import yfs.study.entity.GrazeUser;

import java.io.InputStream;

public class MyTest {
    public static void main(String[] args) {
        String resource = "conf.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        String statement = "yfs.study.mapper.GrazeUserMapper.get";//映射sql的标识字符串
        GrazeUser grazeUser = session.selectOne(statement, 1);
        System.out.println(grazeUser);
    }
}
