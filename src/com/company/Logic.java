package com.company;

import java.util.*;

public class Logic {
    public static void ukol1() {
        ArrayList<Animal> animals = Data.getAnimals();
        ArrayList<AnimalType> animalTypes = Data.getAnimalType();

        ArrayList<Animal> agresive = new ArrayList<>();

        for (Animal animal : animals) {
            if(animal.isAgresive) agresive.add(animal);
        }
        animals.clear();

        for (int i = 0; i < agresive.size(); i++) {
            int id = agresive.get(i).type;
            for (int i1 = 0; i1 < animalTypes.size(); i1++) {
                if(id == animalTypes.get(i1).id) {
                    Animal novy = agresive.get(i);
                    novy.typeS = animalTypes.get(i1).animal;
                    agresive.set(i, novy);
                }
            }
        }


        Data.ukol1(agresive);
    }

    public static void ukol2() {
        ArrayList<Relationship> relations = Data.getFiles();
        ArrayList<People> peoples = new ArrayList<>();
        ArrayList<Integer> zarazeny = new ArrayList<>();
        for (Relationship relation : relations) {
            int index = zarazeny.indexOf(relation.owner);
            if(index == -1) {
                People osoba = new People();
                osoba.id = relation.owner;
                osoba.animalsCount = 1;
                peoples.add(osoba);
                zarazeny.add(osoba.id);
            } else {
                People osoba = peoples.get(index);
                osoba.animalsCount++;
                peoples.set(index, osoba);
            }
        }
        ArrayList<People> allPeople = Data.getPeople();

        for (int i = 0; i < peoples.size(); i++) {
            int peopleId = peoples.get(i).id;
            for (int i1 = 0; i1 < allPeople.size(); i1++) {
                if(peopleId == allPeople.get(i1).id) {
                    People a = allPeople.get(i1);
                    a.animalsCount = peoples.get(i).animalsCount;
                    allPeople.set(i1, a);
                }
            }
        }

        Data.ukol2(allPeople);
    }

    public static int ukol3() {
        ArrayList<Relationship> relations = Data.getFiles();
        System.out.println(relations.size());
        return 0;
    }

    public static void ukol4() {
        ArrayList<Relationship> relations = Data.getFiles();
        ArrayList<People> peoples = new ArrayList<>();
        ArrayList<Animal> animals = Data.getAnimals();
        ArrayList<Integer> zarazeny = new ArrayList<>();
        for (Relationship relation : relations) {
            int index = zarazeny.indexOf(relation.owner);
            if(index == -1) {
                People osoba = new People();
                osoba.id = relation.owner;
                osoba.avgAnimalAge = animalAge(relation.animal, animals);
                peoples.add(osoba);
                zarazeny.add(osoba.id);
            } else {
                People osoba = peoples.get(index);
                osoba.avgAnimalAge = (osoba.avgAnimalAge + animalAge(relation.animal, animals))/2;
                peoples.set(index, osoba);
            }
        }
        ArrayList<People> allPeople = Data.getPeople();

        for (int i = 0; i < peoples.size(); i++) {
            int peopleId = peoples.get(i).id;
            for (int i1 = 0; i1 < allPeople.size(); i1++) {
                if(peopleId == allPeople.get(i1).id) {
                    People a = allPeople.get(i1);
                    a.avgAnimalAge = peoples.get(i).avgAnimalAge;
                    allPeople.set(i1, a);
                }
            }
        }

        Data.ukol4(allPeople);

    }

    public static int animalAge(int animalID, ArrayList<Animal> animals) {
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i).id == animalID) return animals.get(i).age;
        }
        return -1;
    }

    public static void ukol5() {
        ArrayList<Animal> animals = Data.getAnimals();
        ArrayList<AnimalType> animalTypes = Data.getAnimalType();
        for (AnimalType animalType : animalTypes) {
            ArrayList<Animal> zapis = new ArrayList<>();
            for (Animal animal : animals) {
                if(animalType.id == animal.type) zapis.add(animal);
            }
            Data.typyZvirat(animalType.animal,zapis);
        }
    }
}
