package Lecture.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최대 부분 증가수열(LIS)
//Baekjoon Ex11053 같은 유형
public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] dy=new int[n]; //배열 각각의 숫자를 마지막항으로 하는 최대부분증가수열 길이 저장(순서를 지켜야함)
        dy[0]=1; //0번째 숫자를 마지막항으로 하는 최대부분증가수열 -> 당연히 1
        int answer=dy[0]; //n이 1일 경우(바로 밑 for문을 돌지 않음)
        for(int i=1;i<n;i++) {
            int max=0; //앞에 자기보다 작은 숫자가 없는경우 0+1을 해야함
            for(int j=i-1; j>=0; j--) {
                if(arr[j]<arr[i] && dy[j]>max) max=dy[j];
            }
            dy[i]=max+1;
            answer=Math.max(answer,dy[i]);
        }
        System.out.println(answer);
    }
}
