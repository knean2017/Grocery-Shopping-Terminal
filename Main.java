import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    Map<Character,Integer> map = new HashMap<>();
    String str = scan.nextLine();
    char a = scan.next().charAt(0);

    for (char i:str.toCharArray()) {
        if (!map.containsKey(i)){
            map.put(i,1);
        }else{
            int nmbr = (int) map.get(i) + 1;
            map.put(i,nmbr);
        }
    }

        System.out.println(map.get(a));



    }
}
