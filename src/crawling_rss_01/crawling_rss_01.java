package crawling_rss_01;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Jonathan
 */
public class crawling_rss_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
        // TODO code application logic here
        URL url = new URL("http://m.tvb.com/news/latest/local/0");

        //File file = new File("C:\\Users\\Jonathan\\Desktop\\test2.mp4");
        System.out.println("Downloading");
        //FileUtils.copyURLToFile(url, file);
        System.out.println("Done");

        Document doc = Jsoup.connect("http://m.tvb.com/news/latest/local/0").get();
        Elements videolink = doc.select("video_android");

        System.out.println(doc.getElementsByAttributeValue("bitrate", "300k").select("video_android").eachAttr("url").size());
        int arraysize = doc.getElementsByAttributeValue("bitrate", "300k").select("video_android").eachAttr("url").size();
        
        
        
                
            
        for (int i = 0; i < arraysize; i++) {
            
            if (doc.getElementsByAttributeValue("bitrate", "300k").select("video_android").eachAttr("url").get(i).contains("cht"))
            {
            System.out.println(doc.getElementsByAttributeValue("bitrate", "300k").select("video_android").eachAttr("url").get(i));
            String test1 = doc.getElementsByAttributeValue("bitrate", "300k").select("video_android").eachAttr("url").get(i);
            
            System.out.println(doc.select("item").eachAttr("id").get(i));
           System.out.println(i);
 try {

                String line;
                String test = "ffmpeg -i " + test1 + " -bsf:a aac_adtstoasc -vcodec copy -c copy -crf 50 C:\\Users\\Jonathan\\Downloads\\file"+i+".mp4";
                Process p = Runtime.getRuntime().exec("cmd.exe /c start c:\\ffmpeg\\bin\\" + test);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(p.getErrorStream()));

                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }

                p.waitFor();
                System.out.println("Video downloaded successfully!");
                in.close();
            } catch (IOException | InterruptedException e) {
                //LOG.log(Level.SEVERE, null, e);
                e.printStackTrace();
            }
           
            }
            
            
                /*download mp4
            try {

                String line;
                String test = "ffmpeg -i " + test1 + " -bsf:a aac_adtstoasc -vcodec copy -c copy -crf 50 C:\\Users\\Jonathan\\Downloads\\file"+i+".mp4";
                Process p = Runtime.getRuntime().exec("cmd.exe /c start c:\\ffmpeg\\bin\\" + test);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(p.getErrorStream()));

                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }

                p.waitFor();
                System.out.println("Video downloaded successfully!");
                in.close();
            } catch (IOException | InterruptedException e) {
                //LOG.log(Level.SEVERE, null, e);
                e.printStackTrace();
            }
*/
        }

        List<String> ar1 = doc.getElementsByAttributeValue("bitrate", "300k").select("video_android").eachAttr("url");

        int test = 0;
        int count = 0;
        while (true) {
            Thread.sleep(1000);
            String[] list = {"apple", "rat", "bear"};
            String[] checked = {"rat", "bear", "cat",};

            ArrayList<String> ar = new ArrayList<String>();
            for (int i = 0; i < list.length; i++) {
                if (!Arrays.asList(checked).contains(list[i])) {
                    ar.add(list[i]);
                    count++;
                    System.out.println("found " + count + " " + list[i]);
                }

            }

        }
    }
}

/*
        while ((line = in.readLine()) != null) {
            int titleEndIndex = 0;
            int titleStartIndex = 0;
            while (titleStartIndex >= 0) {
                titleStartIndex = line.indexOf("<title>", titleEndIndex);
                if (titleStartIndex >= 0) {
                    titleEndIndex = line.indexOf("</title>", titleStartIndex);
                    sourceCode += line.substring(titleStartIndex + "<title>".length(), titleEndIndex) + "\n";
                    System.out.println(sourceCode);
                }
            }
        }
        in.close();
 */

 /*
    public static String readRSSFeed(String urlAddress) {
        try {
            URL rssUrl = new URL(urlAddress);
            BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
            String sourceCode = "";
            String line;
            while ((line = in.readLine()) != null) {
                int titleEndIndex = 0;
                int titleStartIndex = 0;
                while (titleStartIndex >= 0) {
                    titleStartIndex = line.indexOf("<title>", titleEndIndex);
                    if (titleStartIndex >= 0) {
                        titleEndIndex = line.indexOf("</title>", titleStartIndex);
                        sourceCode += line.substring(titleStartIndex + "<title>".length(), titleEndIndex) + "\n";
                    }
                }
            }
            in.close();
            return sourceCode;
        } catch (MalformedURLException ue) {
            System.out.println("Malformed URL");
        } catch (IOException ioe) {
            System.out.println("Something went wrong reading the contents");
        }
        return null;
    }
 */
