package com.arun.tbscg;

import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TSBGTest2 {
    /**
     * List for storing the sequence.
     */
    private LinkedList<Integer> seqenceList = null;

    /**
     * List for storing the operands.
     */
    private LinkedList<Integer> operandList = new LinkedList<Integer>();


    public static void main(String... args) {
        String sequence = new String("0 2 0 2 2"); // hex value 4 | dec 4
        //  sequence = "0 5 0 3 3"; // hex value 2 | dec 2
        //  sequence = "0 10 0 10 4"; // hex value 64 | dec 100
        //  sequence = "0 10 0 5 5"; //hex value 2 | dec 2
        sequence = "0 10 0 5 4 0 2 5";  // hex value 19 | dec 25
        //  sequence = "0 60 0 10 3 0 180 0 3 5 4 0 50 0 5 4 3 0 2 3";   // hex value 3

        // sequence = "0 1 0 0 5"; // error
        // sequence = "0 1 0 1"; // invalid seq

        TBSCGTest test = new TBSCGTest();
        test.tbscgEngine(sequence);
    }


    /**
     * Method will accept the sequence and then process the sequence to find end result.
     * This method is exposed to outside world.
     * @param sequence
     */
    public void tbscgEngine(String sequence){
        seqenceList = Pattern.compile("\\s").splitAsStream(sequence).map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
        this.recursiveFunc.apply(seqenceList);
        //print the dec value
        operandList.forEach(System.out::println);
        //print hex value
        if (operandList.size()==1) {
            operandList.stream().map(Integer::toHexString).forEach(System.out::println);
        }else{
            System.err.println("Sequence provided is not valid");
        }
    }

    /**
     * Recursive function to apply on the sequence received.
     */
    private final UnaryOperator<LinkedList<Integer>> recursiveFunc = linkedList ->
            linkedList.size()<1 ? linkedList :
                    this.recursiveFunc.apply(this.processInstruction.apply(linkedList.pollFirst()));

    /**
     * Function to process the instruction passed from the recursive method.
     */
    private final Function<Integer,LinkedList<Integer>> processInstruction = instruction -> {
        System.out.println("instruction : "+instruction);
        switch (instruction){
            case 0:
                Integer  val = seqenceList.pollFirst();
                operandList.add(val);
                break;
            case 1:
                operandList.pollLast();
                break;
            case 2:
                if(operandList.size()>=2)
                    operandList.addLast(operandList.pollFirst()+ operandList.pollFirst());
                break;
            case 3:
                if(operandList.size()>=2)
                    operandList.addLast(operandList.pollFirst() - operandList.pollFirst());
                break;
            case 4:
                if(operandList.size()>=2)
                    operandList.addLast(operandList.pollFirst() * operandList.pollFirst());
                break;
            case 5:
                if(operandList.size()>=2) {
                    try {
                        operandList.addLast(operandList.pollFirst() / operandList.pollFirst());
                    } catch (ArithmeticException e) {
                        System.err.println("Division by zero is not supported.");
                    }
                }
                break;
        }
        return seqenceList;
    };

}
