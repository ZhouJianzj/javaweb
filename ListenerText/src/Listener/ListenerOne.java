package Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName ListenerOne
 * @Description TODO
 * @Author
 * @Date 2021/3/12
 **/
public class ListenerOne implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        监听初始化作用域里面的变量
        System.out.println("数据共享初始化被监听");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("数据共享销毁被监听");
    }
}
