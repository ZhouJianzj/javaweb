package Listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @ClassName ListenerTwo
 * @Description TODO
 * @Author
 * @Date 2021/3/12
 **/
public class ListenerTwo implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        //监听变量的增加
        System.out.println("监听变量的增加");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        //监听变量的移除
        System.out.println("监听变量的移除");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        //监听变量的更新
        System.out.println("正在监听变量更新");
    }
}

