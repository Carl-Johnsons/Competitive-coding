package nwc_app.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ShortestPathProblem {

    public ArrayList<ArrayList<Integer>> Path = new ArrayList<ArrayList<Integer>>();
//    //TEST

    public static void main(String[] args) {

//        int src[][] = new int[][]{{0, 5, 8, 0},
//        {5, 0, 9, 2},
//        {8, 9, 0, 6},
//        {0, 2, 6, 0}};
        int src[][] = new int[4][4];
        ShortestPathProblem test = new ShortestPathProblem();

        System.out.println("TEST 2");
        int src2[][] = new int[][]{{0, 7, 0, 0, 14, 9},
        {7, 0, 15, 0, 0, 8},
        {0, 15, 0, 4, 0, 6},
        {0, 0, 4, 0, 9, 0},
        {14, 0, 0, 9, 0, 2},
        {9, 8, 6, 0, 2, 0}};

        test.dijkstra(src2, 0);

        int temp[][] = test.ReadData();
        int result[][] = test.dijkstra(test.ReadData(), 0);
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Result");
        for (int i = 0; i < result.length; i++) {
            System.out.print((char) (i + 'A') + " ");
            System.out.println(result[i][1]);
        }

        // int shortestpath[][] = test.dijkstra(temp, 0);
        // test.dijkstra(src2, 2);
        /*{0, 5, 8, 0},
          {5, 0, 9, 2}, Pick index 1
          {8, 9, 0, 6},
          {0, 2, 6, 0}*/
    }

    public ShortestPathProblem() {
    }

    public int[][] dijkstra(int[][] adjacencyMatrix, int start_index) {
        SaveData(adjacencyMatrix);
        Path.clear();
        int vertices = adjacencyMatrix.length;
        int distance[] = new int[vertices];
        boolean visited[] = new boolean[vertices];

        distance[start_index] = 0;
        for (int i = 0; i < vertices; i++) {
            if (i != start_index) {
                distance[i] = Integer.MAX_VALUE;
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(start_index);
                Path.add(temp);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                Path.add(temp);
            }
        }

        for (int i = 0; i < vertices - 1; i++) {
            int minVertex = findMinVertex(distance, visited);

            visited[minVertex] = true;

            for (int j = 0; j < vertices; j++) {
                if (adjacencyMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE) {
                    int newDistance = distance[minVertex] + adjacencyMatrix[minVertex][j];
                    if (newDistance < distance[j]) {
                        distance[j] = newDistance;
                        System.out.println("J = " + (char) (j + 'A'));
                        //Path.get(j).remove(Path.get(j).last());

                        Path.get(j).clear();
                        Path.get(j).addAll(Path.get(minVertex));
                        Path.get(j).add(minVertex);

                        System.out.println("PATH -----------");
                        for (int a = 0; a < Path.size(); a++) {
                            for (Integer b : Path.get(a)) {
                                System.out.print((char) (b + 'A') + " ");
                            }
                            System.out.println("");
                        }
                    }
                }
            }
        }

        int Shortest_Dis_from_Start[][] = new int[vertices][2];
        for (int i = 0; i < vertices; i++) {
            Shortest_Dis_from_Start[i][0] = i;
            Shortest_Dis_from_Start[i][1] = distance[i];
        }
        for (int i = 0; i < vertices; i++) {
            Path.get(i).add(i);
        }

        System.out.println("PATH -----------");
        for (int i = 0; i < Path.size(); i++) {
            for (Integer j : Path.get(i)) {
                System.out.print((char) (j + 'A') + " ");
            }
            System.out.println("");
        }
        return Shortest_Dis_from_Start;
    }

    private int findMinVertex(int distance[], boolean visited[]) {
        int min_Vertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && (min_Vertex == -1 || distance[i] < distance[min_Vertex])) {
                min_Vertex = i;
            }
        }
        return min_Vertex;
    }

    public int[][] ReadData() {
        try {
            int vertex = 0;
            File file = new File("src\\nwc_app\\data\\cache.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            Scanner read = new Scanner(file);
            if (read.hasNextLine()) {
                vertex = Integer.parseInt(read.nextLine());
            }
            int matrix[][] = new int[vertex][vertex];
            int i = 0;
            while (read.hasNextLine()) {
                String temp[] = read.nextLine().split(" ");
                for (int j = 0; j < vertex; j++) {
                    matrix[i][j] = Integer.parseInt(temp[j]);
                }
                i++;
            }
            return matrix;
        } catch (Exception e) {
            System.out.println("Something error with the file :(");
        }
        return null;
    }

    public void SaveData(int[][] adjacencyMatrix) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src\\nwc_app\\data\\cache.txt")))) {
            pw.println(adjacencyMatrix.length);
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                for (int j = 0; j < adjacencyMatrix.length; j++) {
                    pw.print(adjacencyMatrix[i][j] + " ");
                }
                pw.println();
            }
        } catch (Exception e) {
            System.out.println("Something error with the file :(");
        }
    }

    public void EditDataAtLine(int pos, int[] data) {
        int temp[][] = ReadData();
        for (int i = 0; i < temp.length; i++) {
            temp[pos][i] = data[i];
        }
        SaveData(temp);
    }

    public void EditDataAtCell(int data, int[][] MatrixData, int row, int column) {
        MatrixData[row][column] = data;
        SaveData(MatrixData);
    }

    public void EditData(int[][] MatrixData) {
        SaveData(MatrixData);
    }

}
