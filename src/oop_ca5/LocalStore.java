/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_ca5;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.*;

/**
 *
 * @author lizhengxing
 */
public class LocalStore implements Serializable {

    private Map<String, ArrayList<Person>> records = new HashMap<>();

    public LocalStore() {
        loadLocalRecords();
    }

    public void loadLocalRecords() {
        DataInputStream in = null;
        try {
            File file = new File("data.dat");
            in = new DataInputStream(new FileInputStream(file));
            while (in.available() > 0) {
                String queryName = readString(in, 16);
                int size = in.readInt();
                ArrayList<Person> ps = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    double score = in.readDouble();
                    String name = readString(in, 16);
                    int id = in.readInt();
                    int flag1 = in.readInt();
                    ArrayList<String> image = new ArrayList<>();
                    if (flag1 > 0) {
                        for (int j = 0; j < flag1; j++) {
                            image.add(readString(in, 100));
                        }
                    }
                    String personLink = readString(in, 100);
                    int flag3 = in.readInt();
                    ArrayList<Double> ratings = new ArrayList<>();
                    if (flag3 > 0) {
                        for (int x = 0; x < flag3; x++) {
                            ratings.add(in.readDouble());
                        }
                    }
                    double myRating = in.readDouble();
                    int flag2 = in.readInt();
                    ArrayList<String> myComments = new ArrayList<>();
                    if (flag2 > 0) {
                        for (int x = 0; x < flag2; x++) {
                            myComments.add(readString(in, 100));
                        }
                    }
                    Person p = new Person(score, queryName, name, id, personLink, image, myComments, ratings, myRating);
                    ps.add(p);
                }
                this.records.put(queryName, ps);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }
    }

