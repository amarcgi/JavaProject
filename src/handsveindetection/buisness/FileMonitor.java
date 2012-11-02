/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handsveindetection.buisness;

/**
 *
 * @author Amar
 */
import java.util.*;
import java.io.File;
import java.io.FilenameFilter;
public class FileMonitor
{
   static Timer timer;
   public static void  startFileMonitor(final String dir,final String filext){
 	 timer= new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				File file= new File(dir);
			
				file.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
							String fileNameList[] = dir.list();
							if(fileNameList !=null && fileNameList.length>0){
								for(String fileName:fileNameList){
									if(fileName.endsWith(filext)){
										System.out.println("fileName file found");
										return true;
									}
								}
							}
					
					
						return true;
					}
				});
			}
		}, 2000,2000);
    }
   
   
    public static void  stopFileMonitor(){
        timer.cancel();
    }
}

