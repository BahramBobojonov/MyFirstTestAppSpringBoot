package ru.bobojonov.MyFirstTestAppSpringBoot.tasks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    private List<String> stringList = new ArrayList<>();
    private Map<Integer, String> stringMap = new HashMap<>();

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam String s) {
        if (stringList.isEmpty()) {
            stringList = new ArrayList<>();
        }
        stringList.add(s);
        return "Добавление значения в ArrayList";
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return stringList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam String s) {
        if (stringMap.isEmpty()) {
            stringMap = new HashMap<>();
        }
        stringMap.put(1, s);
        return "Добавление значения в HashMap";
    }

    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        return stringMap;
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        int arrayListSize = stringList.size();
        int hashMapSize = stringMap.size();

        return "ArrayList значений: " + arrayListSize + "\nHashMap значений: " + hashMapSize;
    }
}