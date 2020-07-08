package com.diffblue.interview;

import com.diffblue.interview.implementation.CodeLineImpl;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;


/**
 * @author Arundev P
 * @version 0.0.1
 * Class reading the file from the path and processing it.
 * @since 30 June 2020
 */
public class CodeExtractor {

    /**
     * Complete file path of file under extraction.
     */
    //private static final String extractingFile = "/gitworkspace/wrkspc1/git_arundev/test/src/sampleFiles/CreateJasper.java";
    private static final String extractingFile = "/gitworkspace/wrkspc1/git_arundev/test/src/sampleFiles/TestSuiteExample.java";
    private static boolean isATestFile = false;

    /**
     * Main method from where the application starts
     *
     * @param args
     */
    public static void main(String... args) {
        final Path path = Paths.get(extractingFile);
        try {
            if (Files.isReadable(path)) {
                isATestFile = isAJunitTestFile();
                System.out.println(isATestFile);
                Set<CodeLine> codeLineList = printContent(isATestFile);
                extractMethodName(codeLineList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to check a file is a normal java class or class with unit tests
     *
     * @return boolean
     */
    private static boolean isAJunitTestFile() throws IOException {
        Stream<String> stream = getFileContentAsStream();
        return stream.anyMatch(line -> line.contains("@RunWith") || line.contains("@Test"));
    }

    /**
     * Method will print the content of the file
     *
     * @param isPrefixRequired
     * @throws IOException
     */
    private static Set<CodeLine> printContent(final boolean isPrefixRequired) throws IOException {
        final String prefix = isPrefixRequired ? "CodeTest:" : "CodeClass";
        final Stream<String> stream = Files.lines(Paths.get(extractingFile));
        final StringBuilder lines = new StringBuilder();
        final Set<CodeLine> codeLineList = new LinkedHashSet<>();
        final AtomicInteger index = new AtomicInteger(0);
        stream.forEach(line -> {
            lines.append(prefix).append(line).append("\n");
            CodeLine codeLine = new CodeLineImpl(index.getAndIncrement(), line);
            codeLineList.add(codeLine);

        });
        System.out.println(lines.toString());
        return codeLineList;
    }


    /**
     * Returns the stream of contents from the file
     *
     * @throws IOException
     * @return Stream<String>
     */
    private static final Stream<String> getFileContentAsStream() throws IOException {
        final Stream<String> stream = Files.lines(Paths.get(extractingFile));
        return stream;
    }

    /**
     * Method that will extract the name and content of a method from the available data.
     * @param codeLines
     */
    private static final void extractMethodName(final Set<CodeLine> codeLines){
        if(isATestFile) {
            List<CodeLine> lineNumber = new LinkedList<>();
            final List<CodeLine> convertedCodeLineList = new LinkedList<>(codeLines);
            codeLines.forEach(codeLine -> {
                if (codeLine.getContents().trim().equals("@Test")){
                   lineNumber.add(codeLine);
                }
            });

        }
    }
}
