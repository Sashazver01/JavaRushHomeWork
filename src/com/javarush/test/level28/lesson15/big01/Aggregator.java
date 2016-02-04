package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.*;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;
import com.javarush.test.level28.lesson15.big01.view.View;


import java.io.IOException;


/**
 * Created by alexandr on 19.01.16.
 */
public class Aggregator
{
    public static void main(String[] args) throws IOException
    {
        HtmlView view = new HtmlView();
        Strategy strategy = new HHStrategy();




        Strategy strategy1 = new MoikrugStrategy();
        Provider[] providers = { new Provider(strategy),new Provider(strategy1)};

        Model model = new Model(view, providers);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();


    }
}
