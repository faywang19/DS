package com.reverse.primary;

public class EnumUse {
    public static void main(String[] args) {
        for (Family family : Family.values()) {
            System.out.println(family+",ordinal"+family.ordinal());
        }
    }
}