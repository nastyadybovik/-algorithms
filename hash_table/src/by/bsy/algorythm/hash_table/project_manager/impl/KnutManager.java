package by.bsy.algorythm.hash_table.project_manager.impl;

import by.bsy.algorythm.hash_table.project_manager.Manager;

import java.util.*;

/**
 * Created by ��������� on 12/8/2015.
 */
public class KnutManager implements Manager {

    private static KnutManager instance = new KnutManager();

    private static Map< Double, List<Integer> > hashMap = new HashMap<>();
    private static Double GOLD_SECTION = (Math.sqrt(5)-1)/2;
    private static Integer NUMBER_FOR_8_BIT = 158;
    private static Integer NUMBER_OF_ELEMENTS = 32;
    private static Integer number = 32;

    public static KnutManager getInstance(){
        return instance;
    }

    @Override
    public void solve(Integer[] array){
        for(int i=0; i<array.length; i++){
            add(array[i]);
        }
    }

    @Override
    public void print(){
        for(Double key : hashMap.keySet()){
            List<Integer> list = hashMap.get(key);
            System.out.print("Key: " + key + "   ");
            for(Integer ob : list){
                System.out.print(" " + ob);
            }
            System.out.println();
        }
    }

    // �������� key ���������� �� ���������, ����� �� ���������� ������� n ��� (2^n = NUMBER_OF_ELEMENTS)
    // �����, ������� 8-������� ���� �� 158, ����� �������� ��������� 16-������ �����.
    // ��� ������� ������ 2^5 � �������� ����������� �������� ����� 5 ������� ����� �������� �����, ����������� ����� ������������

    @Override
    public void add(Integer el){
        Double key = formKey(el);
        Set<Double> keySet = hashMap.keySet();
        if(keySet.contains(key)){
            List<Integer> list = hashMap.get(key);
            list.add(el);
        } else {
            List<Integer> list = new LinkedList<>();
            list.add(el);
            hashMap.put(key, list);
        }

    }

    private Double formKey(Integer el){
        /*Integer value = (int)(el * GOLD_SECTION);
        Integer key1 = takeEightBit(value)* NUMBER_FOR_8_BIT;
        Integer key2 = takeFiveBit(key1);
        return key2;*/
        Double key = 128*((Math.sqrt(5)-1)*el/2);
        return key;
    }

    private Integer takeEightBit(Integer el){
        Integer k=1;
        for (int i = 8 ; i > -1; --i) {
            k*=2^((el >> i) & 1);
            //System.out.print((el >> i) & 1);
        }
        return k;
    }

    private Integer takeFiveBit(Integer el){
        Integer k=1;
        for (int i = 5 ; i > -1; --i) {
            k*=2^((el >> i) & 1);
            //System.out.print((el >> i) & 1);
        }
        return k;
    }

    @Override
    public void delete(Integer el){
        Double k = formKey(el);
        List<Integer> list = hashMap.get(k);
        if(list != null) {
            list.remove(el);
        }

    }

    @Override
    public Integer search(Integer el){
        Double k = formKey(el);
        List<Integer> list = hashMap.get(k);
        int index;
        if(list != null) {
            index = list.indexOf(el);
        } else {
            index = -1;
        }
        return index;
    }
}
