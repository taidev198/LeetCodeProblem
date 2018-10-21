package com.company.superme198.BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class KeysAndRooms {


    /**Link:https://leetcode.com/problems/keys-and-rooms/description/
     * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1,
     * and each room may have some keys to access the next room.
     * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j]
     * is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
     * Initially, all the rooms start locked (except for room 0).
     * You can walk back and forth between rooms freely.
     * Return true if and only if you can enter every room.
     * Example 1:
     * Input: [[1],[2],[3],[]]
     * Output: true
     * Explanation:
     * We start in room 0, and pick up key 1.
     * We then go to room 1, and pick up key 2.
     * We then go to room 2, and pick up key 3.
     * We then go to room 3.  Since we were able to go to every room, we return true.
     * Example 2:
     * Input: [[1,3],[3,0,1],[2],[0]]
     * Output: false
     * Explanation: We can't enter the room with number 2.*/
    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int numRooms = rooms.size();
        if(numRooms == 1)//if list is null
            return true;
        List<Integer> queue = new ArrayList<>();
        boolean[] visited = new boolean[numRooms +1];
        int numRoomVisited = 1;
        queue.addAll(rooms.get(0));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i< size ;i++){
                Integer value = queue.remove(0);
                if(!visited[value] && value != 0){
                    visited[value] = true;
                    numRoomVisited++;
                    if(numRoomVisited == numRooms)
                        return true;
                    queue.addAll(rooms.get(value));
                }
            }

        }
        return false;
    }

    public static void main(String...args){

        System.out.println();

    }
}
