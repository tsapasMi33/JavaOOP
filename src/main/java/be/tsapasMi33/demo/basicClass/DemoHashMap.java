package be.tsapasMi33.demo.basicClass;

import java.util.HashMap;
import java.util.Map;

public class DemoHashMap {

    public static void main(String[] args) {
        HashMap<Integer, String> communes= new HashMap<>();
        communes.put(4000, "Liége");
        communes.put(1000, "Bruxelles");
        communes.put(4347,"Fexhe");

        System.out.println(communes.get(4000));

        for (int cp : communes.keySet()) {
            System.out.println(cp);
            System.out.println(communes.get(cp));
            System.out.println("-".repeat(10));
        }

        for (String s : communes.values()) {
            System.out.println(s);
            System.out.println("-".repeat(10));
        }

        for (Map.Entry<Integer, String> entry : communes.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("-".repeat(10));
        }
    }
}
