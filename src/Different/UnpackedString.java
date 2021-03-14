package Different;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnpackedString {
  public static void main(String[] args) {

  }

  String text;

  public UnpackedString(String text) {
    this.text = text;
  }

  public static void compute(String text) {
    String res = "";

    Pattern pattern = Pattern.compile("[^(^a-z && \\[ && \\])]");
    Matcher matcher = pattern.matcher(text);
    while(matcher.find()) {

    }

    System.out.println(res);
  }

  public String newString() {
    String res = "";
    ArrayList<Integer> tmpOfInt = new ArrayList<>();

    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher = pattern.matcher(this.text);
    int start = 0;
    while (matcher.find(start)) {
      String value = this.text.substring(matcher.start(), matcher.end());
      Integer result = Integer.parseInt(value);
      System.out.println(result);
      tmpOfInt.add(result);
      start = matcher.end();
    }

    ArrayList<String> tmpOfString = new ArrayList<>();
    String[] massiveOfString = this.text.split("[^a-z && \\[ && \\]]");
    for(int i = 0; i < massiveOfString.length; i++) {
      if (massiveOfString[i].equals("")) {
        continue;
      } else {
        tmpOfString.add(massiveOfString[i]);
      }
    }

    Map<Integer, String> alfa = new LinkedHashMap<>();
    for(int i = 0; i < tmpOfString.size(); i++) {
      alfa.put(tmpOfInt.get(i), tmpOfString.get(i));
    }

    for(Map.Entry<Integer, String> item : alfa.entrySet()) {
      for(int i = 0; i < item.getKey(); i++) {
        res += item.getValue();
      }
    }

    return res;
  }

  public String unpack() {
    String res = "";
    String[] arrayOfElement = this.text.split("");
    int q = 0;
//    System.out.println(Arrays.toString(arrayOfElement));
    for(int i = 0; i < arrayOfElement.length; i++) {
      Scanner scanner = new Scanner(arrayOfElement[i]);
      ArrayList<String> y = new ArrayList<>();

      if(scanner.hasNextInt()) {
        q = scanner.nextInt();
        continue;
      }

      if(arrayOfElement[i].equals("[")) {
        int index = i;
        String tmpIf = "";
        for(int j = i + 1; j < arrayOfElement.length; j++) {
          if(!arrayOfElement[j].equals("]")) {
            index = j;
          }
        }

        for(int k = i + 1; k <= index; k++) {
          tmpIf += arrayOfElement[k];
        }

        System.out.println();

        y.add(tmpIf);
        System.out.println(Arrays.toString(y.toArray()));
      }

      if(q != 0) {
        for(int j = 0; j < q; j++) {
          res += Arrays.toString(y.toArray());
        }
      }
    }

    return res;
  }
}

class Solution {
  public int strStr(String haystack, String needle) {
    if(haystack == "" || needle == "") {
      return 0;
    }
    if(haystack.contains(needle)) {
      return haystack.indexOf(needle);
    } else {
      return -1;
    }
  }
}
