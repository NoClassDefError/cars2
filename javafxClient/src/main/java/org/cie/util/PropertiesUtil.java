package org.cie.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil extends Properties {

    public PropertiesUtil() {
        super();
        try {
            //FileInputStream fileInputStream = new FileInputStream("/db.properties");
            InputStream fileInputStream =
                    this.getClass().getResourceAsStream("/db.properties");
            super.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
