package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandr on 20.01.16.
 */
public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";
    @Override
    public List<Vacancy> getVacancies(String searchString) throws IOException
    {
        List<Vacancy> list = new ArrayList<>();
        int page = 1;
        while (true) {
            try {
                Document doc = getDocument(searchString, page++);
                if (doc == null){
                    break;
                }
                Elements all = doc.getElementsByClass("job");
                if (!all.isEmpty()) {
                    for (Element e : all) {
                        Vacancy vacancy = new Vacancy();
                        vacancy.setSiteName(doc.title());
                        vacancy.setSalary(e.getElementsByClass("salary").first().getElementsByAttributeValue("title", "Зарплата").text());
                        vacancy.setTitle(e.getElementsByClass("info").first().getElementsByAttribute("title").text());
                        vacancy.setUrl("https://moikrug.ru" + e.getElementsByClass("title").first().getElementsByTag("a").attr("href"));
                        vacancy.setCity(e.getElementsByClass("location").text());
                        vacancy.setCompanyName(e.getElementsByClass("company_name").first().getElementsByTag("a").text());
                        list.add(vacancy);
                    }
                }
                else break;
            } catch (Exception ignored) {ignored.printStackTrace();}

        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String conectStringURL = String.format(URL_FORMAT,page,searchString);
        return Jsoup.connect(conectStringURL)
                .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/43.0.2357.130 Chrome/43.0.2357.130 Safari/537.36")
                .get();
    }
}
