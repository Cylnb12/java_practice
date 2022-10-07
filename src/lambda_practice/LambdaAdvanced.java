package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaAdvanced {
    public static void main(String[] args) {
         /*TASK :
        2 Boyutlu bir Multidimensional array i input kabul edip, arraydeki tüm
        elemanları bir
        listeye kopyalayan ve harf sırasına göre yazdıran bir METHOD yazınız.
        Eg : Input : {{Ali,Veli,Ayse},{Hasan,Can},{Suzan}}
           Output:[Ali, Ayse, Can, Hasan, Suzan, Veli]
         */
        String[][] arr = {{"Ali", "Veli", "Ayse"}, {"Hasan", "Can"}, {"Suzan"}};

        System.out.println(Arrays.stream(arr).
                flatMap(Arrays::stream).
                sorted()
                .collect(Collectors.toList()));



        /* TASK :
   Bir integer list oluşturunuz ve bu list’deki tum sayıların karesinin
   toplamını bulan code create ediniz.
    */
        List<Integer> numbers = new ArrayList<>(Arrays.asList(9, 4));
        System.out.println(numbers.stream().map(t -> t * t).reduce(0, (y, g) -> y + g));

        System.out.println(numbers.stream().mapToInt(t -> t * t).sum());




    }


}



