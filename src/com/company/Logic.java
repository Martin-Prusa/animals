package com.company;

import java.io.File;
import java.util.ArrayList;

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
}
