package com.iesam.huellas.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.huellas.domain.models.AdoptionRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AdoptionRecordFileLocalDataSource {

    private static AdoptionRecordFileLocalDataSource instance = null;

    private String nameFile = "adoption_records.txt";

    private Gson gson = new Gson();

    private final Type typeAdoptionRecordList = new TypeToken<ArrayList<AdoptionRecord>>() {}.getType();

    private AdoptionRecordFileLocalDataSource() {}

    public void save(AdoptionRecord adoptionRecord) {
        List<AdoptionRecord> adoptionRecords = findAll();
        adoptionRecords.add(adoptionRecord);
        saveToFile(adoptionRecords);
    }

    public void saveList(List<AdoptionRecord> adoptionRecords) {
        saveToFile(adoptionRecords);
    }

    private void saveToFile(List<AdoptionRecord> adoptionRecords) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(adoptionRecords));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }


    public AdoptionRecord findById(Integer adoptionRecordId) {
        List<AdoptionRecord> adoptionRecords = findAll();
        for (AdoptionRecord adoptionRecord : adoptionRecords) {
            if (Objects.equals(adoptionRecord.getId(), adoptionRecordId)) {
                return adoptionRecord;
            }
        }
        return null;
    }

    public List<AdoptionRecord> findAll() {
        try {
            File myObj = new File(nameFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeAdoptionRecordList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        }
        return new ArrayList<AdoptionRecord>();
    }

    public static AdoptionRecordFileLocalDataSource getInstance() {
        if (instance == null) {
            instance = new AdoptionRecordFileLocalDataSource();
        }
        return instance;
    }
}