    public void saveLocalRecords() {
        DataOutputStream dos = null;
        try {
            File file = new File("data.dat");
            dos = new DataOutputStream(new FileOutputStream(file));
            Set<String> queryNames = this.records.keySet();
            for (String queryName : queryNames) {
                dos.writeChars(pad(queryName, 16));
                ArrayList<Person> persons = this.records.get(queryName);
                dos.writeInt(persons.size());
                for (Person p : persons) {
                    dos.writeDouble(p.getScore());
                    dos.writeChars(pad(p.getName(), 16));
                    dos.writeInt(p.getId());
                    dos.writeInt(p.getImage().size());
                    if (p.getImage().size() > 0) {
                        for (String image : p.getImage()) {
                            dos.writeChars(pad(image, 100));
                        }
                    }
                    dos.writeChars(pad(p.getPersonLink(), 100));
                    dos.writeInt(p.getRatings().size());
                    if (p.getRatings().size() > 0) {
                        for (double rate : p.getRatings()) {
                            dos.writeDouble(rate);
                        }
                    }
                    dos.writeDouble(p.getMyRating());
                    dos.writeInt(p.getMyComments().size());
                    if (p.getMyComments().size() > 0) {
                        for (String comment : p.getMyComments()) {
                            dos.writeChars(pad(comment, 100));
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                dos.close();
            } catch (IOException ex) {
            }
        }
    }

    public ArrayList<Person> searchPerson(String name) {
        //Search in local data
        ArrayList<Person> resultList = searchLocally(name);

        if (resultList.isEmpty()) {
            //Search using API
            resultList = searchUsingAPI(name);
        }

        return resultList;
    }

    public ArrayList<Person> searchLocally(String name) {
        ArrayList<Person> resultList = new ArrayList<>();
        Set<String> queryName = records.keySet();
        if (queryName.contains(name)) {
            resultList = records.get(name);
        }
        return resultList;
    }

    public ArrayList<Person> searchUsingAPI(String name) {
        ArrayList<Person> resultList = new ArrayList<>();
        try {
            String link = "http://api.tvmaze.com/search/people?q=";

            URL url = new URL(link + name);

            InputStream in = url.openStream();

            JsonReader reader = Json.createReader(in);

            JsonArray array = reader.readArray();
            for (int i = 0; i < array.size(); i++) {
                JsonObject object = array.getJsonObject(i);
                double score = object.getJsonNumber("score").doubleValue();
                JsonObject person = object.getJsonObject("person");
                int id = person.getJsonNumber("id").intValue();
                String url1 = person.getString("url");
                String name1 = person.getString("name");
                ArrayList<String> image = new ArrayList<>();
                if (!person.isNull("image")) {
                    JsonObject images = person.getJsonObject("image");
                    String medium = images.getString("medium");
                    String original = images.getString("original");
                    image.add(medium);
                    image.add(original);
                }
                JsonObject link1 = person.getJsonObject("_links");
                JsonObject self = link1.getJsonObject("self");
                String url2 = self.getString("href");
                resultList.add(new Person(score, name, name1, id, image, url2));
            }
            this.records.put(name, resultList);

        } catch (Exception ex) {
        }
        return resultList;

    }

    public void editPerson(String name) {

        Scanner in = new Scanner(System.in);
        Person re = new Person();
        ArrayList<Person> resultList = searchLocally(name);
        if (resultList.isEmpty()) {
            System.out.println("Actor not found");
        } else {
            for (Person p : resultList) {
                System.out.println(p.toString());
            }
            System.out.println("Please enter the id:");
            int id = in.nextInt();
            boolean found = false;
            int count = 0;
            while (found==false && count < resultList.size()) {
                if (resultList.get(count).getId() == id) {
                    found = true;
                    re = resultList.get(count);
                    //System.out.println(re.toString());
                }
                                    count++;

            }
            if (found == true) {
                System.out.println("1.Rate");
                System.out.println("2.Comment");
                System.out.print("enter option: ");
                int option = in.nextInt();
                if (option == 1) {
                    System.out.println("Enter Rate");
                    double rate = in.nextDouble();
                   int index =  this.records.get(name).indexOf(re);
                   this.records.get(name).get(index).setMyRating(rate);
                    //re.setMyRating(rate);

                    Set<String> keys = this.records.keySet();
                    for (String key : keys) {
                        ArrayList<Person> ps = this.records.get(key);
                        
                        for (Person p : ps) {
                            if (re.equals(p) == true) {
                                p.setMyRating(rate);

                            }
                        }
                    }
                }
                if (option == 2) {
                    System.out.println("Enter Comment");
                    String com = in.nextLine();
                    re.setMyComments(com);
                    Set<String> keys = this.records.keySet();
                    for (String key : keys) {
                        ArrayList<Person> ps = this.records.get(key);
                        for (Person p : ps) {
                            if (re.equals(p) == true) {
                                p.setMyComments(com);

                            }
                        }
                    }
                }

            } else {
                System.out.println("Result not found");
            }

        }
        //System.out.println(re.toString());
    }

    public ArrayList<Person> searchById(int id) {
        ArrayList<Person> resultList = new ArrayList<>();
        Set<String> queryName = records.keySet();
        if (queryName.contains(id)) {
            resultList = records.get(id);
        }
        return resultList;
    }

    public void printAll(Set<Person> allPerson) {
        Set<String> queryNames = this.records.keySet();
        for (String queryName : queryNames) {
            ArrayList<Person> results = this.records.get(queryName);
            for (Person person : results) {
                allPerson.add(person);
            }
        }

        for (Person p : allPerson) {
            System.out.println(p.toString());
        }
    }

    public void listAll() {
        Set<Person> allPerson = new TreeSet<>();
        printAll(allPerson);
    }

    public void listByID() {
        Set<Person> allPerson = new TreeSet<>(new sortByID());
        printAll(allPerson);
    }

    public void listByRating() {
        Set<Person> allPerson = new TreeSet<>(new sortByRating());
        printAll(allPerson);
    }

    private static String pad(String value, int i) {
        while (value.length() < i) {
            value = '*' + value;
        }
        //System.out.println(value.getBytes().length);
        return value;
    }

    private static String readString(DataInputStream dis, int size) throws IOException {
        byte[] makeBytes = new byte[size * 2];// 2 bytes per char
        dis.read(makeBytes);  // read size characters (including padding)
        return depad(makeBytes);
    }

    private static String depad(byte[] read) {
        String word = "";
        for (int i = 0; i < read.length; i += 2) {
            char c = (char) (((read[i] & 0x00FF) << 8) + (read[i + 1] & 0x00FF));

            if (c != '*') {
                word += c;
            }
        }
        return word;
    }

    public Map<String, ArrayList<Person>> getRecords() {
        return records;
    }

    public void setRecords(Map<String, ArrayList<Person>> records) {
        this.records = records;
    }

    public void exportToHtml(String strPath,
    String strName) throws FileNotFoundException {
        File f = new File(strPath);
        f.mkdirs();
        PrintWriter pWriter = new PrintWriter(strPath + strName);

        pWriter.println("<html>");
        pWriter.println("<head><title>Actors</title></head>");
        pWriter.println("<body>");

        Set<String> queryNames = this.records.keySet();
        Set<Person> ps = new TreeSet<>();

        for (String key : queryNames) {
            ArrayList<Person> data = this.records.get(key);
            //get value associated with key
            for (int i = 0; i < data.size(); i++) {
                ps.add(data.get(i));
            }
        }

        for (Person p : ps) {
            pWriter.println(p.toHTML());
        }

        pWriter.println("</body>");
        pWriter.println("</html>");
        pWriter.close();

    }

}
