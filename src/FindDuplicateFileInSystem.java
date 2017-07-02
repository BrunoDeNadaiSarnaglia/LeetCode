import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sarnaglia on 7/2/17.
 */
public class FindDuplicateFileInSystem {

    public static void main(String[] args) {
        FindDuplicateFileInSystem f = new FindDuplicateFileInSystem();
        f.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"});
    }

    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < paths.length; i++) {
            String wh = paths[i];
            String[] files = wh.split(" ");
            String path = files[0];
            for (int j = 1; j < files.length; j++) {
                String file = files[j].split("\\(")[0];
                String content = files[j].split("\\(")[1];
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(path + "/" + file);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for (List<String> files: map.values()) {
            if(files.size() > 1)
                list.add(files);
        }
        return list;
    }
}
