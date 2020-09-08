import com.pojo.Books;
import com.service.BookServiceImpl;
import com.service.Bookservice;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Mytext {
    @Test
    public  void  test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bookservice bookServiceImpl = (Bookservice) context.getBean("BookServiceImpl");
        for (Books books : bookServiceImpl.queryAllBook()) {
            System.out.println(books);
        }

        }
    }

