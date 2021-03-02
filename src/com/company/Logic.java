package com.company;

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
}
