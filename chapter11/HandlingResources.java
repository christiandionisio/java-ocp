import java.util.*;

public class HandlingResources {

    public static void main(String ...args) {

        Locale myloc = new Locale.Builder()
            .setLanguage("en")
            .setRegion("UK")
            .build();
        
        ResourceBundle msgs = ResourceBundle.getBundle("mymsgs", myloc);

        Enumeration<String> en = msgs.getKeys();
        while(en.hasMoreElements()) {
            String key = en.nextElement();
            String val = msgs.getString(key);
            System.out.println(key + " : " + val);
        }

    }

}