import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]){
        try{
            readWordsInFile(new Scanner(new File(args[0])), new HashMap<>());
        }catch (IOException e){
            System.out.println("El archivo no existe o la ruta es invalida, por favor verifique e intente nuevamente");
        }
    }
    private static void readWordsInFile(Scanner s, Map<String, Integer> map) {
        while (s.hasNext()) {
            map.merge(s.next(), 1, Integer::sum);
        }
        printElements(map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new)));
    }
    private static void printElements(Map<String, Integer> elements){
        elements.forEach((key,value) -> {
            System.out.println(key+" : "+value);
        });
    }
}
