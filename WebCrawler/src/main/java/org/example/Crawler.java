package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class Crawler {
    HashSet<String>urlSet;
    int MAX_DEPTH=2;

    Crawler()
    {
        urlSet=new HashSet<>();

    }
    public void getPageTextsAndLinks(String url,int depth)
    {
        if(urlSet.contains(url))
        {
            return;
        }

        if(depth > MAX_DEPTH)
        {
            return;
        }

        urlSet.add(url);
        depth++;
        try {
            //html obj to java obj
            Document document = Jsoup.connect(url).timeout(5000).get();

            // Indexing = to save document object to database

            Indexer indexer=new Indexer(document,url);

            //
            System.out.println(document.title()+"---->"+url);
            Elements availableLinksOnPage = document.select("a[href]");

            for (Element currLink : availableLinksOnPage) {
               // System.out.println(document.title()+"---->"+document.select("a[href]").attr("abs:href"));
                getPageTextsAndLinks(currLink.attr("abs:href"),depth);
            }
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }



    }
    public static void main(String[] args)
    {
        Crawler cr=new Crawler();
        cr.getPageTextsAndLinks("https://javatpoint.com/",1);
    }
}