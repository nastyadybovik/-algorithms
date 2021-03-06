package by.bsu.graf.manager;

import by.bsu.graf.domain.Parametr;

import java.util.*;

/**
 * Created by Настенька on 12/9/2015.
 */
public class TwoPartGraf {

    public static Map<Integer, Map<Parametr, Integer>> map = new HashMap<>();
    public static LinkedList<Integer> list = new LinkedList<>();

    private static TwoPartGraf instance = new TwoPartGraf();

    public static TwoPartGraf getInstance(){
        return instance;
    }


    public void solve (int[][] matrix , int v){
        init(matrix, v);

        boolean status = true;
        while(!list.isEmpty()){
            Integer tmp = list.getFirst();
            list.removeFirst();
            List<Integer> surrounding = getSurrounding(matrix, tmp);
            System.out.println("for tmp="+tmp+" surrounding="+surrounding);
            for(Integer i : surrounding){
                int color = map.get(i).get(Parametr.COLOR);
                if(color == -1){
                    int tmpColor = map.get(tmp).get(Parametr.COLOR);
                    map.get(i).put(Parametr.COLOR, tmpColor+1);
                    int tmpLabel = map.get(tmp).get(Parametr.LABEL);
                    map.get(i).put(Parametr.LABEL, tmpLabel + 1);
                    list.add(i);
                }
            }

            Integer tmpColor = map.get(tmp).get(Parametr.COLOR);

            map.get(tmp).put(Parametr.COLOR, tmpColor);

        }

        print();

        if(status){
            System.out.println("Two Part.");
        } else{
            System.out.println("No Two Part.");
        }
    }

    private List<Integer> getSurrounding(int[][] matrix , Integer tmp){
        List<Integer> surrounding = new LinkedList<>();
        int[] array = matrix[tmp-1];
        for(int i=0; i<array.length; i++){
            if(array[i]==1){
                surrounding.add(i + 1);
            }
        }
        return surrounding;
    }

    public void init(int[][] matrix , int v){
        for(int i=0; i<matrix.length; i++){
            if(v!=i+1) {
                Map<Parametr, Integer> parametrMap = new HashMap<>();
                parametrMap.put(Parametr.LABEL, 10_000);
                parametrMap.put(Parametr.COLOR, -1);
                map.put(i + 1, parametrMap);
            } else {
                Map<Parametr, Integer> parametrMap = new HashMap<>();
                parametrMap.put(Parametr.LABEL, 0);
                parametrMap.put(Parametr.COLOR, 0);
                map.put(v, parametrMap);
            }
        }
        list.add(v);
    }

    public void print(){
        for(int k : map.keySet()){
            System.out.print("Vertex: "+k+" -> ");
            Map<Parametr, Integer> mapParametr = map.get(k);
            System.out.print("color: "+mapParametr.get(Parametr.COLOR)+" , label: "+mapParametr.get(Parametr.LABEL));
            System.out.println();
        }
    }

}
