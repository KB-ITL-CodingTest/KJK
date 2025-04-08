import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        int k = 1;
        int[] answer = new int[arr.length];
        for(int i = 1; i<arr.length; i++){
            answer[0] = arr[0];
            if(arr[i] != arr[i-1]){
                answer[k] = arr[i];
                k++;
            }
        }
        int[] result = new int[k];
        for(int j = 0; j<k; j++){
            result[j] = answer[j];
        }
        return result;
    }
}
