/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_ca5;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author lizhengxing
 */
public class Person implements Comparable<Person> {

    private double score;
    private String queryName;
    private String name;
    private int id;
    private ArrayList<String> image = new ArrayList<>();
    private String personLink;
    private double myRating = 0;
    private ArrayList<Double> ratings = new ArrayList<>();
    private ArrayList<String> myComments = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.personLink, other.personLink)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.personLink);
        return hash;
    }

    public Person() {
    }

    public Person(double score, String queryName, String name, int id, ArrayList<String> image, String personLink) {
        this.score = score;
        this.queryName = queryName;
        this.name = name;
        this.id = id;
        this.image = image;
        this.personLink = personLink;
    }

    public Person(double score, String queryName, String name, int id, String personLink, ArrayList<String> image, ArrayList<String> myComments, ArrayList<Double> rates, double rating) {
        this.score = score;
        this.queryName = queryName;
        this.name = name;
        this.id = id;
        this.personLink = personLink;
        this.image = image;
        this.myComments = myComments;
        this.ratings = rates;
        this.myRating = rating;

    }

    public ArrayList<Double> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Double> ratings) {
        this.ratings = ratings;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonLink() {
        return personLink;
    }

    public void setPersonLink(String personLink) {
        this.personLink = personLink;
    }

    public ArrayList<String> getImage() {
        return image;
    }

    public void setImage(ArrayList<String> image) {
        this.image = image;
    }

    public double getMyRating() {
        if (!this.ratings.isEmpty()) {
            double count = 0, total = 0;
            for (int i = 0; i < this.ratings.size(); i++) {
                count++;
                total += this.ratings.get(i);
            }

            return total / count;
        } else {
            return 0;
        }
    }

    public void setMyRating(double myRating) {
        this.ratings.add(myRating);
        this.myRating = this.getMyRating();

    }

    public ArrayList<String> getMyComments() {
        return myComments;
    }

    public void setMyComments(String myComments) {
        this.myComments.add(myComments);
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        String str = this.name + "\nID: " + this.id
                + "\tmyRating: " + this.myRating
                + "\nScore: " + this.score;
        if (!this.myComments.isEmpty() && this.myComments != null) {
            str += "\nmyComments: ";
            for (String c : this.myComments) {
                str += "\n" + c;
            }
        }
        if (!this.image.isEmpty() && this.image != null) {
            str += "\nImage: ";
            for (String i : this.image) {
                str += "\n" + i;
            }
        }
        str += "\nPerson link: " + this.personLink + "\n*********************************\n";
        return str;
    }

    public String toHTML() {
        ArrayList<String> urls = this.getImage();
      
       
        String output = "<div>";
        
         if (!urls.isEmpty()) {
             for (String str : this.image) {
            output += "<img src=" + str + "><br>";

        }
        }

        output += "Name: " + this.name + "<br>";
        output += "ID: " + this.id + "<br>";
        output += "Score: " + this.score + "<br>";
        output += "Person Link: " + this.personLink + "<br>";
        output += "Rating: " + this.myRating + "<br>";
        output += "Comments: <br>";

        for (int i = 0; i < this.myComments.size(); i++) {
            output += "#" + i + " : " + this.myComments.get(i) + "<br>";

        }
        output += "</div><hr>";

        return output;
    }

}
