package program;

import entities.Company;
import entities.Developer;
import entities.ProjectManager;
import entities.board.Board;
import enums.Skills;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<Developer> listDevs = new ArrayList<>();
        ArrayList<ProjectManager> listMP = new ArrayList<>();

        String path = "src/plan_workspace.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String[] dimensions = br.readLine().split(" ");
            int y_dim = Integer.parseInt(dimensions[0]);
            int x_dim = Integer.parseInt(dimensions[1]);

            Board office = new Board(x_dim, y_dim);
            office.populateOffice();

            for (int i = 0; i < x_dim; i++) {
                String[] fields = br.readLine().split("");
                for (int j = 0; j < y_dim; j++) {
                    if (fields[j].equals("_")) {
                        office.setPosition(i, j, new Developer());
                    } else if (fields[j].equals("M")) {
                        office.setPosition(i, j, new ProjectManager());
                    }
                }
            }

            int nDev = Integer.parseInt(br.readLine());
            for (int i = 0; i < nDev; i++) {
                String[] devs = br.readLine().split(" ");
                String[] skills = Arrays.copyOfRange(devs, 3, devs.length);
                listDevs.add(new Developer(new Company(
                        devs[0]),
                        Double.parseDouble(devs[1]),
                        Integer.parseInt(devs[2]),
                        skills));
            }

            int nPM = Integer.parseInt(br.readLine());
            for (int i = 0; i < nPM; i++) {
                String[] pms = br.readLine().split(" ");
                listMP.add(new ProjectManager(new Company(pms[0]), Integer.parseInt(pms[1])));

            }


            //office.showOffice();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
