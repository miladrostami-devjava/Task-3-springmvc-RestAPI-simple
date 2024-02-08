package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
//todo: step3: add intended metadata

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        //todo: step5: add packages to project{controller ... service}

        //todo: step4: add intended code for run my app
        SpringApplication.run(App.class,args);
        System.out.println( "Hello World!" );
    }
}
