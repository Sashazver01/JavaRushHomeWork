package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File packageDirectory = new File("/home/alexandr/Idea/ArhivJavaRush/JavaRushHomeWork/src/com/javarush/test/level20/lesson02/TMP/");
            File your_file_name = File.createTempFile("your_file_name", null,packageDirectory);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            User user1 = new User();
            user1.setFirstName("Pupkin");
            user1.setLastName("Vasya");
            user1.setBirthDate(dateFormat.parse("07.01.2016"));
            user1.setCountry(User.Country.UKRAINE);
            User user2 = new User();
            user2.setFirstName("Kuy");
            javaRush.users.add(user1);
            javaRush.users.add(user2);


            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject)){
                System.out.println("Урасики");
            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

            PrintWriter writer = new PrintWriter(outputStream);
            String haveUsers;
            if (this.users.size()>0){
                haveUsers = "yes";
            }else haveUsers = "no";

            writer.println(haveUsers);
            if ("yes".equals(haveUsers)){
                for (User user: this.users)
                {
                    // firstName
                    String firstName;
                    if (user.getFirstName() == null)
                        firstName = "noFirstName";
                    else firstName = user.getFirstName();
                    writer.write(firstName);
                    writer.write(" - ");
                    // lastName
                    String lastName;
                    if (user.getLastName() == null)
                        lastName = "noLastName";
                    else lastName = user.getLastName();
                    writer.write(lastName);
                    writer.write(" - ");
                    //birthDate
                    String birthDate;
                    if (user.getBirthDate() == null)
                        birthDate = "noBirthDate";
                    else birthDate = dateFormat.format(user.getBirthDate());
                    writer.write(birthDate);
                    writer.write(" - ");
                    // male
                    String male;
                    if (user.isMale())
                        male = "yes";
                    else male = "no";
                    writer.write(male);
                    writer.write(" - ");

                    String country;
                    if (user.getCountry() == null)
                        country = "noCountry";
                    else country = user.getCountry().toString();
                    writer.write(country);

                    writer.write("\n");



                }
            }
            writer.flush();
            writer.close();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String haveUsers = reader.readLine();
            if ("yes".equals(haveUsers))
            {
                String  currentLine;
                while ((currentLine = reader.readLine())!= null)
                {
                    User user = new User();

                    String[] data = currentLine.split(" - ");

                    String firstname = data[0];
                    if (!firstname.equals("noFirstName"))
                        user.setFirstName(firstname);


                    String lastname = data[1];
                    if (!lastname.equals("noLastName"))
                        user.setLastName(lastname);

                    String BirthDate = data[2];
                    if (!BirthDate.equals("noBirthDate"))
                        user.setBirthDate(dateFormat.parse(BirthDate));

                    String male = data[3];
                    if (male.equals("yes"))
                        user.setMale(true);
                    else user.setMale(false);

                    String country = data[4];
                    if (!("noCountry".equals(country))){
                        user.setCountry(User.Country.valueOf(country));}
                    this.users.add(user);



                }

            }
            reader.close();
        }
    }
}
