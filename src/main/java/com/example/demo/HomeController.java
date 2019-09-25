package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homePage(){
        return "list";
    }

    @RequestMapping("/amethyst")
    public String listAmethyst(){
        return "amethyst";
    }

    @RequestMapping("/rose-quartz")
    public String listRoseQuartz(){
        return "rose-quartz";
    }

    @RequestMapping("/herkimer")
    public String listHerkimer() {
        return "herkimer";
    }

    @RequestMapping("/selenite")
    public String listSelenite()
    {
        return "selenite";
    }

    @RequestMapping("/suggestions")
    public String suggestions() {
        return "suggestions";
    }

    // testForDupes
    @PostMapping("/dupe")
    public boolean postThis(){
        //final URL url = new URL("http://some.where/file.html");
//        url.openConnection().getResponseCode();
        // testForDupes(urlStr);
        boolean fileExists = false;
        String urlStr = "https://res.cloudinary.com/ascension-enterprises/image/upload/v1569270776/samples/Java%20Boot%20Camp/6fy5iab9_pxd3rp.bmp";

        fileExists = testForDupes(urlStr);
        if(fileExists){
            System.out.println("Web File Exists");
            return true;
        } else {
            System.out.println("Web File Does NOT Exist");
        }
        return false;
    }

    public boolean testForDupes(String urlStr){
        try {
            final URL url = new URL(urlStr);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            int responseCode = huc.getResponseCode();
            System.out.println("Response Code: "+ responseCode);
            if (!(responseCode == 200)) {
                return false;
            }
            // Handle response code here...
        } catch (UnknownHostException uhe) {
            // Handle exceptions as necessary
            // log exception
            System.out.println(uhe.getMessage().toString());
            return false;
        } catch (FileNotFoundException fnfe) {
            // Handle exceptions as necessary
            System.out.println(fnfe.getMessage().toString());
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
            // Handle exceptions as necessary
            // log exception
            return false;
        }
        return true;
    }
}
