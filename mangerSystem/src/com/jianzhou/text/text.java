package com.jianzhou.text;

import javax.swing.*;

/**
 * @ClassName text
 * @Description TODO
 * @Author
 * @Date 2021/3/10
 **/
public class text {
    public static void main(String[] args) {
        boolean[] booleans = new boolean[5];
        int[] ints = new int[5];
        String[] strings = new String[5];
        float[] floats = new float[5];
        double[] doubles = new double[5];
        for (boolean b:booleans){
            System.out.println("布尔类型默认值:" + b);
        }
        for (int i : ints){
            System.out.println("int类型的默认值：" + i);
        }
        for (String s :strings){
            System.out.println("String类型的默认值：" + s);
        }
        for (double d :doubles){
            System.out.println("double类型的默认值：" + d);
        }
        for (float f : floats){
            System.out.println("float类型的默认值：" + f);
        }
        Integer.parseInt("");
        JFrame frame = new JFrame();
        frame.setVisible(true);

    }
}
