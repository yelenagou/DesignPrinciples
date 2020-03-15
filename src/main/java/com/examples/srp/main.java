package com.examples.srp;

import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.*;

class Journal {
    private final List<String> entries = new ArrayList<String>();
    private static int count = 0;

    public void AddEntry(String text) {
        entries.add(" " + (++count) + ": " + text);
    }
    public void RemoveEntry(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
    public void load(String filename) {}
    public void load(URL url) {}


}
class persistence{
    public void saveToFile(Journal journal, String fileName, boolean overwrite) throws Exception{
        if (overwrite || new File(fileName).exists())
            try (PrintStream out = new PrintStream(fileName)) {
                out.println(journal.toString());
            }

    }
    public void load(Journal journal, String filename) {}
    public void load(Journal journal, URL url) {}
}
class main
{
    public static void main(String[] args) throws Exception
    {
        Journal j = new Journal();
        j.AddEntry("I cried today");
        j.AddEntry("I ate a bug");
        System.out.println(j);
        String filename = "c:\\temp\\journal.txt";

        persistence persist = new persistence();
        persist.saveToFile(j, filename,true);

        Runtime.getRuntime().exec("notepad.exe " + filename);

    }
}

