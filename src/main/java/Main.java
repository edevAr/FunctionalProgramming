import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]){
        readWordsInFile(args[0], new HashMap<>());
    }

    private static void readWordsInFile(String pathFile, Map<String, Integer> map) {
        try{
            File file = new File(pathFile);

            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                map.merge(s.next(), 1, Integer::sum);
            }

            printElements(map.entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                            LinkedHashMap::new)));

        }catch (IOException e){
            System.out.println("El archivo no existe o la ruta es invalida, por favor verifique e intente nuevamente");
        }
    }
    private static void printElements(Map<String, Integer> elements){
        elements.forEach((key,value) -> {
            System.out.println(key+" : "+value);
        });
    }
}
