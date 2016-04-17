package by.bsu.graf;

import by.bsu.graf.manager.DepthFirstSearch;
import by.bsu.graf.manager.utils.MatricaSmezhnosti;

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
        MatricaSmezhnosti.getInstance().print();

        DepthFirstSearch.getInstance().solve(matrix);
        DepthFirstSearch.getInstance().print();

    }
}
