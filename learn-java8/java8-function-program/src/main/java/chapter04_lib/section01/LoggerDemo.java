package chapter04_lib.section01;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerDemo {
    Logger logger = LoggerFactory.getLogger(LoggerDemo.class);

    public void old(){
        if(logger.isDebugEnabled()){
            logger.debug("Look at this : ");
        }
    }


}
