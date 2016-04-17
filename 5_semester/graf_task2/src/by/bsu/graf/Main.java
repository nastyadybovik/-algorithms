package by.bsu.graf;

import by.bsu.graf.manager.BreadthFirstSearch;
import by.bsu.graf.manager.TwoPartGraf;
import by.bsu.graf.manager.utils.MatricaSmezhnosti;

import java.util.Map;

/**
 * Created by ��������� on 12/9/2015.
 */
public class Main {

    public static void main(String... args){
        int v = 5;
        // ������� ����� � ������� ������ {{ v1, v2}, ... } - ��� ��������, ��� ����� ����� v1 � v2 ����
        // 1 - ���� �����, 0 - ��� �����
        int[][] e = {{1, 2}, {2, 5}, {1,3}, {3,4}};

        System.out.println("MatricaSmezhnosti");
        int[][] matrix = MatricaSmezhnosti.getInstance().solve(v, e);

        int vertex = 3;
        MatricaSmezhnosti.getInstance().print();
        System.out.println("and vertex " + vertex);
        BreadthFirstSearch.getInstance().solve(matrix, vertex);
        BreadthFirstSearch.getInstance().print();

        //BreadthFirstSearch.getInstance().connected();

        //TwoPartGraf.getInstance().solve(matrix, vertex);
    }
}
