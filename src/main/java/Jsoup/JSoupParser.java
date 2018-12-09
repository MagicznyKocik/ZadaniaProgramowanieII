package Jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JSoupParser {
    public static void main(String[] args) throws IOException {
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        Document document = connect.get();
        Elements allH1 = document.select("h1");
        for(Element elem: allH1) {
            System.out.println(elem.text());
        }
        //System.out.println(document.getAllElements());
        System.out.println("-----------------wp--------------");
        Connection connect2 = Jsoup.connect("https://tech.wp.pl/wejdz-do-czarnej-dziury-wszystko-dzieki-filmowi-stworzonemu-przez-badaczy-6324265766279297a");
        Document document2 = connect2.get();
        Elements allH3 = document2.select("h3");
        for(Element elem: allH3) {
            System.out.println(elem.text());
        }
    }
}
