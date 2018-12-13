package com.company.superme198.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderLogFiles {

    static String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        List<String> t1 = new ArrayList<>();
        List<String> t2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (logs[i].charAt(logs[i].length() - 1) <= '9' && logs[i].charAt(logs[i].length() - 1) >= '0')
                t2.add(logs[i]);
            else t1.add(logs[i]);
        }
        for (int i = 0; i < t1.size(); i++) {
            t1.sort((o1, o2) -> {
                int space1 = o1.indexOf(" ");
                int space2 = o2.indexOf(" ");
                String tmp1 = o1.substring(space1 + 1, o1.length());
                String tmp2 = o2.substring(space2 + 1, o2.length());
                return tmp1.compareTo(tmp2);

            });
        }


        for (int i = 0; i < n; i++) {
            if (i < t1.size())
                logs[i] = t1.get(i);
            else logs[i] = t2.get(Math.abs(i - t1.size()));
        }
        return logs;
    }
}
