import java.util.*;

/**
 * Created by Bruno on 10/1/2016.
 */
public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        int[][] peopleClone = clone(people);
        for (int i = 0; i < people.length; i++) {
            int pivotIdx = i;
            for (int j = i + 1; j < people.length; j++) {
                int[] candidatePivot = people[j];
                int[] pivot = people[pivotIdx];
                if(candidatePivot[1] == 0 && (pivot[1] != 0 || candidatePivot[0] <= pivot[0])){
                    pivotIdx = j;
                }
            }
            swap(peopleClone, i, pivotIdx);
            swap(people, i, pivotIdx);
            for (int j = i + 1; j < people.length; j++) {
                int[] pivot = people[i];
                if(pivot[0] >= people[j][0]){
                    people[j][1]--;
                }
            }
        }
        return people;
    }

    private void swap(int[][] people, int i, int j){
        int[] aux = people[i];
        people[i] = people[j];
        people[j] = aux;
    }

    private int[][] clone(int[][] matrix){
        int[][] matrixClone = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixClone[i][j] = matrix[i][j];
            }
        }
        return matrixClone;
    }

}
