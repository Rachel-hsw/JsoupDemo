package com.example.xzh;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by zhenghangxia on 17-5-8.
 */
public class JsoupTest {

    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect("http://www.jssvc.edu.cn/web_class.asp?ClassID=1&SpecialID=0&page=1").get();
            Element element = doc.getElementById("showNewsList");
            Elements elements = element.getElementsByTag("a");
            Elements elements1 = element.select("font");

//            System.out.println(elements1.text());

            for (Element e : elements) {
                String title = e.text();
                String address = e.attr("href");
                address = "http://www.jssvc.edu.cn/" + address;
                System.out.println(title + " ---> " + address);
            }
            for (Element e : elements1) {
                String time = e.text();
                System.out.println(time);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------->");

        try {
            Document doc = Jsoup.connect("http://www.jssvc.edu.cn/Show_content.asp?ArticleID=11256").get();
            Element element = doc.getElementById("showNewsContent");
            Elements elements = element.select("FONT");
            for (Element e : elements) {
                System.out.println(e.text());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
