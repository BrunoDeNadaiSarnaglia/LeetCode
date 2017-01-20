import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Sarnaglia on 1/19/17.
 */
public class BuildingOutline {




    public static void main(String[] args){
        BuildingOutline bo = new BuildingOutline();
        System.out.println(
                bo.buildingOutline(new int[][]{
                        new int[]{1, 100, 20},
                        new int[]{2, 99, 19},
                        new int[]{3, 98, 18},
                })
        );
        System.out.println(
        bo.buildingOutline(new int[][]{
                new int[]{1, 3, 3},
                new int[]{2, 4, 4},
                new int[]{5, 6, 1},
        })
        );
    }

    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        if(buildings == null || buildings.length == 0)  return new ArrayList<>();
        Arrays.sort(buildings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<ArrayList<Integer>> bumps = buildingOutline(buildings, 0, buildings.length - 1);
        ArrayList<ArrayList<Integer>> skyline = new ArrayList<>();
        for (int i = 1; i < bumps.size(); i++) {
            ArrayList<Integer> building = new ArrayList<>();
            if(bumps.get(i - 1).get(1) == 0)    continue;
            building.add(bumps.get(i - 1).get(0));
            building.add(bumps.get(i).get(0));
            building.add(bumps.get(i - 1).get(1));
            skyline.add(building);
        }
        return skyline;
    }


    private ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings, int i, int j){
        if(i > j)   return null;
        if(i == j){
            ArrayList<Integer> firstBump = new ArrayList<>();
            if(buildings[i][0] >= buildings[i][1])  return null;
            firstBump.add(buildings[i][0]);
            firstBump.add(buildings[i][2]);
            ArrayList<Integer> secondBump = new ArrayList<>();
            secondBump.add(buildings[i][1]);
            secondBump.add(0);
            ArrayList<ArrayList<Integer>> skyline = new ArrayList<>();
            skyline.add(firstBump);
            skyline.add(secondBump);
            return skyline;
        }
        int mid = i + (j - i) / 2;
        ArrayList<ArrayList<Integer>> fh = buildingOutline(buildings, i, mid);
        ArrayList<ArrayList<Integer>> sh = buildingOutline(buildings, mid + 1, j);
        return merge(fh, sh);
    }


    private ArrayList<ArrayList<Integer>> merge(ArrayList<ArrayList<Integer>> fh, ArrayList<ArrayList<Integer>> sh){
        if(fh == null)  return sh;
        if(sh == null)  return fh;
        int i = 0;
        int j = 0;
        int lBumpx = -1;
        ArrayList<ArrayList<Integer>> skyline = new ArrayList<>();
        while (i < fh.size() || j < sh.size()){
            if(i == fh.size())  skyline.add(sh.get(j++));
            else if(j == sh.size()) skyline.add(fh.get(i++));
            else if(fh.get(i).get(0) < sh.get(j).get(0)){
                if(j == 0 || fh.get(i).get(1) > sh.get(j - 1).get(1))   skyline.add(fh.get(i));
                else if(sh.get(j - 1).get(1) > fh.get(i).get(1) && (i > 0 && sh.get(j - 1).get(1) < fh.get(i - 1).get(1))){
                    ArrayList<Integer> bump = new ArrayList<>();
                    bump.add(fh.get(i).get(0));
                    bump.add(sh.get(j - 1).get(1));
                    skyline.add(bump);
                }
                i++;
            }
            else if(fh.get(i).get(0) > sh.get(j).get(0)){
                if(i == 0 || sh.get(j).get(1) > fh.get(i - 1).get(1))   skyline.add(sh.get(j));
                else if(fh.get(i - 1).get(1) > sh.get(j).get(1) && (j > 0 && fh.get(i - 1).get(1) < sh.get(j - 1).get(1))){
                    ArrayList<Integer> bump = new ArrayList<>();
                    bump.add(sh.get(j).get(0));
                    bump.add(fh.get(i - 1).get(1));
                    skyline.add(bump);
                }
                j++;
            }
            else {
                int max = Math.max((i == 0 ? Integer.MIN_VALUE : (int)fh.get(i - 1).get(1)), (j == 0 ? Integer.MIN_VALUE : (int)sh.get(j - 1).get(1)));
                int newMax = Math.max(fh.get(i).get(1), sh.get(j).get(1));
                if(max != newMax){
                    ArrayList<Integer> bump = new ArrayList<>();
                    bump.add(sh.get(j).get(0));
                    bump.add(newMax);
                    skyline.add(bump);
                }
                i++;
                j++;
            }
        }
        return skyline;
    }



}
