package Lesson_1;

import javafx.scene.Camera;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
//        CameraImp cameraImp = new CameraImp();
//        ICameraRoll cameraRoll = new ColorCameraRoll();
//        cameraImp.setCameraRoll(cameraRoll);
       // cameraImp.doPhotograph();
//        Assistant assistant = new Assistant();
//        CameraImp cameraImp = assistant.getCamera();
//        cameraImp.doPhotograph();

//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//        ICamera camera = context.getBean("camera", ICamera.class);
//        camera.doPhotograph();

//
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        ICamera camera = context.getBean("camera", ICamera.class);
//        camera.doPhotograph();

//        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
//        Registry registry = context.getBean("Registry",Registry.class );
//        registry.issue_direction();

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplateDiskDao jdbc = context.getBean("JdbcTemplate", JdbcTemplateDiskDao.class);
        Disk disk = new Disk();
        disk.setTitle("test1");
        disk.setId(1L);
        jdbc.insert(disk);

//          ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//          HelloMan hm = context.getBean("helloman", HelloMan.class);
//         // hm.setName("Vaska");
//          hm.helloSay();
    }
}
