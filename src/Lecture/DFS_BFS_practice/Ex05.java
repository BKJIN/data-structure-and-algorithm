package Lecture.DFS_BFS_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//동전교환
public class Ex05 {

    static int sum, n, m;
    static int answer=Integer.MAX_VALUE;
    static Integer[] arr;

    public static void DFS(int L) {
        if(sum>m) return;
        if(L>=answer) return;
        if(sum==m) {
            answer=Math.min(answer,L);
        } else {
            for(int i=0; i<n; i++) { //sum+arr[i]로도 할 수 있음(풀이)
                sum+=arr[i];
                DFS(L+1);
                sum-=arr[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder()); //이거 안해주면 Time Limit Exceeded <- int 말고 객체형 Integer 사용
        m = Integer.parseInt(br.readLine());
        DFS(0);
        System.out.println(answer);
    }
}