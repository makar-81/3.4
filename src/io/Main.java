package io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by emakarov on 27.01.2016.
 */
public class Main {
    public static void main(String[] args) {
        // put your code here

        BufferedReader br;
        BufferedWriter bw;
        String temp;

        //BufferedInputStream fr;
        //OutputStream bw;

        //FileReader fr = new FileReader("./test1.txt");
        //FileWriter wr = new FileWriter("./test2.txt");

        //bw = new BufferedWriter(wr);
        //br = new BufferedReader(fr);

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> store = new HashMap<String, Integer>();
        Map<Integer, String> keys = new HashMap<Integer, String>();
        Map<String, Integer> count = new HashMap<String, Integer>();

        try {
            int key = 1;
            String word1 = "",word2 = "";
            while ((temp = br.readLine()) != null) {
                //while (!temp.isEmpty()) {


                int pos1 = temp.indexOf("\t");
                int pos2 = temp.indexOf(";");
                Integer temp_int = new Integer(0) ;
                if (pos1 > 0 && pos2 >0) {
                    word1 = temp.substring(0, pos1);
                    word2 = temp.substring(pos1 + 1, pos2);

                }

                if (store.get(word1) != null) {
                    temp_int = store.get(word1)+ Integer.parseInt(word2);
                    store.put(word1, temp_int);
                    count.put(word1,count.get(word1)+1);
                }
                else
                    store.put(word1, Integer.parseInt(word2));


                if (!keys.containsValue(word1)) {
                    keys.put(key, word1);
                    count.put(word1,1);
                    key = key + 1;
                }
            }
            for (int i = 1; i <= keys.size(); i++) {
                //System.out.println(keys.get(i).toString() + "\t" + store.get(keys.get(i)));
                //bw.write(keys.get(i).toString() + "\t" + store.get(keys.get(i))+ "\n");
                bw.write(keys.get(i).toString() + "\t" + (store.get(keys.get(i))/count.get(keys.get(i))) + "\n");
                bw.flush();
            }


            //}
            keys.clear();
            store.clear();

        } catch (IOException e) {
            e.printStackTrace();
        }

    } /*catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
}

