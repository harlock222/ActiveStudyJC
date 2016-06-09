/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day11;

import com.activestudy.Utility.file.watchservice.WatchDirService;
import com.activestudy.Utility.file.watchservice.WatchEventAction;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;

/**
 *
 * @author Harlock
 */
public class TestASLib {
    public static void main(String[] args) throws IOException, InterruptedException {
        //tạo một object WatchDirService, theo dõi quá trình tạo file và xóa file
        final WatchDirService watchService = new WatchDirService(StandardWatchEventKinds.ENTRY_CREATE, 
                                                            StandardWatchEventKinds.ENTRY_DELETE,StandardWatchEventKinds.ENTRY_MODIFY
        );
        
        //đăng ký thư mục cần theo dõi, có thể đăng ký nhiều lần
        watchService.registerDir(Paths.get(".\\input\\"));
        
        //đăng ký hành động khi có file mới được tạo
        watchService.setOnCreatedAction(new WatchEventAction() {
            @Override
            public void doAction() {
                //lấy file vừa được tạo
                Path path = watchService.getCurrentFilePath();
                
                //in ra màn hình đường dẫn tuyệt đối của file
                System.out.println(path.toAbsolutePath().toString());
            }
        });
        
        //đăng ký hành động khi có file vừa bị xóa
        watchService.setOnDeletedAction(new WatchEventAction() {
            @Override
            public void doAction() {
                //lấy file vừa được tạo
                Path path = watchService.getCurrentFilePath();
                
                //in ra màn hình đường dẫn tuyệt đối của file
                System.out.println(path.toAbsolutePath().toString());
            }
        });
        
        //khởi động watch service
        watchService.run();
    }
}
