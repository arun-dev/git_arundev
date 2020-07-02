package com.diffblue.interview.implementation;

import com.diffblue.interview.CodeLine;

public class CodeLineImpl implements CodeLine {
    /**
     * attribute for storing line numnber;
     */
    private int lineNumber;

    /**
     * attribute for storing current line
     */
    private String currentLine;

    /**
     * Constructor
     * @param lineNumber
     * @param currentLine
     */
    public CodeLineImpl(final int lineNumber, final String currentLine){
        this.lineNumber = lineNumber;
        this.currentLine = currentLine;
    }

    @Override
    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public String getContents() {
        return currentLine;
    }

}
