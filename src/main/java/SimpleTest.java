import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author aqian
 * @description
 * @date 2023/3/27 12:26:00
 */
public class SimpleTest {
  public static void main(String[] args) throws IOException {
    String resource = "my/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    //创建SqlSessionFacory
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    /******************************分割线******************************/
    SqlSession sqlSession = sqlSessionFactory.openSession();
    Object mapper = sqlSession.getMapper(Object.class);
    //获取Mapper
    //UserDao mapper = sqlSession.getMapper(UserDao.class);
    //System.out.println(mapper.queryById(1L));
    sqlSession.close();
    sqlSession.commit();
  }
}
