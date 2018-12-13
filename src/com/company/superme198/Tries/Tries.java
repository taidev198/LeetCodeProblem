package com.company.superme198.Tries;


public class Tries {

    static class TriesNode{
        TriesNode[] children = new TriesNode[11];
        {for(int i =0;i<=10;i++)
            children[i] = null;}
        boolean isEndOfWord;
    }

    static void insert(String key, TriesNode root){
        int len = key.length();
        TriesNode pCawl = root;
        for (int i = 0; i < len; i++) {
            int index = key.charAt(i) - '0';
            if (pCawl.children[index] == null)
                pCawl.children[index] = new TriesNode();
            pCawl = pCawl.children[index];
        }
        pCawl.isEndOfWord = true;
    }


    static boolean search(String key, TriesNode root){

        int len = key.length();
        TriesNode pCawl = root;
        int i;
        int index;
        for ( i= 0; i <len ; i++) {
            index = key.charAt(i) - '0';
            if (pCawl.children[index] == null)
                return true;
            pCawl = pCawl.children[index];

        }

        for( i =0;i<=10; i++){
            if(pCawl.children[i] != null)
                return false;
        }
        return true;
    }


    /**Link:https://app.codesignal.com/challenge/883TZQd7mNbt97GXt
     * For listOfNum = ["911", "97625999", "91125426"], the output should be isConnectableListOfNum(listOfNum) = false.
     * Since 911 is a prefix of 91125426 the list of numbers is not error-free.
     * For listOfNum = ["113", "12340", "123440", "12345", "98346"], the output should be isConnectableListOfNum(listOfNum) = true
     * Although some of these numbers start the same, none of them are prefixes of each other, so the list is error-free.*/
    static boolean isConnectableListOfNum(String[] listOfNum) {

        TriesNode root = new TriesNode();
        for(int i =0; i< listOfNum.length; i++){

            insert(listOfNum[i], root);
        }
        for(int i =0; i< listOfNum.length; i++){
            if(!search(listOfNum[i], root))
                return false;

        }
        return true;
    }
    public static  void main(String...args){
        System.out.println(isConnectableListOfNum(new String[]{"113",
                "12340",
                "123440",
                "12345",
                "98346"}));

    }
}
