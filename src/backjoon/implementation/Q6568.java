package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6568 {
    private static int pc, adder;
    private static int[] memory = new int[32];
    private static boolean flag;
    private static StringBuilder sb = new StringBuilder();
    private static final int STA = 0, LDA = 1, BEQ = 2, NOP = 3, DEC = 4, INC = 5, JMP = 6, HLT = 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = "";

        while (true) {
            pc = 0;
            adder = 0;

            for (int i = 0; i < memory.length; i++) {
                if ((in = br.readLine()) == null) {
                    System.out.println(sb.toString());
                    return;
                }

                memory[i] = Integer.parseInt(in, 2);
            }

            while (perform(command(memory[pc]), operand(memory[pc])));
        }
    }

    private static boolean perform(int command, int operand) {
        pc = (pc + 1) % 32;
        switch (command) {
            case STA:
                memory[operand] = adder;
                break;
            case LDA:
                adder = memory[operand];
                break;
            case BEQ:
                if (adder == 0) pc = operand;
                break;
            case NOP:
                break;
            case DEC:
                adder = (adder + 255) % 256;
                break;
            case INC:
                adder = (adder + 1) % 256;
                break;
            case JMP:
                pc = operand;
                break;
            case HLT:
                for (int i = 7; i >= 0; i--) {
                    sb.append((adder >> i) & 1);
                }
                sb.append("\n");
                return false;
        }

        System.out.println("cur pc [" + pc + "] cur adder [" + adder + "]");
        return true;
    }

    private static int command(int num) {
        return num >> 5;
    }

    private static int operand(int num) {
        return num % 32;
    }
}
