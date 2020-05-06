import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by liu1589 on 4/21/16.
 */
public class Stats {
    public static HashMap wins(BufferedReader f){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        try {
            while (true) {
                String s = f.readLine();
                if (s == null){
                    break;}
                String a [] = s.split(" ");
                if (a [0].equals("0")){
                    for (int i = 1; i < 6; i++){
                        if (map.get(a [i]) == null){
                            map.put(a [i], 1);
                        }else{
                            int old = map.get(a [i]);
                            old ++;
                            map.put(a [i], old);
                        }
                    }
                }

                if (a [0].equals("1")){
                    for (int i = 7; i > 6 && i < a.length; i++){
                        if (map.get(a [i]) == null){
                            map.put(a [i], 1);
                        }else{
                            int old = map.get(a [i]);
                            old ++;
                            map.put(a [i], old);
                        }
                    }
                }
            }
        }catch (IOException e){
        System.out.println("IOException");}
        return map;
    }
    public static String winner(HashMap c){
        String cw = "";
        int maxwins = 0;
        Iterator it = c.entrySet().iterator();
        int highscore = 0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.printf("key = %s\t val = %d\n", pair.getKey(), pair.getValue());
            int recent = (Integer) pair.getValue();
            if (highscore < recent) {
                highscore = recent;
                cw = (String) pair.getKey();
            }
        }
        String winner = cw;
        return winner;
    }

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader((new FileReader("/homes/liu1589/cs180/lab14inputfile.txt")));
            System.out.println(winner (wins(br)));
        }
        catch (IOException e){

        }

}
}
