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
}
