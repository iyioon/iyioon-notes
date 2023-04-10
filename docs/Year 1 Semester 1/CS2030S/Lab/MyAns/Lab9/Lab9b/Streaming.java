import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Streaming {
  public static <T> List<Pair<Integer, T>> encode(Stream<T> stream) {
    return stream.reduce(
        new ArrayList<>(),
        (list1, elem) -> {
          ArrayList<Pair<Integer, T>> list = new ArrayList<>();
          list.addAll(list1);
          if (list.size() == 0) {
            list.add(new Pair<>(1, elem));
            return list;
          }
          if (list.get(list.size() - 1).getSnd().equals(elem)) {
            list.set(list.size() - 1, new Pair<Integer, T>(list.get(list.size() - 1).getFst() + 1, elem));
            return list;
          } else {
            list.add(new Pair<>(1, elem));
            return list;
          }
        },
        (list1, list2) -> {
          ArrayList<Pair<Integer, T>> lista = new ArrayList<>();
          lista.addAll(list1);
          ArrayList<Pair<Integer, T>> listb = new ArrayList<>();
          listb.addAll(list2);

          if (lista.get(lista.size() - 1).getSnd().equals(listb.get(0).getSnd())) {
            lista.add(new Pair<>(lista.get(lista.size() - 1).getFst() + listb.get(0).getFst(),
                lista.get(lista.size() - 1).getSnd()));
            lista.remove(lista.size() - 2);
            listb.remove(0);
          }
          lista.addAll(listb);
          return lista;
        });
  }
}