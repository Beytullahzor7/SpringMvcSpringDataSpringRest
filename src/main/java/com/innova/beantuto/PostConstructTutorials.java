package com.innova.beantuto;

import lombok.Data;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Data
@ToString
public class PostConstructTutorials {

    @Autowired
    Logger logger;

    @PostConstruct
    public void init(){
        logger.info("@PostContructor");
    }

//    public PostConstructTutorials() {
//        logger.info("Bu yazdırılmayacak logger hala bos");
//        //NullPointerException will be thrown here
//    }

    public static void main(String[] args) {
        PostConstructTutorials post = new PostConstructTutorials();
        System.out.println(post);
    }
}
