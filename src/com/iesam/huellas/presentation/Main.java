package com.iesam.huellas.presentation;

import com.iesam.huellas.data.local.CatFileLocalDataSource;
import com.iesam.huellas.data.remote.CatApiRemoteDataSource;
import com.iesam.huellas.domain.models.Cat;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
            int option = 0;
            while (option != 6) {
                System.out.println("Menu:");
                System.out.println("1. Añadir un gato");
                System.out.println("2. Eliminar un gato");
                System.out.println("3. Listar gatos");
                System.out.println("4. Añadir persona");
                System.out.println("5. Crear una nueva adopción");
                System.out.println("6. Listar adopciones realizadas");
                System.out.println("Selecciona una opción:");

                option = scanner.nextInt();
                switch (option) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    default:
                        System.out.println("Opción no válida.");
                        option=0;
                        break;
                }
            }


            //CatDataRepository
            CatApiRemoteDataSource remoteDataSource = new CatApiRemoteDataSource();
            List<Cat> cats = remoteDataSource.getCats();

            CatFileLocalDataSource fileLocalDataSource = CatFileLocalDataSource.getInstance();
            fileLocalDataSource.saveList(cats);
        }
    }
