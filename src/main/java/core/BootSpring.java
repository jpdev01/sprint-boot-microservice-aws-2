package core;

import core.translations.i18n.I18nUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BootSpring implements CommandLineRunner {

    @Autowired
    private FixDatabase fixDatabase;

    public static void main(String[] args)
    {
        SpringApplication.run(BootSpring.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // pega os parametros do aplicativo (com -D)
        if(Boolean.valueOf(System.getProperty("populateDatabaseTest")))
        {
            //fixDatabase.run();
        }
     }
}
