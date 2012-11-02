/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handsveindetection.db;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 *
 * @author Amar
 */
public class HandsVeinDBInstantiate {
    static HandsVeinDao handsVeinDao=null;
    public static HandsVeinDao getHandsVeinDao(){
        if(handsVeinDao==null){
            BeanFactory beans = new XmlBeanFactory(new FileSystemResource("C:\\Users\\Amar\\Documents\\NetBeansProjects\\HandsVeinDetection\\src\\handsveindetection\\file\\handsveinbean.xml"));
            handsVeinDao      =(HandsVeinDao) beans.getBean("handsVeinDaoImpl");
            return handsVeinDao;
        }
        return handsVeinDao;
    }
}
