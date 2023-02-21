package com.iesam.huellas.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.huellas.domain.models.Dog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DogFileLocalDataSource {

    private static DogFileLocalDataSource instance = null;

    private String nameFile = "dogs.txt";

    private Gson gson = new Gson();

    private final Type typeDogList = new TypeToken<ArrayList<Dog>>() {}.getType();

    private DogFileLocalDataSource() {}

    public void save(Dog dog) {
        List<Dog> dogs = findAll();
        dogs.add(dog);
        saveToFile(dogs);
    }

    public void saveList(List<Dog> dogs) {
        saveToFile(dogs);
    }

    private void saveToFile(List<Dog> dogs) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(dogs));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }


    public Dog findById(Integer dogId) {
        List<Dog> dogs = findAll();
        for (Dog dog : dogs) {
            if (Objects.equals(dog.getId(), dogId)) {
                return dog;
            }
        }
        return null;
    }

    public List<Dog> findAll() {
        try {
            File myObj = new File(nameFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeDogList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        }
        return new ArrayList<Dog>();
    }

    public static DogFileLocalDataSource getInstance() {
        if (instance == null) {
            instance = new DogFileLocalDataSource();
        }
        return instance;
    }
}
