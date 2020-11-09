
package prefs;

import java.util.prefs.Preferences;


public class Prefs {

    public static void main(String[] args) {
        Preferences node = Preferences.userRoot().node("pref_5");

        System.out.println("Подсчитать количество отрицательных элементов в таблице и увеличить на это значение\n" +
"минимальный и максимальный элементы таблицы");

        final int r = 10;
        final int c = 2;
        float m[][] = new float[r][c];
        float k;
        
        System.out.println("Матрица:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                k = -10 + (int) Math.round(Math.random() * 21);
                m[i][j] = k;
                System.out.print(k + " ");
            }
            System.out.println("");
        }
            // Реализация алгоритма варианта задания 
            float min = m[0][0], max = m[0][0];
            int count = 0;// count будет считать отрицательные числа в матрице
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (m[i][j] < 0) {
                        count = count + 1;
                    }

                    if (m[i][j] < min) {
                        min = m[i][j];//
                    }
                    if (m[i][j] > max) {
                        max = m[i][j];//

                    }
                }
            }
            for (int i = 0; i < r; i++) {
            node.putFloat("K" + i, m[i][0]); 
            node.putFloat("Y" + i, m[i][1]);
        }

            System.out.println("Исходный минимальный элемент: " + min);
            System.out.println("Исходный максимальный элемент: " + max);
            System.out.println("Количество отрицательных элементов: " + count); 
            min = min+count;
            max = max+count;
            System.out.println("Новый минимальный элемент: " + min);
            System.out.println("Новый максимальный элемент: " + max);
    }
}