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
 * Created by alexandr on 19.01.16.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) throws IOException
    {
        List<Vacancy> vacancyList = new ArrayList<Vacancy>();
        int page = 0;
        try
        {   while (true)
            {
                Document document = getDocument(searchString,page++);
                if (document == null){
                    break;
                }
                Elements elementsList = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elementsList.size() == 0)
                    break;
                for (Element element : elementsList){

                    Vacancy vacancy = new Vacancy();
                    vacancy.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
                    vacancy.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                    vacancy.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                    vacancy.setSiteName("http://hh.ua");
                    Element salaryElement = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").first();
                    String salary = "";
                    if (salaryElement != null) {
                        salary = salaryElement.text();
                    }
                    vacancy.setSalary(salary);
                    vacancyList.add(vacancy);
                }
            }

        }catch (Exception e){e.printStackTrace();}
        return vacancyList;
    }
    protected  Document getDocument(String searchString, int page) throws IOException
    {
        String conectStringURL = String.format(URL_FORMAT,searchString,page);
        return Jsoup.connect(conectStringURL)
                .referrer("https://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2")
                .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/43.0.2357.130 Chrome/43.0.2357.130 Safari/537.36")
                .get();
    }
}
