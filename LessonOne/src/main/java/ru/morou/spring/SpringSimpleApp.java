package ru.morou.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassPathXmlApplicationContext – это часть Spring контейнера, и ищет контекстное описание (applicationContext.xml)
 * в Java VM CLASSPATH и создает из него экземпляр ApplicationContext. Spring контейнер связывает бины в ходе
 * иницилизации ApplicationContext.
 */

public class SpringSimpleApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml");

        SimpleBean simpleBean = context.getBean ("simpleBean", SimpleBean.class);
        simpleBean.setData ("java");
        System.out.println (simpleBean.getData ());

        context.close();
    }
}
