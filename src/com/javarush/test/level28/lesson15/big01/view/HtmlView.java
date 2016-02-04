package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

/**
 * Created by alexandr on 20.01.16.
 */
public class HtmlView implements View
{
    Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies)
    {
        try
        {
            System.out.println(vacancies.size());
            String data = getUpdatedFileContent(vacancies);
            updateFile(data);
        }catch (IOException e){}
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }
    public void userCitySelectEmulationMethod()throws IOException
    {
         controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies)
    {
        String fileContent = null;
        try {
            Document doc = getDocument();
            Element templateElement = doc.select(".template").first();

            Element patternElement = templateElement.clone();
            patternElement.removeAttr("style");
            patternElement.removeClass("template");

            doc.select("tr[class=vacancy]").remove();

            for (Vacancy vacancy : vacancies) {
                Element newVacancyElement = patternElement.clone();
                newVacancyElement.getElementsByClass("city").first().text(vacancy.getCity());
                newVacancyElement.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                newVacancyElement.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element link = newVacancyElement.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());

                templateElement.before(newVacancyElement.outerHtml());
            }
            fileContent = doc.html();
        }
        catch (IOException e) {
            e.printStackTrace();
            fileContent = "Some exception occurred";
        }
        return fileContent;
    }
    private void updateFile(String string)throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write(string);
        bufferedWriter.close();
    }
    protected Document getDocument() throws IOException{
        Document document = Jsoup.parse(new File(filePath),"UTF-8");
        return document;
    }
}
