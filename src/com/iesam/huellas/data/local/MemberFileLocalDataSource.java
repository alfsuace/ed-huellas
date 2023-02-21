package com.iesam.huellas.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.huellas.domain.models.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MemberFileLocalDataSource {

    private static MemberFileLocalDataSource instance = null;

    private String nameFile = "members.txt";

    private Gson gson = new Gson();

    private final Type typeMemberList = new TypeToken<ArrayList<Member>>() {}.getType();

    private MemberFileLocalDataSource() {}

    public void save(Member member) {
        List<Member> members = findAll();
        members.add(member);
        saveToFile(members);
    }

    public void saveList(List<Member> members) {
        saveToFile(members);
    }

    private void saveToFile(List<Member> members) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(members));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }


    public Member findById(Integer memberId) {
        List<Member> members = findAll();
        for (Member member : members) {
            if (Objects.equals(member.getId(), memberId)) {
                return member;
            }
        }
        return null;
    }

    public List<Member> findAll() {
        try {
            File myObj = new File(nameFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeMemberList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        }
        return new ArrayList<Member>();
    }

    public static MemberFileLocalDataSource getInstance() {
        if (instance == null) {
            instance = new MemberFileLocalDataSource();
        }
        return instance;
    }
}
