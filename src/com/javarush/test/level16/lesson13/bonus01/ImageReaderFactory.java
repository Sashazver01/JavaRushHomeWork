package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by alexandr on 26.12.15.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes imageTypes)
    {
        int a = 0;
        if (imageTypes == ImageTypes.BMP)
            a = 1;
        if (imageTypes == ImageTypes.JPG)
            a = 2;
        if (imageTypes == ImageTypes.PNG)
            a = 3;

        switch (a )
        {
            case 1 :
                return new BmpReader();
            case 2:
                return new JpgReader();
            case 3:
                return new PngReader();
            default: throw new IllegalArgumentException("Неизвестный тип картинки");
        }



    }
}
