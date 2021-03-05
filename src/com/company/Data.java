package com.company;

import java.io.*;
import java.util.ArrayList;

public class Data {

    public static ArrayList<Animal> getAnimals() {
        ArrayList<Animal> animals = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("animals.csv"));
            String nextLine = br.readLine();
            while (nextLine != null) {
                nextLine = br.readLine();
                if(nextLine != null) {
                    Animal anm = new Animal();
                    anm.id = Integer.parseInt(nextLine.split(";")[0]);
                    anm.type = Integer.parseInt(nextLine.split(";")[1]);
                    anm.name = nextLine.split(";")[2];
                    anm.age = Integer.parseInt(nextLine.split(";")[3]);
                    anm.gender = nextLine.split(";")[4].charAt(0);
                    anm.isAgresive = nextLine.split(";")[5].charAt(0) == 'Y';
                    anm.isFriendly = nextLine.split(";")[6].charAt(0) == 'Y';
                    animals.add(anm);
                }

            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return animals;
    }

    public static ArrayList<AnimalType> getAnimalType() {
        ArrayList<AnimalType> types = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("animal_types.csv"));

            String nextLine = br.readLine();
            while (nextLine != null) {
                nextLine = br.readLine();
                if(nextLine != null) {
                    AnimalType anmType = new AnimalType();
                    anmType.id = Integer.parseInt(nextLine.split(";")[0]);
                    anmType.animal = nextLine.split(";")[1];
                    types.add(anmType);
                }

            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return types;
    }


    public static void ukol1(ArrayList<Animal> agresive) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("ukol1.txt"));
            for (Animal animal : agresive) {
                bw.write(animal.name+";"+animal.typeS+";"+animal.gender);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Relationship> getFiles() {
        String[] pathnames = new File("./relationships").list();
        ArrayList<Relationship> relations = new ArrayList<>();
        for (int i = 0; i < pathnames.length; i++) {
            Relationship novy = new Relationship();
            novy.owner = Integer.parseInt(pathnames[i].split("_owns_")[0]);
            novy.animal = Integer.parseInt(pathnames[i].split("_owns_")[1]);
            relations.add(novy);
        }
        return relations;
    }

    public static ArrayList<People> getPeople() {
        ArrayList<People> peoples = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("people.csv"));
            String nextLine = br.readLine();
            while (nextLine != null) {
                nextLine = br.readLine();
                if(nextLine != null) {
                    People osoba = new People();
                    osoba.id = Integer.parseInt(nextLine.split(";")[0]);
                    osoba.name = nextLine.split(";")[1].split(" ")[0];
                    osoba.surname = nextLine.split(";")[1].split(" ")[1];
                    osoba.age = Integer.parseInt(nextLine.split(";")[2]);
                    osoba.gender = nextLine.split(";")[3].charAt(0);
                    peoples.add(osoba);
                }
            }
            br.close();
        } catch (IOException e){
            System.out.println(e);
        }
        return peoples;
    }

    public static void ukol2(ArrayList<People> allPeople) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("ukol2.txt"));
            for (People people : allPeople) {
                bw.write(people.name+";"+people.surname+";"+people.animalsCount);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void ukol4(ArrayList<People> allPeople) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("ukol4.txt"));
            for (People people : allPeople) {
                bw.write(people.name+" "+people.surname+";"+people.avgAnimalAge);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void typyZvirat(String animal, ArrayList<Animal> zapis) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(animal+".txt"));
            for (Animal animal2 : zapis) {
                bw.write(animal2.id+"");
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
