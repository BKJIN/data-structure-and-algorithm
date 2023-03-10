package Baekjoon.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//숫자 카드
//백준 수 찾기(Ex1920)이랑 똑같은 문제
public class Ex10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] cards=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            cards[i]=Integer.parseInt(st.nextToken());
        }
        int m=Integer.parseInt(br.readLine());
        int[] arr=new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<m; i++) {
            boolean flag=false;
            int lt=0, rt=n-1;
            while(lt<=rt) {
                int mid=(lt+rt)/2;
                if(arr[i]==cards[mid]) {
                    answer.add(1);
                    flag=true;
                    break;
                }
                if(arr[i]>cards[mid]) lt=mid+1;
                else rt=mid-1;
            }
            if(!flag) answer.add(0);
        }
        StringBuilder sb = new StringBuilder();
        for(int x : answer) {
            sb.append(x+" ");
        }
        System.out.println(sb);
    }
}
